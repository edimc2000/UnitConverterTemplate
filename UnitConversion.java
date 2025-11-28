import java.util.*;

/**
 * Unit conversion between metric and imperial length units.
 * Provides static methods for length measurement conversions.
 * Uses meters as base unit for all conversions.
 */
public class UnitConversion {
    
    private static final Map<String, Double> CONVERSION_MAP;
    private static final Set<String> VALID_UNITS;

    static {
        Map<String, Double> tempMap = new HashMap<>();
        // Metric units (to meters)
        tempMap.put("mm", 0.001);
        tempMap.put("cm", 0.01);
        tempMap.put("m", 1.0);
        tempMap.put("km", 1000.0);

        // Imperial units (to meters)
        tempMap.put("in", 0.0254);
        tempMap.put("ft", 0.3048);
        tempMap.put("yd", 0.9144);
        tempMap.put("mi", 1609.344);
        
        CONVERSION_MAP = Collections.unmodifiableMap(tempMap);
        VALID_UNITS = Collections.unmodifiableSet(CONVERSION_MAP.keySet());
    }

    /**
     * Returns set of all available unit abbreviations.
     * @return Set of unit strings (mm, cm, m, km, in, ft, yd, mi)
     */
    public static Set<String> getAvailableUnits() {
        return VALID_UNITS;
    }

    /**
     * Gets conversion factor from meters to specified unit.
     * @param convertTo Target unit abbreviation
     * @return Conversion factor (meters to target unit)
     * @throws IllegalArgumentException if unit is not supported
     */
    public static double baseMetertoAny(String convertTo) {
        if (!CONVERSION_MAP.containsKey(convertTo)) {
            throw new IllegalArgumentException(
                "Unsupported unit: " + convertTo + ". Available units: " + getAvailableUnits());
        }
        return CONVERSION_MAP.get(convertTo);
    }

    /**
     * Converts value from one unit to another.
     * @param value Quantity to convert
     * @param baseUnit Source unit abbreviation
     * @param resultingUnit Target unit abbreviation
     * @return Converted value in target unit
     * @throws IllegalArgumentException if units are not supported
     */
    public static double convert(double value, String baseUnit, String resultingUnit) {
        double baseFactor = baseMetertoAny(baseUnit);
        double resultFactor = baseMetertoAny(resultingUnit);
        
        return (value * baseFactor) / resultFactor;
    }

    /**
     * Checks if a unit is supported for conversion.
     * @param unit Unit abbreviation to check
     * @return true if unit is supported, false otherwise
     */
    public static boolean isValidUnit(String unit) {
        return CONVERSION_MAP.containsKey(unit);
    }

    /**
     * Gets sorted list of available units for display purposes.
     * @return Alphabetically sorted list of unit abbreviations
     */
    public static List<String> getAvailableUnitsSorted() {
        List<String> sorted = new ArrayList<>(getAvailableUnits());
        Collections.sort(sorted);
        return sorted;
    }
}
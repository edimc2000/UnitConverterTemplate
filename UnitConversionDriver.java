import static java.lang.System.*;


public class UnitConversionDriver {

    public static void main(String[] args) {

        double ValueTest = 0.3048;
        String testConvertFrom = "m";
    

        for (String unit : UnitConversion.getAvailableUnits()) {
                String testConvertTo = unit;
            out.println(String.format("%8.4f %s is equal to  %8.4f %s",
                    ValueTest,
                    testConvertFrom,
                    UnitConversion.convert(ValueTest, testConvertFrom, testConvertTo),
                    testConvertTo));

        }
    }

}

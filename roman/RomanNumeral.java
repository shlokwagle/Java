public class RomanNumeral {
    private String roman;
    private int decimal;
    private RomanNumeral rm;

    public RomanNumeral() {
        roman = "";
        decimal = getDecimalValue();

    }

    public RomanNumeral(String roman) {
        this.roman = roman;
        setDecimalValue(roman);

    }

    public void setRomanValue(String roman) {
        this.roman = roman;
        setDecimalValue(roman);
    }

    public String getRomanValue() {
        return roman;
    }

    public void setDecimalValue(String roman) {
        int res = 0;

        for (int i = 0; i < roman.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = value(roman.charAt(i));

            // Getting value of symbol s[i+1]
            if (i + 1 < roman.length()) {
                int s2 = value(roman.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    res = res + s1;
                } else {
                    // Value of current symbol is
                    // less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }

        this.decimal = res;
    }

    public int getDecimalValue() {
        return decimal;
    }

    public boolean equalTo(RomanNumeral rm2) {
        rm = new RomanNumeral(roman);
        if (rm.getDecimalValue() == rm2.getDecimalValue()) {
            return true;
        } else
            return false;

    }

    public void increment() {
        String newRoman = "";
        int newDecimal = getDecimalValue() + 2;
        String[] thousands = { "", "M", "MM", "MMM" };
        String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        newRoman = thousands[newDecimal / 1000] + hundreds[(newDecimal % 1000) / 100] + tens[(newDecimal % 100) / 10]
                + units[newDecimal % 10];

        roman = newRoman;
        setDecimalValue(newRoman);
    }

    int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
}

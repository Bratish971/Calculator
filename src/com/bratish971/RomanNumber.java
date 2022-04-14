package com.bratish971;

class RomanNumber {

    int value;
    String romanValue = "";

    RomanNumber() {
        value=0;
        romanValue = null;
    }

    RomanNumber(String string) throws NumberFormatException {

        romanValue = string;

        char romanDigit;
        char nextRomanDigit;
        char[] validationBuffer = {' ',' '};

        int sum = 0;
        if (string.length()>1) {
            for (int i = 0; i < string.length() - 1; i++) {

                romanDigit = string.charAt(i);
                nextRomanDigit = string.charAt(i + 1);
                if (BasicRomanNumber.isBasicRomanNumber(romanDigit)) {

                    if (BasicRomanNumber.isBasicRomanNumber(nextRomanDigit)) {

                        if (romanDigit >= nextRomanDigit) {
                            sum = sum + BasicRomanNumber.valueOf(Character.toString(romanDigit)).convertToArabic();
                        } else {
                            sum = sum - BasicRomanNumber.valueOf(Character.toString(romanDigit)).convertToArabic();
                        }

                        if (i == string.length() - 2) {
                            sum = sum + BasicRomanNumber.valueOf(Character.toString(nextRomanDigit)).convertToArabic();
                        }

                        if ((validationBuffer[0] == validationBuffer[1]) && (validationBuffer[1] == romanDigit) &&
                                (romanDigit == nextRomanDigit)) {
                            throw new NumberFormatException();
                        }
                        validationBuffer[0] = validationBuffer[1];
                        validationBuffer[1] = romanDigit;
                    } else {
                        throw new NumberFormatException();
                    }

                } else {
                    throw new NumberFormatException();
                }

            }
        }
        else {

            romanDigit = string.charAt(0);
            if (BasicRomanNumber.isBasicRomanNumber(romanDigit)) {

                sum = BasicRomanNumber.valueOf(Character.toString(romanDigit)).convertToArabic();

            }
            else
            {
                throw new NumberFormatException();
            }

        }
        value = sum;

    }

    RomanNumber(Integer integer) {

        value = integer;

        int hundreds = integer / 100;
        int dozens = (integer - hundreds*100) / 10;
        int units = (integer - hundreds*100 - dozens*10);

        separationDigit(hundreds,100);
        separationDigit(dozens, 10);
        separationDigit(units,1);

    }

    void simpleConvert(int limit, int basicInteger) {
        for (int i= 0; i < limit; i++) {

            romanValue += BasicRomanNumber.convertFromArabic(basicInteger).toString();

        }
    }

    void separationDigit(int value, int digitFactor) {

        int fiveFactor = value / 5;

        switch (value) {
            case 0 : break;
            case 1,2,3,5,6,7,8 : {
                simpleConvert(fiveFactor,5*digitFactor);
                simpleConvert(value-fiveFactor*5, digitFactor);
                break;
            }
            case 4,9 : {
                simpleConvert(1,digitFactor);
                simpleConvert(1, (value+1)*digitFactor);
                break;
            }
        }

    }




}

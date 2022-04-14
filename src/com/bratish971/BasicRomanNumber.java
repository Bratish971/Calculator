package com.bratish971;

enum BasicRomanNumber {

    I,V,X,L,C,D,M;

    static boolean isBasicRomanNumber(char romanDigit) {

        String romanDigitString = Character.toString(romanDigit);
        for (BasicRomanNumber basicRomanNumber: BasicRomanNumber.values()) {
            if (basicRomanNumber.name().equals(romanDigitString)) {

                return true;
            }
        }

        return false;
    }

    int convertToArabic() {

        int arabicValue = 1;
        boolean isOddIteration = false;
        for (int i = 0; i < this.ordinal(); i++) {
            if (!isOddIteration) {
                arabicValue = arabicValue*5;
                isOddIteration = true;
            }
            else {
                arabicValue = arabicValue*2;
                isOddIteration = false;
            }

        }

        return arabicValue;
    }

    static BasicRomanNumber convertFromArabic(int number) {

        BasicRomanNumber basicRomanNumber = M;
        int basicRomanIndex = M.ordinal();
        int tempNumber = 1000;
        boolean isOddIteration = false;
        while (number < tempNumber) {
            if (!isOddIteration) {
                tempNumber = tempNumber/2;
                isOddIteration = true;
            }
            else {
                tempNumber = tempNumber/5;
                isOddIteration = false;
            }
            basicRomanIndex--;
            basicRomanNumber = BasicRomanNumber.values()[basicRomanIndex];
        }

        return basicRomanNumber;

    }

}

package com.bratish971;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }

    public static String calc(String input) {

        String[] numbers = input.split(" ");
        if (numbers.length != 3) {
            throw new NumberFormatException("Выражение должно иметь формат <число> <оператор> <число>");
        }
        int leftNumber;
        int rightNumber;
        RomanNumber leftRomanNumber = null;
        RomanNumber rightRomanNumber;

        try {
            leftNumber = Integer.parseInt(numbers[0]);
            rightNumber = Integer.parseInt(numbers[2]);
        }
        catch (NumberFormatException e) {
            try {
                leftRomanNumber = new RomanNumber(numbers[0]);
                rightRomanNumber = new RomanNumber(numbers[2]);
                leftNumber = leftRomanNumber.value;
                rightNumber = rightRomanNumber.value;
            }
            catch (NumberFormatException exception)
            {
                throw new NumberFormatException(
                        "Формат чисел не соответствует римским или арабским целочисленным выражениям");
            }
        }

        Integer result;

        if ((leftNumber >= 1) && (leftNumber <= 10) && (rightNumber >= 1) && (rightNumber <= 10)) {

            result = calculateIntegers(leftNumber, rightNumber, numbers[1].charAt(0));
        }
        else
        {
            throw new NumberFormatException("Калькулятор работает только с числами от 1 до 10");
        }
        if (leftRomanNumber != null) {
            if (result >= 1) {
                RomanNumber romanNumber = new RomanNumber(result);
                return romanNumber.romanValue;
            }
            else
            {
                throw new NumberFormatException(
                        "Результат действия над римскими числами не может быть отрицательным, либо равным нулю");
            }
        }

        return result.toString();

    }

    public static Integer calculateIntegers(int number1,int number2, char operation) {

        return switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            default -> null;
        };
    }
}

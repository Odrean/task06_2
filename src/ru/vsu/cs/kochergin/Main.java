package ru.vsu.cs.kochergin;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readNumber("x");
        int n = (int) readNumber("n");
        double e = readNumber("e");

        double sumOfSequence = calculateSumOfSequence(x, n);
        double sumOfSequenceMoreThanE = calculateSumOfSequenceMoreThanE(x, n, e);
        double sumOfSequenceMoreThanEDividedByTen = calculateSumOfSequenceMoreThanE(x, n, e/10);
        double valueOfFunction = calculateValueOfFunction(x, n);

        System.out.printf("Сумма n слагаемых: %.2f%n", sumOfSequence);
        System.out.printf("Сумма тех слагаемых, которые по абсолютной величине больше e: %.2f%n",
                sumOfSequenceMoreThanE);
        System.out.printf("Сумма тех слагаемых, которые по абсолютной величине больше e/10: %.2f%n",
                sumOfSequenceMoreThanEDividedByTen);
        System.out.printf("Значение функции: %.2f%n", valueOfFunction);
    }

    private static double readNumber(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Input value for %s: ", name);

        while (!scanner.hasNextDouble()) {
            System.out.println("Wrong value. Value for n must be integer and for x, e must be double");
            System.out.printf("Input value for %s: ", name);

            scanner.next();
        }

        return scanner.nextDouble();
    }

    private static double calculateSumOfSequence(double x, int n) {
        double sum = 0;

        for (int i = 0; i <= n; i++) {
            sum += getMemberOfSequence(x, i);
        }

        return sum;
    }

    private static double calculateSumOfSequenceMoreThanE(double x, int n, double e) {
        double sum = 0;

        for (int i = 0; i <= n; i++) {
            double memberOfSequence = getMemberOfSequence(x, i);

            if (Math.abs(memberOfSequence) > e) {
                sum += memberOfSequence;
            }
        }

        return sum;
    }

    private static double calculateValueOfFunction(double x, double e) {
        return Math.pow(e, -(x * x));
    }

    private static double getMemberOfSequence(double x, int n) {
        return Math.pow(-1, n) * (Math.pow(x, 2 * n) / getFactorial(n)) ;
    }

    private static double getFactorial(int f) {
        double factorial = 1;

        for (int i = 1; i <= f; i++) {
            factorial *= i;
        }

        return factorial;
    }
}

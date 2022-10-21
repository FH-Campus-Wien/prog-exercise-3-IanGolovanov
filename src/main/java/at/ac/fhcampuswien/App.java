package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar (int numberDay, int startingDay) {
        int count;
        for (int i = 1; i < startingDay; i++) {
            System.out.print("   ");
        }
        count = startingDay;
        for (int i = 1; i <= numberDay ; i++) {
            if (count++ % 7 == 1) {
                System.out.println();
            }
            System.out.printf("%2d ", i);
        }
        System.out.println();
    }

    public static long[] lcg(long seed) {
        long [] randomNumbers = new long [10];
        long a = 1103515245;
        long c = 12345;
        double m = Math.pow(2, 31);

        for (int i = 0; i < randomNumbers.length; i++) {
            if (i == 0) {
                randomNumbers[i] = ((a * seed) + c) % (long) m;
            } else {
                randomNumbers[i] = ((a * randomNumbers[i - 1]) + c) % (long) m;
            }
            //randomNumbers[i] = i;
        }
        return randomNumbers;
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random rand = new Random();
        return rand.nextInt(100) + 1; //tried to write 101 but had to write 100 + 1 instead, don't know why lol
    }

    public static void guessingGame (int numberToGuess) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i < 11 ; i++) {
            System.out.print("Guess number " + i + ": ");
            int number = scanner.nextInt();
            if (number < numberToGuess && i < 10) {
                System.out.println("The number AI picked is higher than your guess.");
            } else if (number > numberToGuess && i < 10) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (number == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            } else if (i == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
            }
        }
    }

    public static boolean swapArrays (int [] array1, int [] array2) {
        if (array1.length == array2.length) {
            int [] buffer = new int [array1.length];
            for (int i = 0; i < array1.length; i++) {
                buffer [i] = array1 [i];
                array1 [i] = array2 [i];
                array2 [i] = buffer [i];
            }
            return true;
        } else {
            return false;
        }
    }

    public static String camelCase (String text) {

        return text;
    }

    public static int checkDigit (int [] code) {
        int sum = 0;
        int weight = 2;
        int controlNumber = 0;

        for (int i = 0; i < code.length; i++) {
            sum = sum + (code [i] * (weight + i));
        }
        controlNumber = 11 - (sum % 11);
        if (controlNumber == 10) {
            controlNumber = 0;
        } else if (controlNumber == 11) {
            controlNumber = 5;
        }
        return controlNumber;
    }
    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        long [] randomN = lcg(0);

        int numberGuess = randomNumberBetweenOneAndHundred();
        guessingGame(numberGuess);
    }
}
package com.arcreane;

import java.util.Random;

public class Calculs {
    private static Random rand = new Random();
    public static void playGame() {
        System.out.println("Select difficulty(1,2,3)");
        int choice = Main.scanner.nextInt();
        int numberToGuess = 0;
        switch (choice) {
            case 1-> numberToGuess = addition();
            case 2-> numberToGuess = soustraction();
            case 3-> numberToGuess = multiplication();
        }
        System.out.println("Make your guess");
        int userGuess = Main.scanner.nextInt();
        if (userGuess == numberToGuess)
            System.out.println("Congrats");
        else
            System.out.println("Too bad the result was " + numberToGuess);
    }

    private static int multiplication() {
        return calculation(-100,100,"*");
    }

    private static int soustraction() {
        return calculation(-300,300,"-");
    }

    private static int addition() {
       //blaccl
        return calculation(500,900,"+");

    }

    private static int calculation(int boundMin, int boundMax, String operator){
        int result = 0;

        int[] numbers = new int[4];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = boundMin + rand.nextInt(boundMax - boundMin);
        }
        System.out.println("What is the result of : ");
        for (int i = 0; i <numbers.length; i++) {
            if(operator.equals("+")){
                result += numbers[i];
            }
            else if(operator.equals("-")){
                result -= numbers[i];
            }
            else if(operator.equals("*")){
                result *= numbers[i];
            }
            System.out.print(numbers[i]);
            if (i < numbers.length-1)
                System.out.print(operator);
        }
        System.out.println();
        return result;
    }
}

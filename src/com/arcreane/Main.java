package com.arcreane;

import java.util.Scanner;

public class Main {

    //Exercice 1 : Calcul des remises
    public static void main(String[] args) {
        calculateHardRefund();
        calculateDynamicRefund();
    }

    private static void calculateDynamicRefund() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the original price");
        float price = scanner.nextFloat();

        System.out.println("How many refunds do you want to apply");
        int nbRefunds = scanner.nextInt();

        float[] refunds = new float[nbRefunds];
        System.out.println("Enter your values, all in one line separated by space or one after another" +
                "\nPlease give them in descending order");
        for (int i = 0; i < nbRefunds; i++) {
            refunds[i] = scanner.nextFloat();
            if (i > 0 && refunds[i]> refunds[i-1]) {
                System.out.println("I said it was to be in descending order only!!! (asshole)");
                scanner.nextLine();
                System.out.println("Restart from the beginning");
                i = -1;
            }
        }

        calculateRefunds(price, refunds);
    }

    private static void calculateRefunds(float price, float[] refunds) {
        float finalPrice = price;
        //Check if all refunds are in decreasing order
        for (int i = 1; i < refunds.length; i++) {
            if(refunds[i-1] < refunds[i] ){
                System.out.println("Error in refunds order, cannot calculate final price (must be in descending order)");
                return;
            }
        }

        for (int i = 0; i <refunds.length; i++) {
            finalPrice = finalPrice - finalPrice*refunds[i];
        }
        System.out.println("The final price is : " + finalPrice);
    }

    private static void calculateHardRefund() {
        float price = 10;
        float refund1 = 0.5f;
        float refund2 = 0.3f;

        float priceFirstRefund = (price - (price * refund1));
        float priceSecondRefund = (priceFirstRefund - (priceFirstRefund* refund2));
        System.out.println(priceSecondRefund);
    }
}

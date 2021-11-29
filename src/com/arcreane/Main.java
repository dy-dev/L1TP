package com.arcreane;

public class Main {

    //Exercice 1 : Calcul des remises
    public static void main(String[] args) {
	    float price = 10;
        float refund1 = 0.5f;
        float refund2 = 0.3f;

        calculateRefund(price, refund1, refund2);
    }

    private static void calculateRefund(float price, float refund1, float refund2) {
        float priceFirstRefund = (price - (price * refund1));
        float priceSecondRefund = (priceFirstRefund - (priceFirstRefund* refund2));
    }
}

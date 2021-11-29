package com.arcreane;

public class PaidAccount {
    public static void calculateInvestment() {
        System.out.println("Welcome the coding academy bank, how much would you like to invest");
        int money = Main.scanner.nextInt();
        System.out.println("Choose your interest rate");
        float rate = Main.scanner.nextFloat();
        System.out.println("For how long in years ?");
        int years = Main.scanner.nextInt();

        float profit = calculateInvestment(money,rate,years);
        System.out.println("Your loan will cost you : " + profit);
    }

    private static float calculateInvestment(int money, float rate, int years) {
        return money * (1 + rate*years);
    }
}

package com.arcreane;

import java.util.DoubleSummaryStatistics;

public class Loan {

    public static void takeLoan() {
        System.out.println("Welcome the coding academy bank, how much would you likt to borrow");
        int money = Main.scanner.nextInt();
        System.out.println("What interest rate");
        float rate = Main.scanner.nextFloat();
        System.out.println("For how long?");
        int months = Main.scanner.nextInt();
        System.out.println("What insurance rate");
        float insurancerate = Main.scanner.nextFloat();

        float cost = calculateLoanPrice(money,rate,months,insurancerate);
        System.out.println("Your loan will cost you : " + cost);
    }

    public static float calculateLoanPrice(
            int loanedMoney,
            float interestRate,
            int monthNumber,
            float insuranceRate
    ) {
        float monthlyRate = interestRate/12.f;
        float mensualities = (loanedMoney * monthlyRate);
        mensualities /= (1 - Math.pow ((1+monthlyRate), -monthNumber));
        float totalPrice = mensualities * monthNumber;
        float insuranceCost = (insuranceRate * loanedMoney * monthNumber )/ 12.f;
        return totalPrice - loanedMoney + insuranceCost;
    }
}

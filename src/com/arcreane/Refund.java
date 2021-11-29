package com.arcreane;

public class Refund {

    public static float calculateDynamicRefund() {
        System.out.println("Enter the original price");
        float price = Main.scanner.nextFloat();

        System.out.println("How many refunds do you want to apply");
        int nbRefunds = Main.scanner.nextInt();

        float[] refunds = new float[nbRefunds];
        System.out.println("Enter your values, all in one line separated by space or one after another" +
                "\nPlease give them in descending order");
        for (int i = 0; i < nbRefunds; i++) {
            refunds[i] = Main.scanner.nextFloat();
            if (i > 0 && refunds[i] > refunds[i - 1]) {
                System.out.println("I said it was to be in descending order only!!! (asshole)");
                Main.scanner.nextLine();
                System.out.println("Restart from the beginning");
                i = -1;
            }
        }

        return calculateRefunds(price, refunds);
    }

    public static float calculateRefunds(float price, float[] refunds) {
        float finalPrice = price;
        //Check if all refunds are in decreasing order
        for (int i = 1; i < refunds.length; i++) {
            if (refunds[i - 1] < refunds[i]) {
                System.out.println("Error in refunds order, cannot calculate final price (must be in descending order)");
                return 0.0f;
            }
        }

        for (int i = 0; i < refunds.length; i++) {
            finalPrice = finalPrice - finalPrice * refunds[i];
        }
        System.out.println("The final price is : " + finalPrice);
        return finalPrice;
    }

    public static void calculateHardRefund() {
        float price = 10;
        float refund1 = 0.5f;
        float refund2 = 0.3f;

        float priceFirstRefund = (price - (price * refund1));
        float priceSecondRefund = (priceFirstRefund - (priceFirstRefund * refund2));
        System.out.println(priceSecondRefund);
    }

    public static void pay(float price) {
        int totalAmount = 0;
        do {
            System.out.println("Please pay " + price + " with 20 dollar bills");
            System.out.println("Indicate how many bills you're passing");
            int nbBills = Main.scanner.nextInt();
            totalAmount = 20 * nbBills;
        } while (totalAmount < price);

        float amountToReturn = totalAmount - price;
        System.out.println("I have to return " + amountToReturn+"$");

        float[] bills = {500, 200, 100, 50, 20, 10, 5};
        System.out.println("Giving back ");
        amountToReturn = getAmountToReturn(amountToReturn, bills, 1 , "bills");

        float[] coins = {2.f, 1.f, 0.5f, 0.2f, 0.1f, 0.05f, 0.01f};
        amountToReturn = getAmountToReturn(amountToReturn, coins, 100 , "coins");
//        for (float coin: coins) {
//            int nbCoin = (int) ((amountToReturn*100) / (coin*100));
//            if (nbCoin != 0)
//                System.out.println(nbCoin + " of " + coin +"$ coins");
//            amountToReturn -= nbCoin*coin;
//        }

        System.out.println("The amount to return is : " + amountToReturn);
    }

    private static float getAmountToReturn(float amountToReturn, float[] changes, float factor, String type) {
        for (float change : changes) {
            int nbChange = (int) ((amountToReturn*factor) / (change*factor));
            if (nbChange != 0)
                System.out.println(nbChange + " of " + change +"$ " + type);
            amountToReturn -= nbChange*change;
        }
        return amountToReturn;
    }
}

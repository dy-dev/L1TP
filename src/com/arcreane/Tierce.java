package com.arcreane;

import javax.annotation.processing.SupportedSourceVersion;
import java.math.BigInteger;

public class Tierce {
    public static BigInteger factorial(int number) {
        BigInteger result = BigInteger.valueOf(1);

        for (int factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }

    public static void winningOdds() {
        System.out.println("How many horses are running");
        int horsesNb = Main.scanner.nextInt();
        System.out.println("How many horses are played");
        int horsesPlayedNb = Main.scanner.nextInt();

        float[] odds = brutasseCalculation(horsesNb, horsesPlayedNb);
        System.out.println("The winning chances are :");
        System.out.println("In order it is one chance over " + odds[0]);
        System.out.println("In disorder it is one chance over " + odds[1]);

        float[] oddssmart = smartCalculation(horsesNb, horsesPlayedNb);
        System.out.println("The smart winning chances are :");
        System.out.println("In order it is one chance over " + oddssmart[0]);
        System.out.println("In disorder it is one chance over " + oddssmart[1]);

        calculateDuration(horsesNb, horsesPlayedNb);
    }

    private static void calculateDuration(int horsesNb, int horsesPlayedNb) {
        long startTime = System.nanoTime();
        brutasseCalculation(horsesNb, horsesPlayedNb);
        long stopTime = System.nanoTime();

        long elapsedTime = stopTime - startTime;
        System.out.println((float) (elapsedTime / Math.pow(10, 9)));

        startTime = System.nanoTime();
        smartCalculation(horsesNb, horsesPlayedNb);
        stopTime = System.nanoTime();

        elapsedTime = stopTime - startTime;

        System.out.println((float) (elapsedTime / Math.pow(10, 9)));
    }

    private static float[] smartCalculation(int horsesNb, int horsesPlayedNb) {
        BigInteger N = BigInteger.valueOf(horsesNb);
        BigInteger orderedVariation = BigInteger.valueOf(horsesNb);
        BigInteger factorielP = BigInteger.valueOf(1);

        BigInteger i = BigInteger.valueOf(1);
        while (i.compareTo(BigInteger.valueOf(horsesPlayedNb)) == -1) {
            orderedVariation = orderedVariation.multiply(N.subtract(i));
            factorielP = factorielP.multiply(i);
            i = i.add(BigInteger.valueOf(1));
        }
        float[] odds = new float[2];
        odds[0] = orderedVariation.floatValue();
        odds[1] = (orderedVariation.divide(factorielP)).floatValue();
        return odds;
    }

    private static float[] brutasseCalculation(int horsesNb, int horsesPlayedNb) {
        float[] odds = new float[2];
        BigInteger odd = factorial(horsesNb).divide(factorial(horsesNb - horsesPlayedNb));
        odds[0] = odd.floatValue();
        odd = factorial(horsesNb).divide(factorial(horsesPlayedNb).multiply(factorial(horsesNb - horsesPlayedNb)));
        odds[1] = odd.floatValue();
        return odds;
    }
}

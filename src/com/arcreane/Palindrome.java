package com.arcreane;

public class Palindrome {
    public static void play() {
        System.out.println("Give me your plaindrome wanna be");
        String palinWannabe = Main.scanner.nextLine();
        palinWannabe.toLowerCase().replaceAll(" ", "");

//        palinWannabe = cleanUpWithoutRegex(palinWannabe);
        palinWannabe = cleanUpWithRegex(palinWannabe);

        boolean isPalin = checkPalindromeWithFor(palinWannabe);
        isPalin = checkPalindromeWithStringBuffer(palinWannabe);
    }

    private static String cleanUpWithRegex(String palinWannabe) {
        return palinWannabe.replaceAll("\\W", "");
    }

    private static String cleanUpWithoutRegex(String palinWannabe) {
        String resultStr = "";
        //loop execute till the length of the string
        for (int i = 0; i < palinWannabe.length(); i++) {
//comparing alphabets with their corresponding ASCII value
            if (palinWannabe.charAt(i) > 64 && palinWannabe.charAt(i) <= 90) //returns true if both conditions returns true
            {
//adding characters into empty string
                resultStr = resultStr + palinWannabe.charAt(i);
            }
        }
        return resultStr;
    }

    private static boolean checkPalindromeWithStringBuffer(String palinWannabe) {
        StringBuffer sb = new StringBuffer(palinWannabe);
        sb.reverse();
        return palinWannabe.equals(sb.toString());
    }

    private static boolean checkPalindromeWithFor(String palinWannabe) {
        int len = palinWannabe.length();
        char[] arrayOfPalin = palinWannabe.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (arrayOfPalin[i] != arrayOfPalin[len - i - 1]) {
                System.out.println("Fail");
                return false;
            }
        }

        //Autre facon strictement équivalent à celle ci
        for (int i = 0; i < len / 2; i++) {
            if (palinWannabe.charAt(i) != palinWannabe.charAt(len - i - 1))
                System.out.println("Fail");
            return false;
        }

        return true;
    }
}

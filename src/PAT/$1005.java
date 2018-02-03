package PAT;

import java.util.Scanner;

public class $1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        spellItRight(str);
    }

    public static void spellItRight(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        String sumStr = sum + "";
        for (int i = 0; i < sumStr.length(); i++) {
            printCharNumber(sumStr.charAt(i));
            if (i != sumStr.length() - 1) System.out.print(" ");
        }
    }

    public static void printCharNumber(char c) {
        String number = "";
        switch (c) {
            case '0':
                number = "zero";
                break;
            case '1':
                number = "one";
                break;
            case '2':
                number = "two";
                break;
            case '3':
                number = "three";
                break;
            case '4':
                number = "four";
                break;
            case '5':
                number = "five";
                break;
            case '6':
                number = "six";
                break;
            case '7':
                number = "seven";
                break;
            case '8':
                number = "eight";
                break;
            case '9':
                number = "nine";
                break;
        }
        System.out.print(number);
    }
}

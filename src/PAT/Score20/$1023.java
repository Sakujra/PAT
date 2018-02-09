package PAT.Score20;

import java.math.BigInteger;
import java.util.Scanner;

public class $1023 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n1 = scanner.next();
        if (isDoubling(n1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        BigInteger big1 = new BigInteger(n1);
        System.out.println(big1.multiply(new BigInteger("2")));
    }


    public static boolean isDoubling(String str1) {
        BigInteger n1 = new BigInteger(str1);
        BigInteger n2 = n1.multiply(new BigInteger("2"));
        String str2 = n2.toString();
        if (str1.length() != str2.length()) return false;
        int[] arr1 = new int[10];
        for (int i = 0; i < str1.length(); i++) {
            int index = str1.charAt(i) - '0';
            arr1[index]++;
        }
        int[] arr2 = new int[10];
        for (int i = 0; i < str2.length(); i++) {
            int index = str2.charAt(i) - '0';
            arr2[index]++;
        }
        for (int i = 0; i < 10; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}

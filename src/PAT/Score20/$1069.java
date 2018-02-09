package PAT.Score20;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class $1069 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        String initN = cin.next();
        long start = System.currentTimeMillis();
        char[] chars = initN.toCharArray();
        boolean isTheSame = true;
        for (int i = 1; i < 4; i++) {
            if (chars[i] != chars[i - 1]) {
                isTheSame = false;
                break;
            }
        }
        if (isTheSame) {
            System.out.println(initN + " - " + initN + " = 0000");
            return;
        }
        while (!new String(chars).equals("6174")) {
            Arrays.sort(chars);
            String str2 = new String(chars);
            int len = chars.length;
            for (int i = 0; i < len / 2; i++) {
                char tmp = chars[i];
                chars[i] = chars[len - i - 1];
                chars[len - i - 1] = tmp;
            }
            String str1 = new String(chars);
            int resInt = Integer.parseInt(str1) - Integer.parseInt(str2);
            String resStr = resInt + "";
            printResult(str1, str2, resStr);
            chars = resStr.toCharArray();
        }
        long end = System.currentTimeMillis();
        System.out.println("time：" + (end - start));
    }

    private static void printResult(String str1, String str2, String strR) {
        StringBuilder builder = new StringBuilder();
        int i1 = 4 - str1.length();
        int i2 = 4 - str2.length();
        for (int i = 0; i < i1; i++) {
            builder.append('0');
        }
        builder.append(str1 + " - ");
        for (int i = 0; i < i2; i++) {
            builder.append('0');
        }
        builder.append(str2 + " = " + strR);
        System.out.println(builder);
    }


}

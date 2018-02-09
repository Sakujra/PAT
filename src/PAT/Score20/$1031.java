package PAT.Score20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $1031 {

    public static void main(String[] args) {
        BufferedReader stringBuffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = stringBuffer.readLine();
            printU(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printU(String str) {
        int len = str.length();
        int width = (len + 2) / 3 + (len + 2) % 3;
        int height = (len + 2) / 3 - 1;
        char[] arrH1 = new char[height];
        char[] arrH2 = new char[height];
        char[] arrW = new char[width];
        for (int i = 0; i < height; i++) {
            arrH1[i] = str.charAt(i);
        }
        for (int i = 0; i < height; i++) {
            arrH2[i] = str.charAt(len - i - 1);
        }
        for (int i = 0; i < width; i++) {
            arrW[i] = str.charAt(height + i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < width - 2; i++) {
            builder.append(" ");
        }
        for (int i = 0; i < height; i++) {
            System.out.println(arrH1[i] + builder.toString() + arrH2[i]);
        }
        for (int i = 0; i < width; i++) {
            System.out.print(arrW[i]);
        }
        System.out.println();
    }
}

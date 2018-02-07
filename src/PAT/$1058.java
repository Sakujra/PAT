package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $1058 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strArr = reader.readLine().split(" ");
            String firstStr = strArr[0];
            String secondStr = strArr[1];
            int firstDot1 = firstStr.indexOf('.');
            int firstDot2 = firstStr.lastIndexOf('.');
            int secondDot1 = secondStr.indexOf('.');
            int secondDot2 = secondStr.lastIndexOf('.');
            int a1 = Integer.parseInt(firstStr.substring(0, firstDot1));
            int b1 = Integer.parseInt(firstStr.substring(firstDot1 + 1, firstDot2));
            int c1 = Integer.parseInt(firstStr.substring(firstDot2 + 1));
            int a2 = Integer.parseInt(secondStr.substring(0, secondDot1));
            int b2 = Integer.parseInt(secondStr.substring(secondDot1 + 1, secondDot2));
            int c2 = Integer.parseInt(secondStr.substring(secondDot2 + 1));
            int c3 = c1 + c2;
            int b3 = b1 + b2;
            int a3 = a1 + a2;
            int c = c3 % 29;
            b3 += c3 / 29;
            int b = b3 % 17;
            a3 += b3 / 17;
            int a = a3;
            StringBuilder builder = new StringBuilder();
            builder.append(a + ".");
            builder.append(b + ".");
            builder.append(c);
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

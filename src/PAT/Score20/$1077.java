package PAT.Score20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $1077 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(reader.readLine());
            StringBuilder builder = new StringBuilder(reader.readLine());
            builder.reverse();
            boolean isnai = false;
            for (int i = 1; i < count; i++) {
                String inputLine = reader.readLine();
                int len1 = builder.length();
                if (len1 == 0) {
                    isnai = true;
                    break;
                }
                int len2 = inputLine.length();
                int min = len1 < len2 ? len1 : len2;
                StringBuilder newBuilder = new StringBuilder();
                for (int j = 0; j < min; j++) {
                    char c1 = builder.charAt(j);
                    char c2 = inputLine.charAt(len2 - j - 1);
                    if (c1 == c2) {
                        newBuilder.append(c1);
                    } else {
                        builder = newBuilder;
                        break;
                    }
                }
            }
            if (isnai) {
                System.out.println("nai");
            } else {
                System.out.println(builder.reverse());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

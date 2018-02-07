package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $1027 {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] arr = bufferedReader.readLine().split(" ");
            bufferedReader.close();
            System.out.print("#");
            System.out.print(changeRadix(Integer.parseInt(arr[0])));
            System.out.print(changeRadix(Integer.parseInt(arr[1])));
            System.out.print(changeRadix(Integer.parseInt(arr[2])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String changeRadix(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            int mod = n % 13;
            char c = (char)(mod + '0');
            switch (mod) {
                case 10:
                    c = 'A';
                    break;
                case 11:
                    c = 'B';
                    break;
                case 12:
                    c = 'C';
                    break;
            }
            if (mod == 0) {
                stringBuilder.append('0');
            } else {
                stringBuilder.append(c);
            }
            n /= 13;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}

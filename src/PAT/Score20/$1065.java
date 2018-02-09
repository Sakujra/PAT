package PAT.Score20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class $1065 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                String[] numbers = reader.readLine().split(" ");
                BigInteger a = new BigInteger(numbers[0]);
                BigInteger b = new BigInteger(numbers[1]);
                BigInteger c = new BigInteger(numbers[2]);
                boolean bool = false;
                if ((a.add(b).compareTo(c)) > 0) {
                    bool = true;
                }
                System.out.println("Case #" + (i + 1) + ": " + bool);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

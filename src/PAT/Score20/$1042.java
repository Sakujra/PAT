package PAT.Score20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $1042 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int times = Integer.parseInt(reader.readLine());
            String[] strArr = reader.readLine().split(" ");
            int COUNT = 54;
            int[] orderArr = new int[COUNT];
            for (int i = 0; i < COUNT; i++) {
                orderArr[i] = Integer.parseInt(strArr[i]);
            }
            String[] first = {
                    "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13",
                    "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13",
                    "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13",
                    "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13",
                    "J1", "J2"
            };
            String[] second = new String[54];
            for (int i = 0; i < times; i++) {
                for (int j = 0; j < COUNT; j++) {
                    second[orderArr[j] - 1] = first[j];
                }
                first = second.clone();
            }
            for (int i = 0; i < COUNT; i++) {
                System.out.print(first[i]);
                if (i != COUNT - 1)
                    System.out.print(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

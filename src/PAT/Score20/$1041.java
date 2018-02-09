package PAT.Score20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $1041 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] arrStr = reader.readLine().split(" ");
            int[][] arrValue = new int[10001][2];
            for (int i = 1; i < arrStr.length; i++) {
                int index = Integer.parseInt(arrStr[i]);
                arrValue[index][0]++;
                arrValue[index][1] = i;
            }
            int minSeq = Integer.MAX_VALUE;
            int first = -1;
            for (int i = 1; i < arrValue.length; i++) {
                if (arrValue[i][0] == 1) {
                    if (arrValue[i][1] < minSeq) {
                        minSeq = arrValue[i][1];
                        first = i;
                    }
                }
            }
            if (first!=-1) {
                System.out.println(first);
            }else{
                System.out.println("None");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

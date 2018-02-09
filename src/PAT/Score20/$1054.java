package PAT.Score20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class $1054 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] firstLine = reader.readLine().split(" ");
            int M = Integer.parseInt(firstLine[0]);
            int N = Integer.parseInt(firstLine[1]);
            Map<Integer, Integer> map = new HashMap<>();
            int dominant = -1;
            int times = 0;
            for (int i = 0; i < N; i++) {
                String[] numberArr = reader.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    int key = Integer.parseInt(numberArr[j]);
                    int value = 0;
                    Object o = map.get(key);
                    if (o != null) {
                        value = (int) o;
                    }
                    value++;
                    if (value > times) {
                        dominant = key;
                        times = value;
                    }
                    map.put(key, value);
                }
            }
            System.out.println(dominant);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

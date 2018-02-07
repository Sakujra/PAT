package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class $1050 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            char[] str1 = reader.readLine().toCharArray();
            char[] str2 = reader.readLine().toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str2.length; i++) {
                map.put(str2[i], 1);
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str1.length; i++) {
                if (map.getOrDefault(str1[i], 0) == 0) {
                    builder.append(str1[i]);
                }
            }
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

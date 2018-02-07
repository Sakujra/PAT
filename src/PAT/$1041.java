package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class $1041 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] arrStr = reader.readLine().split(" ");
            int count = Integer.parseInt(arrStr[0]);
            Map<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 1; i < count; i++) {
                Integer key = Integer.parseInt(arrStr[i]);
                Integer value = 0;
                if (map.containsKey(key)) {
                    value = map.get(key);
                    value++;
                }
                map.put(key, value);
            }
            boolean hasWin = false;
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry i = (Map.Entry) it.next();
                int key = (int) i.getKey();
                int value = (int) i.getValue();
                if (value == 0) {
                    hasWin = true;
                    System.out.println(key);
                    break;
                }
            }
            if(!hasWin) System.out.println("None");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

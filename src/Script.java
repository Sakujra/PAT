import PAT.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Script {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = reader.readLine().split(" ");
            int caseCount = Integer.parseInt(strings[0]);
            for (int seq = 0; seq < caseCount; seq++) {
                strings = reader.readLine().split(" ");
                int m = Integer.parseInt(strings[0]);
                int n = Integer.parseInt(strings[1]);
                UnionFindSet set = new UnionFindSet(m);
                for (int i = 0; i < n; i++) {
                    strings = reader.readLine().split(" ");
                    int c1 = Integer.parseInt(strings[0]);
                    int c2 = Integer.parseInt(strings[1]);
                    set.union(set.find(c1), set.find(c2));
                }
                System.out.println(set.getMaxSizeOfParts() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

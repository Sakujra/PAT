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
            int N = Integer.parseInt(strings[0]);
            int M = Integer.parseInt(strings[1]);
            Prim graph = new Prim(N);
            for (int i = 0; i < M; i++) {
                strings = reader.readLine().split(" ");
                int from = Integer.parseInt(strings[0]);
                int to = Integer.parseInt(strings[1]);
                int cost = Integer.parseInt(strings[2]);
                graph.insertEdge(from, to, cost);
            }
            graph.primMST(2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

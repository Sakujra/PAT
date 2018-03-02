package PAT.Score25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;

public class Saving007_EasyVersion {

    private class GNode {
        int x;
        int y;
        boolean visited = false;
        boolean adjcentToBank = false;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            String[] strings = line.split(" ");
            int N = Integer.parseInt(strings[0]);
            int D = Integer.parseInt(strings[1]);
            GNode[] nodes = new GNode[N];
            for (int i = 0; i < N; i++) {
                strings = reader.readLine().split(" ");
                nodes[i].x = Integer.parseInt(strings[0]);
                nodes[i].y = Integer.parseInt(strings[1]);
                if (50 - abs(nodes[i].x) <= D) nodes[i].adjcentToBank = true;
                if (50 - abs(nodes[i].y) <= D) nodes[i].adjcentToBank = true;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static int abs(int n) {
        if (n < 0) return -n;
        return n;
    }
}

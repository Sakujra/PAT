package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTransfer {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(reader.readLine());
            int[] items = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                items[i] = -1;
            }
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(" ");
                if (strings[0].equals("S")) break;

                int first = Integer.parseInt(strings[1]);
                int second = Integer.parseInt(strings[2]);

                if (strings[0].equals("C")) {
                    if (find(items, first) == find(items, second)) {
                        builder.append("yes\n");
                    } else {
                        builder.append("no\n");
                    }
                } else if (strings[0].equals("I")) {
                    union(items, find(items, first), find(items, second));
                }
            }

            int partCount = 0;
            for (int i = 1; i < N + 1; i++) {
                if (items[i] < 0) partCount++;
            }

            System.out.print(builder);
            if (partCount == 1) System.out.println("The network is connected.");
            else System.out.println("There are " + partCount + " components.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static int find(int[] items, int x) {
//        int parent = items[x];
//        while (parent > 0) {
//            parent = items[parent];
//        }
//        return parent;

        if (items[x] < 0)
            return x;
        else
            return items[x] = find(items, items[x]);
    }

    static void union(int[] items, int root1, int root2) {
        if (items[root1] > items[root2]) {
            //root2大
            //更新大小
            items[root2] += items[root1];
            items[root1] = root2;
        } else {
            //root1大
            items[root1] += items[root2];
            items[root2] = root1;
        }
    }

}

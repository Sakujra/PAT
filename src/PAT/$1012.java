package PAT;

import java.util.HashMap;
import java.util.Scanner;

public class $1012 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[] arrId = new String[N];
        int[] arrA = new int[N];
        int[] arrC = new int[N];
        int[] arrM = new int[N];
        int[] arrE = new int[N];
        for (int i = 0; i < N; i++) {
            arrId[i] = scanner.next();
            arrC[i] = scanner.nextInt();
            arrM[i] = scanner.nextInt();
            arrE[i] = scanner.nextInt();
            arrA[i] = (arrC[i] + arrM[i] + arrE[i]) / 3;
        }
        for (int i = 0; i < M; i++) {
            String str = scanner.next();
        }
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapC = new HashMap<>();
        HashMap<Integer, Integer> mapM = new HashMap<>();
        HashMap<Integer, Integer> mapE = new HashMap<>();
        initHashMap(arrA, mapA);
        initHashMap(arrC, mapC);
        initHashMap(arrM, mapM);
        initHashMap(arrE, mapE);
//        System.out.println();
        for (int i = 0; i < N; i++) {
            int a = mapA.get(arrA[i]);
            int c = mapC.get(arrC[i]);
            int m = mapM.get(arrM[i]);
            int e = mapE.get(arrE[i]);
            int[] rank = new int[]{a, c, m, e};
            printRank(rank);
        }
        for (int i = 0; i < M - N; i++) {
            System.out.println("N/A");
        }
    }

    private static void printRank(int[] rank) {
        int bestRank = rank[0];
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] < bestRank) bestRank = rank[i];
        }
        for (int i = 0; i < rank.length; i++) {
            if (bestRank == rank[i]) {
                System.out.print(bestRank + " ");
                switch (i) {
                    case 0:
                        System.out.println("A");
                        break;
                    case 1:
                        System.out.println("C");
                        break;
                    case 2:
                        System.out.println("M");
                        break;
                    case 3:
                        System.out.println("E");
                        break;
                }
                break;
            }
        }
    }

    public static void initHashMap(int[] a, HashMap<Integer, Integer> map) {
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i + 1);
            }
        }
    }

    public static void shellSort(int[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j] > a[j - h]; j -= h) {
                    int tmp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = tmp;
                }
            }
            h = h / 3;
        }
    }

}

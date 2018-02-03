package PAT;

import java.util.Scanner;

public class $1011 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double[] arr1 = getArr();
        double[] arr2 = getArr();
        double[] arr3 = getArr();
        int index1 = findMaxIndex(arr1);
        int index2 = findMaxIndex(arr2);
        int index3 = findMaxIndex(arr3);
        printWTL(index1);
        printWTL(index2);
        printWTL(index3);
        float profit = (float) (arr1[index1] * arr2[index2] * arr3[index3] * 0.65 - 1) * 2;
        System.out.printf("%.2f", profit);
    }

    public static void printWTL(int index) {
        switch (index) {
            case 0:
                System.out.print("W ");
                break;
            case 1:
                System.out.print("T ");
                break;
            case 2:
                System.out.println("L ");
                break;
        }
    }

    public static int findMaxIndex(double[] arr) {
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i] > arr[max]) max = i;
        }
        return max;
    }

    public static double[] getArr() {
        double[] arr = new double[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = scanner.nextDouble();
        }
        return arr;
    }
}

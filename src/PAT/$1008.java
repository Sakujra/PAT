package PAT;

import java.util.Scanner;

public class $1008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(calcTotalTime(arr));
    }

    public static int calcTotalTime(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum += arr[i] * 6;
            } else {
                if (arr[i] - arr[i - 1] > 0) {
                    sum += (arr[i] - arr[i - 1]) * 6;
                } else {
                    sum += (arr[i - 1] - arr[i]) * 4;
                }
            }
        }
        sum += n * 5;
        return sum;
    }

}

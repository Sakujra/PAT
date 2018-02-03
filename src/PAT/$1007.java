package PAT;

import java.util.Scanner;

public class $1007 {

    public static int minIndex;
    public static int maxIndex;
    static boolean hasPositive = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        int sum = findMaxSumProcessOnline(arr);
        if (hasPositive) {
            System.out.println(sum + " " + minIndex + " " + maxIndex);
        } else {
            System.out.println(sum + " 0 " + arr.length);
        }
    }

    public static int findMaxSumProcessOnline(int[] arr) {
        //global
        int maxSum = 0;
        minIndex = 0;
        maxIndex = 0;
        //local
        int thisSum = 0;
        int thisMinIndex = 0;
        int thisMaxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) hasPositive = true;
            thisSum += arr[i];
            thisMaxIndex = i;
            if (thisSum > maxSum) {
                maxSum = thisSum;
                maxIndex = thisMaxIndex;
                minIndex = thisMinIndex;
            } else if (thisSum < 0) {
                thisSum = 0;
                if (i != arr.length - 1) {
                    thisMinIndex = i + 1;
                    thisMaxIndex = i + 1;
                }
            }
        }
        return maxSum;
    }


}

package PAT;

import java.util.Scanner;

public class $1006 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        String[] arrId = new String[total];
        int[] arrIntime = new int[total];
        int[] arrOuttime = new int[total];
        for (int i = 0; i < total; i++) {
            String str = scanner.nextLine();
            String[] arrStr = str.split(" ");
            arrId[i] = arrStr[0];
            arrIntime[i] = calcTime(arrStr[1]);
            arrOuttime[i] = calcTime(arrStr[2]);
        }
        System.out.print(arrId[getMinIndex(arrIntime)] + " ");
        System.out.print(arrId[getMaxIndex(arrOuttime)]);
    }

    public static int calcTime(String str) {
        String[] arrStrTime = str.split(":");
        int totalTime = Integer.parseInt(arrStrTime[0]) * 3600;
        totalTime += Integer.parseInt(arrStrTime[1]) * 60;
        totalTime += Integer.parseInt(arrStrTime[2]);
        return totalTime;
    }

    public static int getMaxIndex(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) max = i;
        }
        return max;
    }

    public static int getMinIndex(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) min = i;
        }
        return min;
    }

}

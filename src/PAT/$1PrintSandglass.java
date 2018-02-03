package PAT;

import java.util.Scanner;

public class $1PrintSandglass {
    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("input n, c：");
        int n = cin.nextInt();
        char c = cin.next().charAt(0);
        printSandglass(n, c);
    }

    public static void printSandglass(int num, char c) {
        int n;
        int sum;
        for (n = 1; ; n++) {
            sum = 2 * n * n - 1;
            if (sum > num) {
                //n-1才是想要的
                n--;
                break;
            }
        }
        int count = 2 * n - 1;
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = c;
        }
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                System.out.println(chars);
                continue;
            }
            if (i < count / 2 + 1) {
                chars[i - 1] = ' ';
                chars[count - i] = ' ';
            } else {
                chars[count - i - 1] = c;
                chars[i - 1 + 1] = c;
            }
            System.out.println(chars);
        }
        int remain = num - 2 * n * n + 1;
        if (remain != 0) {
            System.out.println(remain);
        }
    }
}

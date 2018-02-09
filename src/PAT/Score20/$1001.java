package PAT.Score20;

import java.util.Scanner;
import java.util.Stack;

public class $1001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(formatSum(a, b));
    }

    public static String formatSum(int a, int b) {
        int sum = a + b;
        String str = Integer.toString(sum);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        Stack<Character> anotherStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = stack.pop();
            anotherStack.push(c);
            if ((i + 1) % 3 == 0 && !stack.isEmpty()) {
                anotherStack.push(',');
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!anotherStack.isEmpty()) {
            builder.append(anotherStack.pop());
        }
        if (builder.indexOf("-,") != -1) builder.deleteCharAt(1);
        return builder.toString();
    }

}

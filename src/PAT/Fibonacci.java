package PAT;

public class Fibonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fib(i));
        }
    }

    private static int fib(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        else return fib(n - 1) + fib(n - 2);
    }
}

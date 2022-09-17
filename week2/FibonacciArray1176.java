import java.util.Scanner;

public class FibonacciArray1176 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] fib = new long[61];
        long value = 0;
        int testCount = sc.nextInt();
        while (testCount != 0) {
            int number = sc.nextInt();
            for (int i = 3; i <= 60; i++) {
                fib[0] = 0;
                fib[1] = 1;
                fib[2] = 1;
                value = fib[i - 1] + fib[i - 2];
                fib[i] = value;
            }
            System.out.println("Fib(" + number + ") = " + fib[number]);
            testCount--;
        }
    }
}

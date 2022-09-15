import java.util.Scanner;

public class FibonacciArray_1176 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println("Fib(" + n + ") = " + getFib(n));
        }
    }
    static long getFib(int n){
        long n0 = 0;
        long n1 = 1;
        long fib = n1+n0;

        if(n==0){
            return n0;
        }else if(n==1){
            return n1;
        }else{
            for (int i = 2; i <= n; i++) {
                fib=n1+n0;
                n0=n1;
                n1=fib;
            }
        }
        return fib;
    }
}

import java.util.Scanner;

public class PrimeNumber_1165 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int divideCount=0;
            for (int j = 1; j <= x; j++) {
                if(x%j==0){
                    divideCount++;
                }
            }
            System.out.println(divideCount==2?x+" eh primo":x+" nao eh primo");
        }
    }
}

import java.util.Scanner;

public class PerfectNumber_1164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int sum=0;
            for (int j = 1; j < x; j++) {
                if(x%j==0){
                    sum+=j;
                }
            }
            System.out.println(sum==x?x+" eh perfeito":x+" nao eh perfeito");
        }
    }
}

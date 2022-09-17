import java.util.Scanner;

public class PrimeNumber1165 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount, value, temp;

        testCount = sc.nextInt();

        while (testCount != 0){
            value = sc.nextInt();
            int dividers = 0;
            for (int i = value; i > 2; i--) {
                temp = value % (i-1);
                if(temp == 0) {
                    dividers++;
                }
            }
            if(dividers == 0){
                System.out.println(value + " eh primo");
            }else
                System.out.println(value + " nao eh primo");
            testCount--;
            dividers = 0;
        }
    }
}

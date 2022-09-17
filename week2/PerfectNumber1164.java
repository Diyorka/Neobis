import java.util.Scanner;


public class PerfectNumber1164 {
    public static final long firstPerfectNumber = 6;
    public static final long secondPerfectNumber = 28;
    public static final long thirdPerfectNumber = 496;

    public static final long fourthPerfectNumber = 8128;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount, value;

        testCount = sc.nextInt();

        while (testCount != 0){
            value = sc.nextInt();
            if(value == firstPerfectNumber || value == secondPerfectNumber || value == thirdPerfectNumber || value == fourthPerfectNumber){
                System.out.println(value + " eh perfeito");
            }else
                System.out.println(value + " nao eh perfeito");
            testCount--;
        }
    }
}


import java.util.*;

public class FlaviousJosephusLegend1030 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int answer=0;

        for(int i = 1; i <= num; i++){

            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            for(int j=1; j<=num1;j++){
                answer = (answer + num2) % j;
            }
            System.out.printf("Case %d: %d\n", i, answer + 1);
        }
    }
}

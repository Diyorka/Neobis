import java.util.Scanner;

public class LogicalSequence2_1145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int i=1;
        while(i<=y){
            for (int j = 0; j < x; j++) {
                if(j!=x-1)
                    System.out.print(i + " ");
                else
                    System.out.println(i);
                i++;
            }
        }
    }
}

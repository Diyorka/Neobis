import java.util.Scanner;

public class ColumnInArray_1182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        char SorM = sc.next().charAt(0);
        double[][] M = new double[12][12];
        double sum = 0;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j]=sc.nextDouble();
            }
        }

        for (double[] doubles : M) {
            sum += doubles[C];
        }

        if(SorM == 'M')
            System.out.printf("%.1f%n", (sum/12));
        else if (SorM == 'S')
            System.out.printf("%.1f%n", sum);

    }
}

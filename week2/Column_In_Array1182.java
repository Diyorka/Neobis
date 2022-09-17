

import java.util.Scanner;

public class Column_In_Array1182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[][] matrix = new float[12][12];
        String s = "S";
        String m = "M";
        int column;
        String action;
        float sum = 0f, average = 0f, value;
        column = sc.nextInt();
        action = sc.next();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                value = sc.nextFloat();
                matrix[i][j] = value;
            }
        }
        if(action.equals(s)){
            for (int i = 0; i < 12; i++) {
                sum += matrix[i][column];
            }
            System.out.printf("%.1f\n", sum);
        }
        if(action.equals(m)){
            for (int i = 0; i < 12; i++) {
                sum += matrix[i][column];
                average = sum / 12.0f;
            }
            System.out.printf("%.1f\n", average);
        }
    }
}

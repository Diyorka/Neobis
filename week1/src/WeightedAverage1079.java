import java.text.DecimalFormat;
import java.util.Scanner;

public class WeightedAverage1079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] mas = {2,3,5};
        for (int i = 0; i < n; i++) {
            double res = 0;
            String[] numbers = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                res+=Double.parseDouble(numbers[j])*mas[j];
            }
            res/=10;

            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            String result = decimalFormat.format(res).replace(',', '.');
            System.out.println(Double.parseDouble(result));
        }
    }
}

import java.util.Scanner;

public class Banknotes1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mas = {100, 50, 20, 10, 5, 2, 1};
        String[] mas1 = {"100,00", "50,00", "20,00", "10,00", "5,00", "2,00", "1,00"};
        System.out.println(n);
        for (int i = 0; i < 7; i++) {
            System.out.println(n/mas[i] + " nota(s) de R$ " + mas1[i]);
            n%=mas[i];
        }
    }
}

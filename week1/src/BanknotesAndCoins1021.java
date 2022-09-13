import java.util.Scanner;

public class BanknotesAndCoins1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = Double.parseDouble(sc.nextLine());
        int n1 = (int)n;
        int n2 = (int)(n*100);
        n2%=100;
        int[] mas = {100, 50, 20, 10, 5, 2};
        double[] mas2= {50, 25, 10, 5, 1};
        String[] mas3 = {"100.00", "50.00", "20.00", "10.00", "5.00", "2.00"};
        String[] mas4 = {"0.50", "0.25", "0.10", "0.05", "0.01"};

        System.out.println("NOTAS:");
        for (int i = 0; i < 6; i++) {
            System.out.println(n1/mas[i] + " nota(s) de R$ " + mas3[i]);
            n1%=mas[i];
        }

        System.out.println("MOEDAS:");
        System.out.println(n1 + " moeda(s) de R$ 1.00");
        for (int i = 0; i < 5; i++) {
            System.out.println((int)(n2/mas2[i]) + " moeda(s) de R$ " + mas4[i]);
            n2%=mas2[i];
        }
    }    
}


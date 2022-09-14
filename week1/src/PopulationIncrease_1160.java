import java.util.Scanner;

public class PopulationIncrease_1160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            int years = 0;
            String[] s = sc.nextLine().split(" ");
            int PA = Integer.parseInt(s[0]), PB = Integer.parseInt(s[1]);
            double G1 = Double.parseDouble(s[2]), G2 = Double.parseDouble(s[3]);

            while(PA<=PB && years<=100){
                PA+=G1/100*PA;
                PB+=G2/100*PB;
                years++;
            }

            if(years>100)
                System.out.println("Mais de 1 seculo.");
            else
                System.out.println(years + " anos.");
        }
    }
}

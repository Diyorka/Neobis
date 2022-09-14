import java.util.Scanner;

public class Grenais1131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 1;
        int gamesCount = 0;
        int interWin = 0;
        int gremioWin = 0;
        int draws = 0;

        while(answer == 1){
            int inter = sc.nextInt();
            int gremio = sc.nextInt();

            if(inter>gremio){
                interWin++;
            }else if(inter<gremio){
                gremioWin++;
            }else{
                draws++;
            }
            gamesCount++;
            System.out.println("Novo grenal (1-sim 2-nao)");
            answer = sc.nextInt();
        }

        System.out.println(gamesCount + " grenais");
        System.out.println("Inter:"+interWin);
        System.out.println("Gremio:"+gremioWin);
        System.out.println("Empates:"+draws);
        if(interWin>gremioWin){
            System.out.println("Inter venceu mais");
        }else if(interWin<gremioWin){
            System.out.println("Gremio venceu mais");
        }else{
            System.out.println("Não houve vencedor");
        }
    }
}

import java.util.Scanner;

public class GameTimeWithMinutes1047 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int startH = sc.nextInt();
        int startM = sc.nextInt();
        int endH = sc.nextInt();
        int endM = sc.nextInt();

        if(startH==endH && endM==startM){
            System.out.println("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)");
            return;
        }

        int resultH = endH-startH;
        if(resultH<0){
            resultH = 24+(endH-startH);
        }

        int resultM = endM-startM;
        if(resultM<0){
            resultM = 60+(endM-startM);
            resultH--;
        }

        System.out.println("O JOGO DUROU " + resultH + " HORA(S) E " + resultM + " MINUTO(S)");

    }
}

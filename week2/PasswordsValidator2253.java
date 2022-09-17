import java.util.Scanner;

public class PasswordsValidator2253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean goodPass = false;
        while(sc.hasNextLine()){
            String pass = sc.nextLine();
            goodPass = pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=[^!\"#$%&'()*+,\\-./:;<=>?@\\[\\]^_`{|}]+$)(?=\\S+$).{6,32}$");
            if(goodPass){
                System.out.println("Senha valida.");
            }else
                System.out.println("Senha invalida.");
        }
    }
}

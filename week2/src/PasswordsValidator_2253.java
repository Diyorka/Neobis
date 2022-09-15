import java.util.Scanner;

public class PasswordsValidator_2253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String password = sc.nextLine();

            if(password.length()<6 || password.length()>32){
                System.out.println("Senha invalida.");
            }else{
                boolean upCase = false;
                boolean lowCase = false;
                boolean number = false;

                for (int i = 0; i < password.length(); i++) {
                    if(Character.isDigit(password.charAt(i))){
                        upCase=true;
                    }else if(Character.isLowerCase(password.charAt(i))){
                        lowCase=true;
                    }else if(Character.isUpperCase(password.charAt(i))){
                        number=true;
                    }else{
                        upCase = false;
                        lowCase = false;
                        number = false;
                        break;
                    }
                }

                if(upCase && lowCase && number){
                    System.out.println("Senha valida.");
                }else{
                    System.out.println("Senha invalida.");
                }
            }
        }

    }
}

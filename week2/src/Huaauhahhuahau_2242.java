import java.util.Scanner;

public class Huaauhahhuahau_2242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u' -> s2.append(s.charAt(i));
            }
        }

        StringBuilder reversed = new StringBuilder();

        for (int i = s2.length()-1; i >= 0 ; i--) {
            reversed.append(s2.charAt(i));
        }

        if(s2.toString().equals(reversed.toString()))
            System.out.println("S");
        else
            System.out.println("N");

    }
}

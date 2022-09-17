import java.util.Scanner;

public class CaesarCipher_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            char[] s = sc.nextLine().toCharArray();
            int value = Integer.parseInt(sc.nextLine());

            //Taking every element of char array and change it to right one
            for (char c : s) {
                if (c - value <= 'Z' && c - value >= 'A') {
                    System.out.print((char)(c - value));
                }else{
                    while(c-value>'Z' || c-value < 'A'){
                        if(c-value>'Z'){
                            c -=26;
                        }else if(c-value<'A'){
                            c +=26;
                        }
                    }
                    System.out.print((char)(c-value));
                }
            }

            System.out.println();
        }

    }
}

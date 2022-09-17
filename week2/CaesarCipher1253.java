import java.util.Scanner;

public class CaesarCipher1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String reverseAlphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String result = "";
        int testCount, shift, index, temp = 0;
        testCount = sc.nextInt();
        while (testCount != 0){
            String text = sc.next();
            shift = sc.nextInt();
            for (int i = 0; i < text.length(); i++) {
                index = alphabet.indexOf(text.charAt(i));
                temp = index - shift;
                ;
                if(temp < 0){
                    result += reverseAlphabet.charAt(Math.abs(temp)-1);
                }else
                result += alphabet.charAt(index-shift);
            }
            System.out.println(result);
            result = "";
            testCount--;
        }
    }
}

import java.util.Scanner;

public class Huaauhahhuahau2242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String text = sc.next();
        char temp;
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            temp = text.charAt(i);
            if(temp ==  'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp ==  'u'){
                result += temp;
            }
        }
        sb.append(result);
        sb.reverse();
        if(sb.toString().equals(result)){
            System.out.println('S');
        }else
            System.out.println('N');
    }
}

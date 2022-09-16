import java.util.Scanner;

public class CompareSubstring_1237 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int len = 0;

            for (int i = 0; i < s1.length(); i++) {
                for (int j = i; j < s1.length()+1; j++) {
                   if(s2.contains(s1.substring(i,j))){
                       if(s1.substring(i,j).length()>len){
                           len = s1.substring(i,j).length();
                       }
                   }
                }
            }
            System.out.println(len);
        }
    }
}


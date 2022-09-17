import java.util.Scanner;

public class Combiner1238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int testCounts = sc.nextInt();

        for (int i = 0; i < testCounts; i++) {
            String text = sc.next();
            String[] substring = text.split(" ");
            combiner(substring[0], substring[1]);
        }
    }
    public static void combiner(String sub1, String sub2){
        String temp = "";
        if(sub1.length() > sub2.length()){
            for (int i = 0; i < sub1.length(); i++) {
                if(sub2.length() > i) {
                    temp += sub1.charAt(i);
                }
                if(sub2.length() <= i){
                    temp += sub1.charAt(i);
                }else
                    temp += sub2.charAt(i);
            }
        }else{
            for (int i = 0; i < sub2.length(); i++) {
                if(sub1.length() > i) {
                    temp += sub1.charAt(i);
                }
                if(sub2.length() < i){
                    temp += sub1.charAt(i);
                }else
                temp += sub2.charAt(i);
            }
        }
        System.out.println(temp);
        temp = "";
    }
}

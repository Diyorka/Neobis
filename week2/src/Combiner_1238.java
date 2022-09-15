import java.util.Scanner;

public class Combiner_1238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int s1l = s1.length();
            int s2l = s2.length();
            int len = Math.max(s1l, s2l);

            for (int j = 0; j < len; j++) {
                if(len==s1l){
                    if(s2l>j){
                        System.out.print(s1.charAt(j));
                        System.out.print(s2.charAt(j));
                    }else{
                        System.out.print(s1.charAt(j));
                    }
                }else {
                    if(s1l>j){
                        System.out.print(s1.charAt(j));
                        System.out.print(s2.charAt(j));
                    }else{
                        System.out.print(s2.charAt(j));
                    }
                }
            }
            System.out.println();
        }
    }
}

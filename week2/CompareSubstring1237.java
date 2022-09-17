import java.util.Scanner;

public class CompareSubstring1237 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            String longString;
            String shortString;
            longString = line1.length() > line2.length() ? line1 : line2;
            shortString = line1.length() > line2.length() ? line2 : line1;
            int sub = 0;

            for (int i = 0; i < shortString.length(); i++) {
                for (int j = i; j < shortString.length()+1; j++) {
                    if(longString.contains(shortString.substring(i,j))){
                        if(shortString.substring(i,j).length()>sub){
                            sub = shortString.substring(i,j).length();
                        }
                    }
                }
            }
            System.out.println(sub);
        }
    }
}

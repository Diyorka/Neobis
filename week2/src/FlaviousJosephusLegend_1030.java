import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FlaviousJosephusLegend_1030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nc = sc.nextInt();

        for (int i = 0; i < nc; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> people = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                people.add(j+1);
            }

            while(people.size()>1){
                for (int j = 0; j < k-1; j++) {
                    people.add(people.get(0));
                    people.remove(0);
                }
                people.remove(0);
            }
            System.out.println("Case "+ (i+1) +": "+  people.get(0));
        }
    }
}

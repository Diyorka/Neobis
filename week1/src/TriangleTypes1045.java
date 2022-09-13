import java.util.Scanner;

public class TriangleTypes1045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mas = sc.nextLine().split(" ");
        double a1 = Double.parseDouble(mas[0]);
        double b1 = Double.parseDouble(mas[1]);
        double c1 = Double.parseDouble(mas[2]);

        double a = Math.max(a1,Math.max(b1,c1));
        double b = b1;
        double c = c1;

        if(a==a1){
            b=b1;
            c=c1;
        }else if(a==b1){
            b=a1;
            c=c1;
        }else{
            b=a1;
            c=b1;
        }

        if(a>=b+c){
            System.out.println("NAO FORMA TRIANGULO");
            return;
        }
        if(a*a==b*b+c*c){
            System.out.println("TRIANGULO RETANGULO");
        }
        if(a*a>b*b+c*c){
            System.out.println("TRIANGULO OBTUSANGULO");
        }
        if(a*a<b*b+c*c){
            System.out.println("TRIANGULO ACUTANGULO");
        }
        if(a==b && a==c){
            System.out.println("TRIANGULO EQUILATERO");
        }
        if(a==b && a!=c || b==c && b!=a || c==a && c!=b){
            System.out.println("TRIANGULO ISOSCELES");
        }
    }
}

import java.text.DecimalFormat;

public class SequenceIJ4_1098 {
    public static void main(String[] args) {
        for (double i = 0; i <= 2; i+=0.2) {
            for (double j = 1; j < 4; j++) {
                if(i==0.0 || i==1.0 || i==2.0){
                    System.out.println("I=" + (int)i + " J=" + (int)(i+j));
                }else {
                    DecimalFormat decimalFormat = new DecimalFormat("#.#");
                    String result = decimalFormat.format(i).replace(',', '.');
                    String result2 = decimalFormat.format(i+j).replace(',', '.');
                    System.out.println("I=" + result + " J="+result2);
                }
            }
        }
    }
}

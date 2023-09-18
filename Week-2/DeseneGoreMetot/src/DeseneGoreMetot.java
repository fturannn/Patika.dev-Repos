import java.util.Scanner;
public class DeseneGoreMetot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2, num3;

        System.out.print("N sayısı: ");
        num1 = input.nextInt();
        num2 = 0; // num1 negatif ise, num2'yi num1'e eşitleyip 5 arttıracağız
        num3 = num1; /* en sonda num1'in ilk değerini elde edip etmediğimizi
        görmek için num3 değişkenini num1'e eşit tanımlıyoruz */

        recMetot(num1, num2, num3);
    }

    static void recMetot(int num1, int num2, int num3) {
        if (num1 <= 0) {
            if (num2 == num3) {
                System.out.print(num3 + " "); // num1 < 0 ve num2 = num3 (num1'in ilk değeri) ise num3'ü ekrana yazdır
            } else {
                System.out.print(num2 + " "); // num2, num3 (num1'in ilk değeri)'e eşit olana kadar 5 arttır
                recMetot(num1, num2 + 5, num3);
            }
        } else {
            System.out.print(num1 + " ");
            recMetot(num1 - 5, num1 - 5, num3); //num1 > 0 olduğu sürece 5 azalt
        }
    }
}

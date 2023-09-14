import java.util.Scanner;
public class HarmonikSeri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double toplam = 0, num;

        System.out.print("Harmonik serisini hesaplamak istediğiniz sayıyı giriniz: ");
        num = input.nextFloat();

        for (double i = 1; i <= num; i++) {
            toplam += (1 / i);
        }

        System.out.print("Sonuç = " + toplam);
    }
}

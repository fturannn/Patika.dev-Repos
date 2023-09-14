import java.util.Scanner;
public class EbobEkok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b, bolen = 1, ebob = 0, ekok;

        System.out.print("Sayı 1: ");
        a = input.nextInt();

        System.out.print("Sayı 2:");
        b = input.nextInt();

        while (bolen != a && bolen != b) {
            if (a % bolen == 0 && b % bolen == 0) {
                ebob = bolen;
            }
            bolen++;
        }

        ekok = (a * b) / ebob;

        System.out.println("En büyük ortak bölen: " + ebob);
        System.out.println("En küçük ortak kat: " + ekok);
    }
}

import java.util.Scanner;
public class RecursiveUsHesabi {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int sayi, us;

         // Kullanıcıdan verileri al
        System.out.print("Taban değerini giriniz: ");
        sayi = input.nextInt();

        System.out.print("Üs değerini giriniz: ");
        us = input.nextInt();

        // recursiveUs() metodunu kullanarak sonucu ekrana yazdır
        System.out.print("Sonuç: " + recursiveUs(sayi, us));
         
    }
    static int recursiveUs(int sayi, int us) {
        if (us == 0) {
            return 1;
        } else {
            return sayi * recursiveUs(sayi, (us - 1));
        }
    }
}

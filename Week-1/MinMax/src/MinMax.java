import java.util.Scanner;
public class MinMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int adet, sayi, max, min;

        System.out.print("Kaç tane sayı gireceksiniz: ");
        adet = input.nextInt();

        System.out.print("1. sayıyı giriniz: "); // İlk girilen sayıyı min ve max değişkenlerine atayalım
        min = input.nextInt();
        max = min;

        for (int i = 2; i <= adet; i++) {
            System.out.print(i + ". sayıyı giriniz: ");
            sayi = input.nextInt();
            if (sayi >= max) {
                max = sayi;
            } else if (sayi <= min) {
                min = sayi;
            }
        }

        // En büyük ve en küçük sayıları ekrana yazdıralım
        System.out.println("En büyük sayı: " + max);
        System.out.print("En küçük sayı: " + min);
    }
}

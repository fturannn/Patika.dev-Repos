import java.util.Scanner;
public class MukemmelSayi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, sayac = 1, toplam = 0;

        // Sayıyı kullanıcıdan alalım
        System.out.print("Bir sayı giriniz: ");
        num = input.nextInt();

        // Girilen sayının bölenlerini toplayalım
        while (sayac < num) {
            if (num % sayac == 0) {
                toplam += sayac;
            }
            sayac++;
        }

        // Bölenlerin toplamı sayının kendisine eşit mi kontrol edelim
        if (toplam == num) {
            System.out.print(num + " mükemmel sayıdır.");
        } else {
            System.out.print(num + " mükemmel sayı değildir.");
        }
    }
}

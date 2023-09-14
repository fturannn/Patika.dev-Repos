import java.util.Scanner;public class AsalSayi {
    public static void main(String[] args) {
        int kalanToplam = 0;

        System.out.println("1 ile 100 arasındaki asal sayılar:");

        for (int i = 2; i <= 100; i++) { // 1 ile 100 arasındaki sayıları döngüye alalım
            for (int j = 2; j < i; j++) { // 1 den sayının kendisine kadar her sayıya bölelim
                if (i % j == 0) {
                    kalanToplam += i; // Eğer 1 veya kendisinden başka bir sayıya bölünüyorsa kalanToplam değişkenine ekleyelim
                }
            }
            if (kalanToplam == 0) { // kalantoplam = 0 ise herhangi bir sayıya bölünmüyor demektir bu nedenle asal sayıdır.
                System.out.print(i + "  ");
            }
            kalanToplam = 0;
        }
    }
}

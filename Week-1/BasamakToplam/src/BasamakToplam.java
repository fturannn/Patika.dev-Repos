import java.util.Scanner;
public class BasamakToplam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, total = 0;

        System.out.print("Bir sayı giriniz: ");
        num = input.nextInt();

        /* Sayının 10 ile bölümünden kalanı hesaplayarak son basamağı bulabiliriz
        sonrasında ise her döngüde 10'a bölerek her basamaktaki sayıyı elde etmiş oluruz.
         */
        while (num != 0) {
            total += (num % 10);
            num /= 10;
        }

        System.out.println("Girdiğiniz sayının basamakları toplamı: " + total);
        
    }
}

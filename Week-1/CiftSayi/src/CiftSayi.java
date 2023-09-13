import java.util.Scanner;
public class CiftSayi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, sum = 0, total = 0, average;

        System.out.print("Bir sayı giriniz: ");
        num = input.nextInt();

        for (int i = 1; i <= num; i++) {
            if (i % 12 == 0) {
                sum += i;
                total += 1;
            }
        }

        average = sum / total;
        System.out.println("Girdiğiniz sayıya kadar olan sayılardan 3 ve 4'e tam bölünenlerin ortalaması: " + average);
    }
}

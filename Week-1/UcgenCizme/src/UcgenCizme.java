import java.util.Scanner;
public class UcgenCizme {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Kullanıcıdan bir sayı alalım
        System.out.print("Bir Sayı Giriniz:");
        int num = input.nextInt();

        for (int i = num; i > 0; i--) {
            for (int j = 0; j <= (num - i); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= (2 * i - 2); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}

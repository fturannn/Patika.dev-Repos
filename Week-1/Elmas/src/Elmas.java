import java.util.Scanner;
public class Elmas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;

        System.out.print("Bir sayı giriniz: ");
        num = input.nextInt();

        for (int x = 0; x <= num + 1 ; x++) {
            for (int y = 0; y < (num + 1 - x); y++) {
                System.out.print(" ");
            }
            for (int z = 0; z <= (2 * x); z++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

        for (int i = num; i >= 0; i--) {
            for (int j = 0; j <= (num - i); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= (2 * i); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}

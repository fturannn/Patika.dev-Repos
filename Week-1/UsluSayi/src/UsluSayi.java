import java.util.Scanner;
public class UsluSayi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, k;
        long sonuc = 1;

        System.out.print("Üssü alınacak sayıyı giriniz: ");
        n = input.nextInt();

        System.out.print("Üs olacak sayıyı giriniz: ");
        k = input.nextInt();

        for(int i = 0; i < k; i++) {
            sonuc *= n;
        }

        System.out.println("Sonuç: " + sonuc);
    }
}

import java.util.Scanner;
public class IslemOnceligi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b, c, sonuc;

        System.out.print("İlk sayıyı girin: ");
        a = input.nextInt();

        System.out.print("İkinci sayıyı girin: ");
        b = input.nextInt();

        System.out.print("Üçüncü sayıyı girin: ");
        c = input.nextInt();

        sonuc = a + b * c - b;
        System.out.println("Sonuç: " + sonuc);
    }
}

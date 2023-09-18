import java.util.Scanner;
public class RecursiveAsalSayi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;

        // Kullanıcıdan sayıyı al
        System.out.print("Sayı Giriniz: ");
        num = input.nextInt();

        // Recursive metot çıktısı ile sorguya gir. true ise asal, false ise asal değil çıktısı ver.
        if (asalSayi(num, 2))
            System.out.println(num + " sayısı ASALDIR!");
        else
            System.out.println(num + " sayısı ASAL değildir!");
    }
    static boolean asalSayi(int n, int i) { // Asal sayı olup olmadığını recursive metot yardımıyla bul
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;
        return asalSayi(n, i + 1);
    }
}

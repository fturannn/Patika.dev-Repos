import java.util.Scanner;
public class VucutKitleEndeksi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double boy, kilo, kitleEndeksi;

        // Kullanıcıdan gerekli verileri alalım
        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz: ");
        boy = input.nextDouble();

        System.out.print("Lütfen kilonuzu giriniz: ");
        kilo = input.nextDouble();

        //Girilen verilerle vücut kitle endeksini hesaplayalım ve ekrana yazdıralım
        kitleEndeksi = kilo / (boy * boy);
        System.out.println("Vücut kitle endeksiniz: " + kitleEndeksi);
    }
}

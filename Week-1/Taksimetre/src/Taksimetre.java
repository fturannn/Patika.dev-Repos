import java.util.Scanner;
public class Taksimetre {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double minTutar, acilisUcreti, gidilenMesafe, toplamTutar, tutar;

        // Gidilen mesafeyi kullanıcıdan alalım
        System.out.print("Gidilen mesafeyi yazınız: ");
        gidilenMesafe = input.nextDouble();

        // Girilen mesafeye göre ücret hesabını yapalım
        tutar = 10 + gidilenMesafe * 2.20;
        toplamTutar = tutar < 20 ? 20 : tutar;

        // Ödenmesi gereken ücreti ekrana yazdıralım
        System.out.println("Ödenmesi gereken tutar: " + toplamTutar);
    }
}



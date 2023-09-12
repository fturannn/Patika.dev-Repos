import java.util.Scanner;
public class SinifGecmeDurumu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double matematik, fizik, turkce, kimya, muzik, ortalama, toplam = 0, gecerliDers = 0;

        // Kullanıcıdan verileri alalım
        System.out.print("Matematik notu: ");
        matematik = input.nextDouble();

        System.out.print("Fizik notu: ");
        fizik = input.nextDouble();

        System.out.print("Türkçe notu: ");
        turkce = input.nextDouble();

        System.out.print("Kimya notu: ");
        kimya = input.nextDouble();

        System.out.print("Müzik notu: ");
        muzik = input.nextDouble();

        // Ortalamayı hesaplayalım. Eğer bir ders 0 ile 100 arasında girilmediyse ortalamaya katılmasın
        if (matematik >= 0 && matematik <= 100) {
            gecerliDers += 1;
            toplam += matematik;
        }
        if (fizik >= 0 && fizik <= 100) {
            gecerliDers += 1;
            toplam += fizik;
        }
        if (turkce >= 0 && turkce <= 100) {
            gecerliDers += 1;
            toplam += turkce;
        }
        if (kimya >= 0 && kimya <= 100) {
            gecerliDers += 1;
            toplam += kimya;
        }
        if (muzik >= 0 && muzik <= 100) {
            gecerliDers += 1;
            toplam += muzik;
        }

        // Ortalamayı hesaplayalım ve Geçme-Kalma durumunu ekrana yazdıralım
        ortalama = toplam / gecerliDers;
        if (ortalama >= 55) {
            System.out.println("Ortalama: " + ortalama + " Geçtiniz Tebrikler!");
        } else {
            System.out.println("Ortalama: " + ortalama + " Kaldınız..");
        }
    }
}

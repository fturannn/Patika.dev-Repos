import java.util.Scanner;
public class UcakBileti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double age, tripType, distance, totalPrice;
        boolean isFalse = false; // Eğer doğru bilgiler girilmezse true olur ve hata mesajı yazdırmamızı sağlar

        // Kullanıcıdan gerekli verileri alalım
        System.out.print("Mesafeyi km türünden giriniz: ");
        distance = input.nextDouble();

        System.out.print("Yaşınızı giriniz: ");
        age = input.nextDouble();

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş Dönüş): ");
        tripType = input.nextDouble();

        // Öncelikle yolculuğun toplam fiyatını hesaplayalım
        totalPrice = distance * 0.10;

        // Verilerin doğruluğunu kontrol edip uygun şartlarda indirimleri uygulayalım
        if (distance <= 0 || age <= 0) {
            isFalse = true;
        } else {
            if (tripType == 1) {
                // Eğer belirtilen yaş aralıklarındaysa gerekli indirimleri uygulayalım
                if (age < 12) {
                    totalPrice -= (totalPrice * 0.5);
                } else if (age >= 12 && age <= 24) {
                    totalPrice -= (totalPrice * 0.1);
                } else if (age >= 65) {
                    totalPrice -= (totalPrice * 0.3);
                }
                System.out.println("Toplam Tutar: " + totalPrice + " TL");
            } else if (tripType == 2) {
                if (age < 12) {
                    totalPrice -= (totalPrice * 0.5);
                    totalPrice -= (totalPrice * 0.2);
                    totalPrice *= 2; // Gidiş dönüş olduğu için bilet fiyatını en son 2 ile çarpıyoruz
                } else if (age >= 12 && age <= 24) {
                    totalPrice -= (totalPrice * 0.1);
                    totalPrice -= (totalPrice * 0.2);
                    totalPrice *= 2;
                } else if (age >= 65) {
                    totalPrice -= (totalPrice * 0.3);
                    totalPrice -= (totalPrice * 0.2);
                    totalPrice *= 2;
                } else {
                    totalPrice -= (totalPrice * 0.2);
                    totalPrice *= 2;
                }
                System.out.println("Toplam Tutar: " + totalPrice + " TL");
            } else {
                isFalse = true;
            }
        }
        if (isFalse) {
            System.out.println("Hatalı Veri Girdiniz!");
        }
    }
}

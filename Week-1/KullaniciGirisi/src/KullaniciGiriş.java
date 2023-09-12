import java.util.Scanner;
public class KullaniciGiriş {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password, userName, sorgu, newPassword;

        System.out.print("Kullanıcı Adınız: ");
        userName = input.nextLine();

        System.out.print("Şifreniz: ");
        password = input.nextLine();

        if (userName.equals("patika") && password.equals("java123")) {
            System.out.println("Giriş Yaptınız!");
        } else if (userName.equals("patika") && !password.equals("java123")) {
            System.out.print("Şifreniz yanlış! Şifrenizi sıfırlamak ister misiniz (evet/hayır)?: ");
            sorgu = input.nextLine();
            if (sorgu.equals("evet")) {
                System.out.print("Yeni şifrenizi giriniz: ");
                newPassword = input.nextLine();
                if (newPassword.equals("java123")) {
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                } else {
                    System.out.println("Şifre oluşturuldu!");
                    password = newPassword;
                }
            } else if (sorgu.equals("hayır")) {
                System.out.println("Tekrar giriş yapmayı deneyiniz.");
            } else {
                System.out.println("Hatalı giriş!");
            }
        } else if (!userName.equals("patika") && password.equals("java123")) {
            System.out.println("Kullanıcı adınız yanlış! Tekrar deneyiniz.");
        } else {
            System.out.println("Kullanıcı adınız ve şifreniz yanlış! Tekrar deneyiniz.");
        }
    }
}

import java.util.Scanner;
public class CinZodyagi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int birthYear, num;
        String zodyak = "";

        //Öncelikle kullanıcıdan doğum yılını alalım
        System.out.print("Doğum Yılınızı Giriniz: ");
        birthYear = input.nextInt();

        num = birthYear % 12; // Doğum yılının 12 ile bölümünden kalanı num değişkenine atayalım

        switch (num) {
            case 0:
                zodyak = "Maymun";
                break;
            case 1:
                zodyak = "Horoz";
                break;
            case 2:
                zodyak = "Köpek";
                break;
            case 3:
                zodyak = "Domuz";
                break;
            case 4:
                zodyak = "Fare";
                break;
            case 5:
                zodyak = "Öküz";
                break;
            case 6:
                zodyak = "Kaplan";
                break;
            case 7:
                zodyak = "Tavşan";
                break;
            case 8:
                zodyak = "Ejderha";
                break;
            case 9:
                zodyak = "Yılan";
                break;
            case 10:
                zodyak = "At";
                break;
            case 11:
                zodyak = "Koyun";
                break;
            default:
                System.out.println("Hatalı veri girişi!");
        }
        if (num >= 0) { //Negatif yıl girilme durumuna karşılık bir koşullu ifade eklendi
            System.out.println("Çin Zodyağı Burcunuz: " + zodyak);
        }
    }
}

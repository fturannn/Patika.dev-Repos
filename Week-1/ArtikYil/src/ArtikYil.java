import java.util.Scanner;
public class ArtikYil {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year;
        boolean isTrue = true;

        System.out.print("Yıl Giriniz: ");
        year = input.nextInt();

        isTrue = year % 4 == 0; // Yıl 4'e bölünüyorsa true olarak devam et

        if (isTrue) {
            if (year % 100 == 0) {
                if (year % 400 != 0) { // Yıl 4'e ve 100'e bölünüyor ancak 400'e bölünmüyor ise false
                    isTrue = false;
                }
            }
        } else { // Yıl 4'e bölünmüyor ise false
            isTrue = false;
        }

        // Sonucu ekrana yazdıralım (Eğer true ise artık yıl, false ise değil)
        if (isTrue) {
            System.out.println(year + " bir artık yıldır!");
        } else {
            System.out.println(year + " bir artık yıl değildir!");
        }
    }
}

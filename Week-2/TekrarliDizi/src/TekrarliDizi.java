import java.util.Scanner;
import java.util.Arrays;
public class TekrarliDizi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Dizinin boyutu n: ");
        int n = input.nextInt();

        int[] dizi = new int[n];
        int[] dizi2 = new int[n];

        for (int i = 0; i < dizi.length; i++) {
            System.out.print((i + 1) + ". elemanı: ");
            dizi[i] = input.nextInt();
        }
        System.out.println("Tekrar Sayıları");

        int sayiTekrar = 0;

        for (int j = 0; j < dizi.length; j++) {
            int counter = 0;
            for (int k = 0; k < dizi.length; k++) {
                if (dizi[j] == dizi2[k]) {
                    counter++;
                }
            }
            if (counter == 0) {
                int counter2 = 0;
                for (int l = 0; l < dizi.length; l++) {
                    if (dizi[j] == dizi[l]) {
                        counter2++;
                    }
                }
                dizi2[sayiTekrar] = dizi[j];
                sayiTekrar++;
                System.out.println(dizi[j] + " sayısı " + counter2 + " kere tekrar edildi.");
            }
        }
    }
}

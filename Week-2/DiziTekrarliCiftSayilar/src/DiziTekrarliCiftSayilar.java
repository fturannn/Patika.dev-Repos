import java.util.Scanner;
import java.util.Arrays;
public class DiziTekrarliCiftSayilar {
    static boolean isFind(int[] arr, int value) {
        for (int i : arr) {
            if(i == value) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Kaç elemanlı bir dizi kontrol etmek istiyorsunuz: ");
        int[] dizi = new int[input.nextInt()];

        for (int i = 0; i < dizi.length; i++) {
            System.out.print("Dizinin " + (i + 1) + ". elemanını giriniz: ");
            dizi[i] = input.nextInt();
        }

        int[] duplicate = new int[dizi.length];
        int startIndex = 0;
        for (int j = 0; j < dizi.length; j++) {
            for (int k = 0; k < dizi.length; k++) {
                if ( j != k && dizi[j] == dizi[k] && dizi[j] % 2 == 0) {
                    if(!isFind(duplicate, dizi[j])) {
                        duplicate[startIndex++] = dizi[j];
                    }
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(duplicate));
    }
}

import java.util.Arrays;
import java.util.Scanner;
public class DiziBuyuktenKucuge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Dizinin boyutu n: ");
        int[] dizi = new int[input.nextInt()];

        for (int i = 0; i < dizi.length; i++) {
            System.out.print((i + 1) + ". elemanı: ");
            dizi[i] = input.nextInt();
        }

        Arrays.sort(dizi);
        for(int i : dizi) {
            System.out.print(i + "  ");
        }
    }
}

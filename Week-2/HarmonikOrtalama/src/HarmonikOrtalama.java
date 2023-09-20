import java.util.Scanner;
public class HarmonikOrtalama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0.0;
        double harmonik;

        System.out.print("Dizinin eleman sayısını giriniz: ");
        int newArr[] = new int[input.nextInt()];

        for (int i = 0; i < newArr.length; i++) {
            System.out.print("Dizinin " + (i + 1) + ". elemanını giriniz: ");
            newArr[i] = input.nextInt();
            sum += (1.0 / newArr[i]);
        }
        harmonik = (newArr.length) / sum;
        System.out.println("Elemanların harmonik ortalaması: " + harmonik);
    }
}

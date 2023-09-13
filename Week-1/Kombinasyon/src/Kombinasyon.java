import java.util.Scanner;
public class Kombinasyon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, r, nFaktoriyel = 1, rFaktoriyel = 1, nrFaktoriyel = 1, kombinasyon;

        System.out.print("Kümenin eleman sayısı: ");
        n = input.nextInt();

        System.out.print("r elemanlı farklı grupların sayısı (r = ?): ");
        r = input.nextInt();

        for(int i = 1; i <= n; i++) {
            nFaktoriyel *= i;
        }

        for(int j = 1; j <= r; j++) {
            rFaktoriyel *= j;
        }

        for(int k = 1; k <= (n - r); k++) {
            nrFaktoriyel *= k;
        }

        kombinasyon = nFaktoriyel / (rFaktoriyel * nrFaktoriyel);
        System.out.println("C(n,r) = " + kombinasyon);
    }
}

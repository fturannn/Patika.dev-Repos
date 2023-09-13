import java.util.Scanner;
public class DortVeBesKuvvet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n, dortKat = 0, besKat = 0;
        boolean isTrue = true;

        System.out.print("Bir sayı giriniz: ");
        n = input.nextInt();

        for (int i = 0; Math.pow(4, i) <= n; i++) { //4'ün kuvvetlerini ekrana yazdıralım
            dortKat = Math.pow(4, i);
            System.out.println("4^" + i + " = " + dortKat);
        }
        for (int j = 0; Math.pow(5, j) <= n; j++) { //5'in kuvvetlerini ekrana yazdıralım
            besKat = Math.pow(5, j);
            System.out.println("5^" + j + "= " + besKat);
        }
    }
}

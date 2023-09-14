import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, sayi1 = 0, sayi2 = 1,  toplam = 0, temp;

        // Kullanıcıdan fibonacci serisi eleman sayısını alalım
        System.out.print("Fibonacci serisinin eleman sayısını giriniz: ");
        num = input.nextInt();

        /*sayi2 temp değişkeninde geçici olarak tutulur ve sayi2 bir önceki toplama eşitlenir.
        Ardından sayi1 bir önceki sayi2'ye temp değişkeni sayesinde atanır. Bu şekilde fibonacci
        serisi oluşturulur.
         */
        for(int i = 0; i < (num - 1); i++) {
            toplam = sayi1 + sayi2;
            System.out.println(sayi1 + " + " + sayi2 + " = " + toplam);
            temp = sayi2;
            sayi2 = toplam;
            sayi1 = temp;

        }
    }
}

import java.util.Scanner;
public class DaireDilim {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double yaricap, aci, daireDilimAlan;

        // Kullanıcıdan yarıçap ve açı ölçüsünü alalım
        System.out.print("Dairenin yarıçapını giriniz: ");
        yaricap = input.nextDouble();

        System.out.print("Alanını ölçmek istediğiniz daire diliminin açısını giriniz: ");
        aci = input.nextDouble();

        // Açısı ve yarıçapı verilen daire diliminin alanını hesaplayalım ve ekrana yazdıralım
        daireDilimAlan = (3.14 * yaricap * yaricap * aci) / 360;
        System.out.println("Açısı ve yarıçapı verilen daire diliminin alanı: " + daireDilimAlan);
    }
}

import java.util.Scanner;
public class TipDonusumu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Integer değerinizi giriniz: ");
        int typeInt = input.nextInt();

        System.out.print("Double değerinizi giriniz: ");
        double typeDouble = input.nextDouble();

        double type1 = (double) typeInt;
        int type2 = (int) typeDouble;

        System.out.println("Double tipine dönüştürülen Integer değer: " + type1);
        System.out.println("Integer tipine dönüştürülen Double değer: " + type2);
    }
}

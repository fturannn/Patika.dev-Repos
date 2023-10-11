import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class PatikaStore {
    Scanner input = new Scanner(System.in);
    public void start() {
        System.out.println("Patika Store'a Hoşgeldiniz!");

        while(true) {
            System.out.println("İşlemler");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1 - Notebook işlemleri \n2 - Cep Telefonu İşlemleri \n3 - Marka Listele \n0 - Çıkış Yap");
            System.out.print("Lütfen yapmak istediğiniz işlemin numarasını girin: ");
            int userSelection = input.nextInt();
            switch (userSelection) {
                case 1:
                    System.out.println("Notebook Listesi");
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.println("| ID | Ürün Adı       \t\t| Fiyat    \t| Marka    \t| Depolama\t| Ekran\t| RAM\t|");
                    System.out.println("-------------------------------------------------------------------------------------");
                    for (int i: Notebook.notebooks().keySet()) {
                        System.out.println("| " + i + " | " +
                                Notebook.notebooks().get(i).getName() + " \t\t| " +
                                Notebook.notebooks().get(i).getPiecePrice() + " \t| " +
                                Notebook.notebooks().get(i).getBrandName() + "\t| " +
                                Notebook.notebooks().get(i).getStorage() + "\t\t| " +
                                Notebook.notebooks().get(i).getScreenSize() + "\t| " +
                                Notebook.notebooks().get(i).getRam() + "\t|");
                    }
                    System.out.println("-------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Cep Telefonu Listesi");
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.println("| ID | Ürün Adı       \t\t\t| Fiyat\t\t| Marka\t\t| Depolama\t| Ekran\t| Pil\t| RAM\t| Renk\t|");
                    System.out.println("-------------------------------------------------------------------------------------");
                    for (int i: MobilePhone.mobilePhones().keySet()) {
                        System.out.println("| " + i + " | " +
                                MobilePhone.mobilePhones().get(i).getName() + " \t\t| " +
                                MobilePhone.mobilePhones().get(i).getPiecePrice() + " \t| " +
                                MobilePhone.mobilePhones().get(i).getBrandName() + "\t| " +
                                MobilePhone.mobilePhones().get(i).getStorage() + "\t\t| " +
                                MobilePhone.mobilePhones().get(i).getScreenSize() + "\t| " +
                                MobilePhone.mobilePhones().get(i).getBatteryPower() + "\t| " +
                                MobilePhone.mobilePhones().get(i).getRam() + "\t|" +
                                MobilePhone.mobilePhones().get(i).getColor() + "\t|");
                    }
                    System.out.println("-------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Markalarımız: ");
                    System.out.println("------------");
                    Brand.showBrand();
                    System.out.println();
                    break;
                default:
                    System.out.println();
            }
        }
    }
}

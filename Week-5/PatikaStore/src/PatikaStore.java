import java.util.*;

public class PatikaStore {
    Scanner input = new Scanner(System.in);
    public void start() {
        System.out.println("Patika Store'a Hoşgeldiniz!");
        boolean isTrue = true;
        while(isTrue) {
            System.out.println("İşlemler");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1 - Notebook işlemleri \n2 - Cep Telefonu İşlemleri \n3 - Marka Listele \n0 - Çıkış Yap");
            System.out.print("Lütfen yapmak istediğiniz işlemin numarasını girin: ");
            int userSelection = input.nextInt();
            switch (userSelection) {
                case 1:
                    NotebookOperations n = new NotebookOperations();
                    n.run();
                    break;
                case 2:
                    MobilePhoneOperations m = new MobilePhoneOperations();
                    m.run();
                    break;
                case 3:
                    Brand.showBrand();
                    System.out.println("-------------------------------------------------------------------------------------");
                    break;
                case 0:
                    isTrue = false;
                    break;
                default:
                    System.out.println();
            }
        }
    }
}

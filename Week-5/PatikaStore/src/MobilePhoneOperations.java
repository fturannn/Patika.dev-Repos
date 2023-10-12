import java.util.Scanner;

public class MobilePhoneOperations {
    Scanner input = new Scanner(System.in);

    void run() {
        System.out.println("Cep Telefonu işlemleri");
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("1 - Ürün listele");
            System.out.println("2 - Ürün ekle");
            System.out.println("3 - Ürün sil");
            System.out.println("4 - ID'ye göre ürün sırala");
            System.out.println("5 - Marka ismine göre ürün sırala");
            System.out.println("0 - Ana Ekrana Dön");
            System.out.print("Yapmak istediğiniz işlem numarasını girin: ");
            int noteBookSelection = input.nextInt();
            switch(noteBookSelection) {
                case 1:
                    showMobilePhone();
                    System.out.println("-------------------------------------------------------------------------------------");
                    break;
                case 2:
                    addMobilePhone();
                    break;
                case 3:
                    deleteMobilePhone();
                    break;
                case 4:
                    sortById();
                    break;
                case 5:
                    sortMobilePhoneByBrandName();
                    break;
                case 0:
                    isTrue = false;
                    break;
                default:
                    System.out.println("Lütfen geçerli bir işlem seçiniz!");
                    break;
            }
        }
    }

    static void showMobilePhone() {
        System.out.println("Cep Telefonu Listesi");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı       \t| Fiyat    \t| Marka    \t| Depolama | Ekran\t| Pil\t| RAM\t| Renk\t|");
        System.out.println("-------------------------------------------------------------------------------------");
        for (MobilePhone i: MobilePhone.getMobilePhoneList()) {
            System.out.println("| " + i.getBrand().getId() + " | " +
                    i.getProductName() + " \t| " +
                    i.getUnitPrice() + "\t| " +
                    i.getBrand().getBrandName() + "\t| " +
                    i.getStorage() + "   \t| " +
                    i.getScreenSize() + "\t| " +
                    i.getBatteryPower() + "\t| " +
                    i.getRam() + "\t|" +
                    i.getColor() + "\t|");
        }
    }

    void addMobilePhone(){
        while(true) {
            System.out.println("1 - Samsung ID \n2 - Lenovo ID \n3 - Apple ID \n4 - Huawei ID \n5 - Casper ID \n6 - Asus ID \n7 - HP ID \n8 - Xiaomi ID \n9 - Monster ID");
            System.out.print("Eklemek istediğiniz markanın ID numarası: ");
            int id = input.nextInt();
            if (id >= 1 && id <= 9) {
                System.out.print("Birim fiyatı: ");
                double unitPrice = input.nextDouble();
                System.out.print("İndirim oranı: ");
                double discountRate = input.nextDouble();
                System.out.print("Stok: ");
                int stock = input.nextInt();
                System.out.print("Ürün adı: ");
                input.nextLine();
                String productName = input.nextLine();
                System.out.print("RAM: ");
                int ram = input.nextInt();
                System.out.print("Hafıza: ");
                int storage = input.nextInt();
                System.out.print("Ekran boyutu: ");
                double screenSize = input.nextDouble();
                System.out.print("Batarya: ");
                int batteryPower = input.nextInt();
                System.out.print("Renk: ");
                input.nextLine();
                String color = input.nextLine();
                MobilePhone.getMobilePhoneList().add(new MobilePhone(new Brand(id, Brand.brands.get(id)), unitPrice, discountRate, stock, productName, ram, storage, screenSize, batteryPower, color));
                showMobilePhone();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("Ürün başarılı bir şekilde eklendi!");
                System.out.println("-------------------------------------------------------------------------------------");
                break;
            } else {
                System.out.println("Lütfen geçerli bir ID girin!");
            }
        }
    }

    void deleteMobilePhone() {
        boolean isTrue = true;
        while(isTrue) {
            System.out.print("Silmek istediğiniz ürünün ID'sini giriniz: ");
            int id = input.nextInt();
            for (int i = 0; i < MobilePhone.getMobilePhoneList().size(); i++) {
                if (Brand.brands.get(id).equals(MobilePhone.getMobilePhoneList().get(i).getBrand().getBrandName())) {
                    MobilePhone.getMobilePhoneList().remove(i);
                    System.out.println(id + "-ID'li ürün başarıyla silinmiştir.");
                    isTrue = false;
                } else {
                    System.out.println("Lütfen geçerli bir ID girin!");
                }
            }
        }
    }

    void sortById () {
        boolean isTrue = true;
        while(isTrue) {
            System.out.print("Sıralamak istediğiniz ID numarasını girin: ");
            int id = input.nextInt();
            if(MobilePhone.getMobilePhoneList().isEmpty()) {
                System.out.println("Henüz hiçbir ürün eklenmemiş!");
                isTrue = false;
            } else {
                for (MobilePhone i : MobilePhone.getMobilePhoneList()) {
                    if (Brand.brands.get(id).equals(i.getBrand().getBrandName())) {
                        System.out.println("| ID | Ürün Adı       \t| Fiyat    \t| Marka    \t| Depolama | Ekran\t| Pil\t| RAM\t| Renk\t|");
                        System.out.println("-------------------------------------------------------------------------------------");
                        System.out.println("| " + i.getBrand().getId() + " | " +
                                i.getProductName() + " \t| " +
                                i.getUnitPrice() + "\t| " +
                                i.getBrand().getBrandName() + "\t| " +
                                i.getStorage() + "   \t| " +
                                i.getScreenSize() + "\t| " +
                                i.getBatteryPower() + "\t| " +
                                i.getRam() + "\t|" +
                                i.getColor() + "\t|");
                        System.out.println("-------------------------------------------------------------------------------------");
                        isTrue = false;
                    } else {
                        System.out.println("Lütfen geçerli bir ID girin!");
                    }
                }
            }
        }
    }

    void sortMobilePhoneByBrandName () {
        boolean isTrue = true;
        while(isTrue) {
            System.out.print("Sıralamak istediğiniz markayı girin: ");
            String BrandName = input.nextLine();
            input.nextLine();
            if(MobilePhone.getMobilePhoneList().isEmpty()) {
                System.out.println("Henüz hiçbir ürün eklenmemiş!");
                isTrue = false;
            } else {
                for (MobilePhone i : MobilePhone.getMobilePhoneList()) {
                    if (i.getBrand().getBrandName().equals(BrandName)) {
                        System.out.println("| ID | Ürün Adı       \t| Fiyat    \t| Marka    \t| Depolama | Ekran\t| Pil\t| RAM\t| Renk\t|");
                        System.out.println("-------------------------------------------------------------------------------------");
                        System.out.println("| " + i.getBrand().getId() + " | " +
                                i.getProductName() + " \t| " +
                                i.getUnitPrice() + "\t| " +
                                i.getBrand().getBrandName() + "\t| " +
                                i.getStorage() + "   \t| " +
                                i.getScreenSize() + "\t| " +
                                i.getBatteryPower() + "\t| " +
                                i.getRam() + "\t|" +
                                i.getColor() + "\t|");
                        System.out.println("-------------------------------------------------------------------------------------");
                        isTrue = false;
                    } else {
                        System.out.println("Lütfen mevcut ve geçerli bir marka adı girin!");
                    }
                }
            }
        }
    }
}

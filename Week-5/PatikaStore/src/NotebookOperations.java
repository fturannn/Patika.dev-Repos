import java.util.Scanner;
public class NotebookOperations {
    Scanner input = new Scanner(System.in);

    void run() {
        System.out.println("Notebook işlemleri");
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
                    showNotebook();
                    System.out.println("-------------------------------------------------------------------------------------");
                    break;
                case 2:
                    addNotebook();
                    break;
                case 3:
                    deleteNotebook();
                    break;
                case 4:
                    sortById();
                    break;
                case 5:
                    sortNotebookByBrandName();
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

    static void showNotebook() {
        System.out.println("Notebook Listesi");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı       \t| Fiyat    \t| Marka    \t| Depolama | Ekran\t| RAM\t|");
        System.out.println("-------------------------------------------------------------------------------------");
        for(Notebook i : Notebook.getNotebookList()){
            System.out.println("| " + i.getBrand().getId() + " | " +
                    i.getProductName() + " \t| " +
                    i.getUnitPrice() + "\t| " +
                    i.getBrand().getBrandName() + "\t| " +
                    i.getStorage() + "   \t| " +
                    i.getScreenSize() + "\t| " +
                    i.getRam() + "\t|");
        }
    }

    void addNotebook() {
        while(true) {
            System.out.println("1 - Samsung ID \n2 - Lenovo ID \n3 - Apple ID \n4 - Huawei ID \n5 - Casper ID \n6 - Asus ID \n7 - HP ID \n8 - Xiaomi ID \n9 - Monster ID");
            System.out.print("Eklemek istediğiniz markanın ID numarası: ");
            int id = input.nextInt();
            if (id >=1 && id <= 9) {
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
                Notebook.getNotebookList().add(new Notebook(new Brand(id, Brand.brands.get(id)), unitPrice, discountRate, stock, productName, ram, storage, screenSize));
                showNotebook();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("Ürün başarılı bir şekilde eklendi!");
                System.out.println("-------------------------------------------------------------------------------------");
                break;
            } else {
                System.out.println("Lütfen geçerli bir ID girin!");
            }
        }

    }

    void deleteNotebook() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.print("Silmek istediğiniz ürünün ID'sini giriniz: ");
            int id = input.nextInt();
            for (int i = 0; i < Notebook.getNotebookList().size(); i++) {
                if (Brand.brands.get(id).equals(Notebook.getNotebookList().get(i).getBrand().getBrandName())) {
                    Notebook.getNotebookList().remove(i);
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
            if (Notebook.getNotebookList().isEmpty()) {
                System.out.println("Henüz hiçbir ürün eklenmemiş!");
                isTrue = false;
            } else {
                for (Notebook i : Notebook.getNotebookList()) {
                    if (Brand.brands.get(id).equals(i.getBrand().getBrandName())) {
                        System.out.println("| ID | Ürün Adı       \t| Fiyat    \t| Marka    \t| Depolama | Ekran\t| RAM\t|");
                        System.out.println("-------------------------------------------------------------------------------------");
                        System.out.println("| " + i.getBrand().getId() + " | " +
                                i.getProductName() + " \t| " +
                                i.getUnitPrice() + "\t| " +
                                i.getBrand().getBrandName() + "\t| " +
                                i.getStorage() + "   \t| " +
                                i.getScreenSize() + "\t| " +
                                i.getRam() + "\t|");
                        System.out.println("-------------------------------------------------------------------------------------");
                        isTrue = false;
                    } else {
                        System.out.println("Lütfen geçerli bir ID girin!");
                    }
                }
            }
        }
    }

    void sortNotebookByBrandName () {
        boolean isTrue = true;
        while(isTrue) {
            System.out.print("Sıralamak istediğiniz markayı girin: ");
            String BrandName = input.nextLine();
            input.nextLine();
            if (Notebook.getNotebookList().isEmpty()) {
                System.out.println("Henüz hiçbir ürün eklenmemiş!");
                isTrue = false;
            } else {
                for (Notebook i : Notebook.getNotebookList()) {
                    if (i.getBrand().getBrandName().equals(BrandName)) {
                        System.out.println("| ID | Ürün Adı       \t| Fiyat    \t| Marka    \t| Depolama | Ekran\t| RAM\t|");
                        System.out.println("-------------------------------------------------------------------------------------");
                        System.out.println("| " + i.getBrand().getId() + " | " +
                                i.getProductName() + " \t| " +
                                i.getUnitPrice() + "\t| " +
                                i.getBrand().getBrandName() + "\t| " +
                                i.getStorage() + "   \t| " +
                                i.getScreenSize() + "\t| " +
                                i.getRam() + "\t|");
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

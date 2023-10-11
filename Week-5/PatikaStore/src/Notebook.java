import java.util.HashMap;

public class Notebook extends Brand {
    private double piecePrice;
    private double discount;
    private int stockNumber;
    private String name;
    private int ram;
    private int storage;
    private double screenSize;

    public Notebook(int id, String brandName, double piecePrice, double discount, int stockNumber, String name, int ram, int storage, double screenSize) {
        super(id, brandName);
        this.piecePrice = piecePrice;
        this.discount = discount;
        this.stockNumber = stockNumber;
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public static HashMap<Integer, Notebook> notebooks () {
        HashMap<Integer, Notebook> notebookList = new HashMap<>();
        notebookList.put(1, new Notebook(1, "Asus   ", 8199.0, 0.10, 3500, "ASUS TUF Gaming", 32, 2048, 15.6));
        notebookList.put(2, new Notebook(2, "Casper ", 4500.0, 0.10, 4000, "CASPER Nirvana", 16, 512, 14.0));
        notebookList.put(3, new Notebook(3, "HP     ", 5400.0, 0.15, 2205, "HP Omen       ", 16, 1024, 17.0));
        notebookList.put(4, new Notebook(4, "Lenovo ", 9200, 0.12, 2750, "LENOVO Ideapad", 32, 1024, 15.6));
        notebookList.put(5, new Notebook(5, "Monster", 8800, 0.14, 3000, "MONSTER Tulpar", 32, 2048, 17.0));
        return notebookList;
    }

    public double getPiecePrice() {
        return piecePrice;
    }

    public void setPiecePrice(double piecePrice) {
        this.piecePrice = piecePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}

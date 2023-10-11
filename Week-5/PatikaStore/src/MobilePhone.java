import java.util.HashMap;

public class MobilePhone extends Brand {
    private double piecePrice;
    private double discount;
    private int stockNumber;
    private String name;
    private int ram;
    private int storage;
    private double screenSize;
    private int batteryPower;
    private String color;

    public MobilePhone(int id, String brandName, double piecePrice, double discount, int stockNumber, String name, int ram, int storage, double screenSize, int batteryPower, String color) {
        super(id, brandName);
        this.piecePrice = piecePrice;
        this.discount = discount;
        this.stockNumber = stockNumber;
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.color = color;
    }

    public static HashMap<Integer, MobilePhone> mobilePhones () {
        HashMap<Integer, MobilePhone> mobilePhoneList = new HashMap<>();
        mobilePhoneList.put(1, new MobilePhone(1, "Apple ", 8000.0, 0.08, 1000, "IPHONE 14 Pro Max", 32, 2048, 15.6, 4000, "Mavi"));
        mobilePhoneList.put(2, new MobilePhone(2, "Huawei", 3250.0, 0.12, 4025, "HUAWEI P60 Pro   ", 16, 512, 14.0, 4000, "Sarı"));
        mobilePhoneList.put(3, new MobilePhone(3, "Samsung", 5400.0, 0.15, 2305, "SAMSUNG Galaxy S22", 16, 1024, 17.0, 3046, "Yeşil"));
        mobilePhoneList.put(4, new MobilePhone(4, "Xiaomi", 5200.0, 0.10, 2270, "XIAOMI Redmi 12   ", 32, 1024, 15.6, 4000, "Lila"));
        return mobilePhoneList;
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

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

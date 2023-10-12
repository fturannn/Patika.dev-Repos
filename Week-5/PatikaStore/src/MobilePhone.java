import java.util.ArrayList;

public class MobilePhone extends Product{
    private int batteryPower;
    private String color;
    private static ArrayList<MobilePhone> mobilePhoneList = new ArrayList<>();

    public MobilePhone(Brand brand, double unitPrice, double discountRate, int stock, String productName, int ram, int storage, double screenSize, int batteryPower, String color) {
        super(brand, unitPrice, discountRate, stock, productName, ram, storage, screenSize);
        this.batteryPower = batteryPower;
        this.color = color;
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

    public static ArrayList<MobilePhone> getMobilePhoneList() {
        return mobilePhoneList;
    }

    public static void setMobilePhoneList(ArrayList<MobilePhone> mobilePhoneList) {
        MobilePhone.mobilePhoneList = mobilePhoneList;
    }
}

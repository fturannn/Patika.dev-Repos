import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Brand {
    private int id;
    private String brandName;

    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public static HashMap<Integer, String> brands () {
        HashMap<Integer, String> brandList = new HashMap<>();
        brandList.put(1, "Samsung");
        brandList.put(2, "Lenovo");
        brandList.put(3, "Apple");
        brandList.put(4, "Huawei");
        brandList.put(5, "Casper");
        brandList.put(6, "Asus");
        brandList.put(7, "HP");
        brandList.put(8, "Xiaomi");
        brandList.put(9, "Monster");
        return brandList;
    }

    public static void showBrand() {
        TreeSet<String> brandNames = new TreeSet<>(new BrandNameComparator());
        brandNames.addAll(brands().values());
        for (String i : brandNames) {
            System.out.println("— " + i);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}

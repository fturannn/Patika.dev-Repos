import java.util.*;

public class Brand {
    private int id;
    private String brandName;
    static HashMap<Integer, String> brands = new HashMap<>();

    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    static {
        brands.put(1, "Samsung");
        brands.put(2, "Lenovo");
        brands.put(3, "Apple");
        brands.put(4, "Huawei");
        brands.put(5, "Casper");
        brands.put(6, "Asus");
        brands.put(7, "HP");
        brands.put(8, "Xiaomi");
        brands.put(9, "Monster");
    }

    public static void showBrand() {
        TreeSet<String> brandNames = new TreeSet<>(new BrandNameComparator());
        brandNames.addAll(brands.values());
        for (String i: brandNames) {
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

import java.util.Scanner;
import java.util.ArrayList;

public class Notebook extends Product{
    Scanner input = new Scanner(System.in);
    private static ArrayList<Notebook> notebookList = new ArrayList<>();

    public Notebook(Brand brand, double unitPrice, double discountRate, int stock, String productName, int ram, int storage, double screenSize) {
        super(brand, unitPrice, discountRate, stock, productName, ram, storage, screenSize);
    }

    public static ArrayList<Notebook> getNotebookList() {
        return notebookList;
    }

    public static void setNotebookList(ArrayList<Notebook> notebookList) {
        Notebook.notebookList = notebookList;
    }
}

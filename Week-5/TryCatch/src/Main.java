import java.util.Scanner;
public class Main {
    public static void indexOf(int[] arr, int a) throws ArrayIndexOutOfBoundsException {
        if (a > arr.length - 1 || a < 0) {
            throw new ArrayIndexOutOfBoundsException("Index Hatası!");
        } else {
            for(int i = 0; i < arr.length; i++) {
                if (i == a) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index;

        System.out.print("Dizide görmek istediğiniz indexi girin: ");
        index = input.nextInt();

        try {
            indexOf(arr, index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Dizi sınırlarının dışında bir index girildi");
        }

    }
}
import java.util.Scanner;
import java.util.Arrays;
public class DiziMaxMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.print("Enter a number: ");
        number = input.nextInt();

        System.out.print("Enter number of elements you want to input: ");
        int[] arr = new int[input.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        int count1 = 0;
        int count2 = 0;
        for (int i : arr) {
            if (i < number) {
                count1++;
            } else {
                count2++;
            }
        }

        int[] array1 = new int[count1];
        int[] array2 = new int[count2];

        int count3 = 0;
        int count4 = 0;
        for (int j : arr) {
            if (j < number) {
                array1[count3] = j;
                count3++;
            } else {
                array2[count4] = j;
                count4++;
            }
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        System.out.println("The nearest number of elements in the array that is less than the entered number: " + array1[array1.length - 1]);
        System.out.println("The nearest number of elements in the array that is greater than the entered number: " + array2[0]);
    }
}

import java.util.Scanner;
import java.util.Arrays;
public class MatrixTranspoze {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int satir, sutun;

        // Matris satır ve sütun sayılarını kullanıcıdan al
        System.out.print("Matris satır sayısını girin: ");
        satir = input.nextInt();

        System.out.print("Matrix sütun sayısını girin: ");
        sutun = input.nextInt();

        int[][] matrix = new int[satir][sutun];
        int[][] transpoze = new int[sutun][satir];

        // Kullanıcının girdiği sayılarla matris oluştur
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print((i + 1) + ". satır " + (j + 1) + ". sütun: ");
                matrix[i][j] = input.nextInt();
                transpoze[j][i] = matrix [i][j]; /* Transpozu için matrisin satırını
                sütuna, sütununu satıra kopyalıyoruz */
            }
        }
        
        // Matris ve transpozesini ekrana yazdır
        System.out.println("Matris: ");
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Transpoze: ");
        for (int i = 0; i < sutun; i++) {
            for (int j = 0; j < satir; j++) {
                System.out.print(transpoze[i][j] + " ");
            }
            System.out.println();
        }
    }
}

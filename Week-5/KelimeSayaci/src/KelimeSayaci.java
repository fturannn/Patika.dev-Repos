import java.util.HashMap;
import java.util.Scanner;
public class KelimeSayaci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Metininizi girin:  ");
        String text = input.nextLine();
        String [] textArr = text.split(" ");

        HashMap<String, Integer> wordCount = new HashMap<>();

        String maxWord = "";
        int max = 0;
        for (int i = 0; i < textArr.length; i++) {
            int count = 0;
            for (int j = 0; j < textArr.length; j++) {
                if (textArr[i].equals(textArr[j])) {
                    count++;
                }
            }
            wordCount.put(textArr[i], count);
            if (count > max) {
                max = count;
                maxWord = textArr[i];
            }
        }

        System.out.println("Girilen metinde en çok geçen kelime: " + maxWord);
        System.out.println("Bu kelime toplam " + max + " kere tekrarlanmıştır.");

    }
}
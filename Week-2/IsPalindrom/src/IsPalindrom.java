import java.util.Scanner;
import java.util.Arrays;
public class IsPalindrom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word;

        System.out.print("Enter a word: ");
        word = input.nextLine();

        String reverse = reverse(word);

        if(word.equals(reverse)) {
            System.out.println("The word you just entered is palindrome");
        } else {
            System.out.println("The word you just entered is not palindrome");
        }
    }

    static String reverse(String word) {
        String reverse = "";
        for (int i = (word.length() - 1); i >= 0; i--){
            reverse += word.charAt(i);
        }
        return reverse;
    }
}

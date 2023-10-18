import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir metin girin: ");
        String wLine = input.nextLine();

        try {
            FileWriter fWriter = new FileWriter("Notlar.txt");
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(wLine);
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            FileReader fReader = new FileReader("Notlar.txt");
            BufferedReader bReader = new BufferedReader(fReader);
            String rLine = bReader.readLine();
            while (rLine != null) {
                System.out.print(rLine);
                rLine = bReader.readLine();
            }
            fReader.close();
            bReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
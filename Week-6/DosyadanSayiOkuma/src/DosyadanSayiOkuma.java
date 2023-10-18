import java.io.*;

public class DosyadanSayiOkuma {
    public static void main(String[] args) {
        int total = 0;
        try {
            FileReader nReader = new FileReader("patika.txt");
            BufferedReader bReader = new BufferedReader(nReader);
            String line = bReader.readLine();
            while (line != null) {
                total += Integer.parseInt(line);
                line = bReader.readLine();
            }
            bReader.close();
            nReader.close();
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> book = new TreeSet<>();
        TreeSet<Book> book2 = new TreeSet<>(new PageComparator());
        book.add(new Book("Hayvan Çiftliği", 152, "George Orwell", 1945));
        book.add(new Book("Satranç", 192, "Stefan Zweig", 1942));
        book.add(new Book("Küçük Prens", 112, "Antoine de Saint-Exupéry", 1945));
        book.add(new Book("Şeker Portakalı", 182, "José Mauro de Vasconcelos", 1968));
        book.add(new Book("Dönüşüm", 104, "Franz Kafka", 1915));

        book2.addAll(book);

        for(Book b : book) {
            System.out.println(b.getName() + " " + b.getPage()); // Sayfa adına göre sıralama
        }
        System.out.println();
        for(Book b : book2) {
            System.out.println(b.getPage() + " " + b.getName()); // Sayfa sayısına göre sıralama
        }
    }
}
import java.util.Comparator;

public class PageComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getPage() - b2.getPage();
    }
}

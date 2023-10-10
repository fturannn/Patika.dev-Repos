public class Book implements Comparable<Book>{
    private String name;
    private Integer page;
    private String author;
    private int publicationDate;

    public Book(String name, int page, String author, int publicationDate) {
        this.name = name;
        this.page = page;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    @Override public int compareTo(Book a) {
        return this.page.compareTo(a.getPage());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publishYear) {
        this.publicationDate = publishYear;
    }
}

public class Book
{
    private String title;
    private String author;
    private String publisher;
    private String copyrightDate;

    // constructor method
    public Book(String title, String author,
                String publisher, String copyrightDate){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copyrightDate = copyrightDate;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getCopyrightDate() {
        return copyrightDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setCopyrightDate(String copyrightDate) {
        this.copyrightDate = copyrightDate;
    }

    @Override
    public String toString() {
        return "========================================="+"\n"+
                "TITLE:\t\t\t"+ title+"\n"+
                "Author:\t\t\t"+author+"\n"+
                "Publisher:\t\t"+publisher+"\n"+
                "Copyright Date:\t"+copyrightDate+
                "\n"+"========================================="+"\n";
    }
}
class Bookshelf {
    public static void main(String[] args) {
        Book book1 = new Book("Vilest Things","Chloe Gong",
                "Simon & Schuster","Red Room Press, 2009");

        Book book2 = new Book("Not Even Bones","Rebecca Schaeffer",
                "Houghton Mifflin Harcourt","4 September 2018");

        System.out.println(book1);
        System.out.println(book2);
    }
}

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

//    public String toString() {
//        return "Sphere with diameter " + diameter +
//                ", surface area " + calculateSurfaceArea()+
//                " and volume " + calculateVolume();
//    }
}

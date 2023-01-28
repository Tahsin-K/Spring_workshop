package lexicon.se.spring_workshop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity

public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(nullable = false, length = 250)
    private String isbn;
    @Column(nullable = false, length = 250)
    private String title;
    private int maxLoanDays;


    @ManyToMany(mappedBy = "writtenBook" )
    private Set<Author> authorList;

    public Book(int bookId, String isbn, String title, int maxLoanDays) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public Book (){
    }

    public void addAuthor(Author author){
        if (author == null) throw new IllegalArgumentException("Author is null");
        if(authorList == null) authorList = new HashSet<>();
        authorList.add(author);
        author.addBook(this);
    }

    public void removeAuthor(Author author){
        if(author == null) throw new IllegalArgumentException("Author was null");
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }


    public Set<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(Set<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", maxLoanDays=" + maxLoanDays +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && maxLoanDays == book.maxLoanDays && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, title, maxLoanDays);
    }
}

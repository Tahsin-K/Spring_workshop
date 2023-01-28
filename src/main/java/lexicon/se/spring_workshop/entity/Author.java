package lexicon.se.spring_workshop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int authorId;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;

    @ManyToMany(cascade = {CascadeType.ALL})
     private Set<Book> writtenBook;

    public Author(String firstName, String lastName, Set<Book> writtenBook) {
        this();
        this.writtenBook = writtenBook;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author () {

    }

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book was null");
        if(writtenBook == null) writtenBook = new HashSet<>();
        writtenBook.add(book);
        book.getAuthorList().add(this);
    }

    public void removeBook(Book book){
        if (book == null) throw new IllegalArgumentException("Book was null");
        if(writtenBook != null){
            book.getAuthorList().remove(this);
            writtenBook.remove(book);
        }


    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getWrittenBook() {
        return writtenBook;
    }

    public void setWrittenBook(Set<Book> writtenBook) {
        this.writtenBook = writtenBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(writtenBook, author.writtenBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, lastName, writtenBook);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", writtenBook=" + writtenBook +
                '}';
    }
}

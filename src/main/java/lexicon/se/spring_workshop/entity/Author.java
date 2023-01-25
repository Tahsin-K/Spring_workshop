package lexicon.se.spring_workshop.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int authorId;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
     private List<Book> writtenBook;

    public Author(int authorId, String firstName, String lastName, List<Book> writtenBook) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBook = writtenBook;

    }

    public Author () {

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

    public List<Book> getWrittenBook() {
        return writtenBook;
    }

    public void setWrittenBook(List<Book> writtenBook) {
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
}

package lexicon.se.spring_workshop.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Details {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;
    @Column(nullable = false,length = 100, unique = true)
    private String email;
    @Column(nullable = false,length= 100)
    private String name;
    private LocalDate brithDate;



    public Details(int detailsId, String email, String name, LocalDate brithDate) {
        this.detailsId = detailsId;
        this.email = email;
        this.name = name;
        this.brithDate = brithDate;
    }

    public Details(String email, String name, LocalDate brithDate) {
        this.email = email;
        this.name = name;
        this.brithDate = brithDate;
    }

    public Details() {

    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(LocalDate brithDate) {
        this.brithDate = brithDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return detailsId == details.detailsId && Objects.equals(email, details.email) && Objects.equals(name, details.name) && Objects.equals(brithDate, details.brithDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, email, name, brithDate);
    }
}

package lexicon.se.spring_workshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

    @Column(nullable = false, length = 100, unique = true)
    private String UserName;

    @Column(nullable = false,length = 100)
    private String Password;
    private LocalDate regdate;

    @OneToOne (cascade = {CascadeType.ALL})
    @JoinColumn(name = "Details_Id")
    private Details details;

    public AppUser(){

    }

    public AppUser(String userName, String password, LocalDate regdate, Details details) {
        UserName = userName;
        Password = password;
        this.regdate = regdate;
        this.details = details;
    }

    public int getAppUserID() {
        return appUserId;
    }

    public void setAppUserID(int appUserID) {
        appUserID = appUserID;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public LocalDate getRegdate() {
        return regdate;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId && Objects.equals(UserName, appUser.UserName) && Objects.equals(Password, appUser.Password) && Objects.equals(regdate, appUser.regdate) && Objects.equals(details, appUser.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, UserName, Password, regdate, details);
    }
}

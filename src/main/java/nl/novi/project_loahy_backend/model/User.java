package nl.novi.project_loahy_backend.model;

import javax.persistence.*;


@Entity(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNumber;

    @Column(length = 100)
    private String userName;

    private String userEmail;

    private String userPassword;

    private String userAdres;

    private Long userPhone;


    public User() {
    }

    public User(Long userNumber, String userName, String userEmail, String userAdres, Long userPhone) {
        this.userNumber = userNumber;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAdres = userAdres;
        this.userPhone = userPhone;
    }

    public User(String userName, String userEmail, String userAdres, Long userPhone) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAdres = userAdres;
        this.userPhone = userPhone;
    }


    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userId) {
        this.userNumber = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userFirstName) {
        this.userName = userFirstName;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAdres() {
        return userAdres;
    }

    public void setUserAdres(String userAdres) {
        this.userAdres = userAdres;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}


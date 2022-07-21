package nl.novi.project_loahy_backend.model;

import javax.persistence.*;


@Entity
@Table(name="Users")
public class User {

    @Id
    @SequenceGenerator(
            name = "userId_sequence",
            sequenceName = "userId_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "userId_sequence")
    private Long userId;

    @Column(name = "First Name")
    private String userFirstName;

    @Column(name = "Last Name")
    private String userLastName;
    @Column(name = "Email")
    private String userEmail;
    @Column(name = "Adres")
    private String userAdres;
    @Column(name = "Phone")
    private Long userPhone;


    public User() {
    }


    public User(Long userId, String userFirstName, String userLastName, String userEmail, String userAdres, Long userPhone) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userAdres = userAdres;
        this.userPhone = userPhone;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
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


}


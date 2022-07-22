package nl.novi.project_loahy_backend.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1001"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    private Long userNumber;

    @Column(name = "userName")
    private String userName;

    @Column(name = "Email")
    private String userEmail;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Column(name="Password")
    private String userPassword;
    @Column(name = "Adres")
    private String userAdres;
    @Column(name = "Phone")
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


}


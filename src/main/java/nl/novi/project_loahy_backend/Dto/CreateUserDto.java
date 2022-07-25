package nl.novi.project_loahy_backend.Dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CreateUserDto {
    @Length(min = 30, max = 100)
    private String userName;

    private String userEmail;
    @NotBlank
    private String userPassword;
    @NotBlank
    private String userAdres;
    @NotBlank
    private Long userPhone;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

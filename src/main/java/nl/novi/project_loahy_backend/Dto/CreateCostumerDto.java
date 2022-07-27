package nl.novi.project_loahy_backend.Dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CreateCostumerDto {
    @Length(min = 30, max = 100)
    private String costumerName;

    private String costumerEmail;
    @NotBlank
    private String costumerPassword;
    @NotBlank
    private String costumerAdres;
    @NotBlank
    private Long costumerPhone;


    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getCostumerEmail() {
        return costumerEmail;
    }

    public void setCostumerEmail(String costumerEmail) {
        this.costumerEmail = costumerEmail;
    }

    public String getCostumerPassword() {
        return costumerPassword;
    }

    public void setCostumerPassword(String costumerPassword) {
        this.costumerPassword = costumerPassword;
    }

    public String getCostumerAdres() {
        return costumerAdres;
    }

    public void setCostumerAdres(String costumerAdres) {
        this.costumerAdres = costumerAdres;
    }

    public Long getCostumerPhone() {
        return costumerPhone;
    }

    public void setCostumerPhone(Long costumerPhone) {
        this.costumerPhone = costumerPhone;
    }
}

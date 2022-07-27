package nl.novi.project_loahy_backend.Dto;


import lombok.Data;
import nl.novi.project_loahy_backend.model.Order;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class CostumerDto {


    private Long costumerId;
    private String costumerName;
    private String costumerEmail;
    private String costumerAdres;
    private Long costumerPhone;

    @OneToMany(mappedBy = "custumerid")
    private List<Order> orders;


    public Long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Long costumerId) {
        this.costumerId = costumerId;
    }

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

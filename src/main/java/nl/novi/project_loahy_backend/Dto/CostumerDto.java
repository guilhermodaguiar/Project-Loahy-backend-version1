package nl.novi.project_loahy_backend.Dto;

import nl.novi.project_loahy_backend.model.Order;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class CostumerDto {

    @Id
    private Long costumerId;

    private String password;
    private String costumerName;
    private String costumerEmail;
    private String costumerAdres;
    private Long costumerPhone;

    @OneToMany
    private List<Order> order;




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

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

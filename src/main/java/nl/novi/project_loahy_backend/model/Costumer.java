package nl.novi.project_loahy_backend.model;

import javax.persistence.*;
import java.util.List;


@Entity(name="costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costumerId;

    @Column(name="costumer_name", length = 100)
    private String costumerName;
    @Column(name="costumer_email")
    private String costumerEmail;
    @Column(name="costumer_password")
    private String costumerPassword;
    @Column(name="costumer_adres")
    private String costumerAdres;
    @Column(name="costumer_phone")
    private Long costumerPhone;

    @OneToMany(mappedBy = "custumerid")
    private List<Order> orders;


    public Costumer() {
    }

    public Costumer(Long costumerId, String costumerName, String costumerEmail, String costumerAdres, Long costumerPhone) {
        this.costumerId = costumerId;
        this.costumerName = costumerName;
        this.costumerEmail = costumerEmail;
        this.costumerAdres = costumerAdres;
        this.costumerPhone = costumerPhone;
    }

    public Costumer(String costumerName, String costumerEmail, String costumerAdres, Long costumerPhone) {
        this.costumerName = costumerName;
        this.costumerEmail = costumerEmail;
        this.costumerAdres = costumerAdres;
        this.costumerPhone = costumerPhone;
    }


    public Long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Long userId) {
        this.costumerId = userId;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String userFirstName) {
        this.costumerName = userFirstName;
    }


    public String getCostumerEmail() {
        return costumerEmail;
    }

    public void setCostumerEmail(String userEmail) {
        this.costumerEmail = userEmail;
    }

    public String getCostumerAdres() {
        return costumerAdres;
    }

    public void setCostumerAdres(String userAdres) {
        this.costumerAdres = userAdres;
    }

    public Long getCostumerPhone() {
        return costumerPhone;
    }

    public void setCostumerPhone(Long userPhone) {
        this.costumerPhone = userPhone;
    }

    public String getCostumerPassword() {
        return costumerPassword;
    }

    public void setCostumerPassword(String userPassword) {
        this.costumerPassword = userPassword;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}


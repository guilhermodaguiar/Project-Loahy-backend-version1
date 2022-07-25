package nl.novi.project_loahy_backend.model;

import javax.persistence.OneToMany;
import java.util.List;

public class Order {

    private Long orderNumber;

    //Denk ik een one to many met producten of one to one met producten
    @OneToMany(mappedBy = "orderNumber")
    private List<Product> products;


}

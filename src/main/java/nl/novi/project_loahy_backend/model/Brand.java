package nl.novi.project_loahy_backend.model;

import javax.persistence.*;

@Entity
@Table
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String brandTitle;

    private String brandInformation;


    public String getBrandTitle() {
        return brandTitle;
    }

    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle;
    }

    public String getBrandInformation() {
        return brandInformation;
    }

    public void setBrandInformation(String brandInformation) {
        this.brandInformation = brandInformation;
    }

}

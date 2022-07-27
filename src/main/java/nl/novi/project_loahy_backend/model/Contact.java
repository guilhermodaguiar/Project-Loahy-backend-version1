package nl.novi.project_loahy_backend.model;

import javax.persistence.*;

@Entity
@Table
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    @Column
    private String contactName;
    @Column
    private String contactEmail;
    @Column
    private Long contactPhone;
    @Column
    private String contactOrganisation;
    @Column
    private String remark;




    public String getContactName() {
        return contactName;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactNumber) {
        this.contactId = contactNumber;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Long contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactOrganisation() {
        return contactOrganisation;
    }

    public void setContactOrganisation(String contactOrganisation) {
        this.contactOrganisation = contactOrganisation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

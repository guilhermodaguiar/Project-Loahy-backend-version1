package nl.novi.project_loahy_backend.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CreateContactDto {
    @NotBlank
    private String contactName;
    @Email
    private String contactEmail;
    @NotBlank
    private Long contactPhone;
    private String contactOrganisation;
    @NotBlank
    private String remark;



    public String getContactName() {
        return contactName;
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

package nl.novi.project_loahy_backend.Dto;

import javax.validation.constraints.NotBlank;

public class CreateBrandDto {
    @NotBlank
    private String brandTitle;
    @NotBlank
    private String brandInfo;

    public String getBrandTitle() {
        return brandTitle;
    }

    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle;
    }

    public String getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(String brandInfo) {
        this.brandInfo = brandInfo;
    }
}

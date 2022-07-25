package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.BrandDto;
import nl.novi.project_loahy_backend.Dto.CreateBrandDto;
import nl.novi.project_loahy_backend.exeptions.RecordNotFoundException;
import nl.novi.project_loahy_backend.model.Brand;
import nl.novi.project_loahy_backend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    //aanpassen
    public List<BrandDto> getBrandsInfo() {
        return brandRepository.findAll();
    }


    public BrandDto createBrandInfo(CreateBrandDto createBrandDto) {

        Brand brand = new Brand();
        brand.setBrandTitle(createBrandDto.getBrandTitle());
        brand.setBrandInformation(createBrandDto.getBrandInfo());

        final Brand savedBrand = brandRepository.save(brand);

        BrandDto brandDto = new BrandDto();
        brandDto.setBrandTitle(savedBrand.getBrandTitle());
        brandDto.setBrandInfo(savedBrand.getBrandInformation());

        return brandDto;
    }

    //later aanpassen
    public BrandDto updateBrandInfo(String BrandTitle, BrandDto brandDto) {
        return brandRepository.save(old);
    } else {

        throw new RecordNotFoundException("Brand update failed")
    }

}

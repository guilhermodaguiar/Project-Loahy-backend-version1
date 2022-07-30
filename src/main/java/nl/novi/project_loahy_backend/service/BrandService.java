package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.BrandDto;
import nl.novi.project_loahy_backend.Dto.CreateBrandDto;
import nl.novi.project_loahy_backend.exeptions.BrandNotFoundException;
import nl.novi.project_loahy_backend.model.Brand;
import nl.novi.project_loahy_backend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BrandService {

    @Autowired
    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    public List<BrandDto> getBrandsInfo() {
        List<BrandDto> collection = new ArrayList<>();
        List<Brand> list = brandRepository.findAll();
        for (Brand brand : list) {
            collection.add(fromBrand(brand));
        }
        return collection;
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
    public void updateBrandInfo(String brandTitle, BrandDto newBrand) {
        if (!brandRepository.existsById(brandTitle)) throw new BrandNotFoundException(brandTitle);
        Brand brand = brandRepository.findById(brandTitle).get();
        brand.setBrandTitle(newBrand.getBrandTitle());
        brand.setBrandTitle(newBrand.getBrandTitle());
        brandRepository.save(brand);
    }

    public static BrandDto fromBrand(Brand brand) {

        var brandDto =  new BrandDto();

        brandDto.setBrandTitle(brand.getBrandTitle());
        brandDto.setBrandInfo(brand.getBrandTitle());

        return brandDto;
    }

}

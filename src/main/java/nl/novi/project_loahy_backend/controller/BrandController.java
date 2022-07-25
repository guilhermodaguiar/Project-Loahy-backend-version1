package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.BrandDto;
import nl.novi.project_loahy_backend.Dto.CreateBrandDto;
import nl.novi.project_loahy_backend.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about-loahy")
public class BrandController {

    @Autowired
    private final BrandService brandService;

    public BrandController(BrandService brandService) {this.brandService = brandService; }

    @GetMapping()
    public ResponseEntity<List<BrandDto>> getBrandsInfo(){
        List<BrandDto> brandDtos = brandService.getBrandsInfo();

        return ResponseEntity.ok().body(brandDtos);
    }

    @PostMapping("")
    public ResponseEntity<BrandDto> createBrandInfo(@RequestBody CreateBrandDto createBrandDto ) {
        final BrandDto createBrand = brandService.createBrandInfo(createBrandDto);

        return ResponseEntity.ok(createBrand);
    }

    @PutMapping("/{title}")
    public ResponseEntity<BrandDto> updateBrandInfo(@PathVariable("title") String brandTitle,@RequestBody BrandDto brandDto) {

        brandService.updateBrandInfo(brandDto);
        return ResponseEntity.noContent().build();
    }


}

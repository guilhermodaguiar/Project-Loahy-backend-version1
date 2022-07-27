package nl.novi.project_loahy_backend.controller;


import nl.novi.project_loahy_backend.Dto.CreateCostumerDto;
import nl.novi.project_loahy_backend.Dto.CostumerDto;
import nl.novi.project_loahy_backend.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/costumers")
public class CostumerController {

    @Autowired
    private final CostumerService costumerService;


    public CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping()
    public ResponseEntity<List<CostumerDto>> getAllCostumers() {

        List<CostumerDto> costumerDtos = costumerService.getAllCostumers();

        return ResponseEntity.ok().body(costumerDtos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CostumerDto> getCostumerById(@PathVariable("id") Long costumerId) {

        CostumerDto optionalCostumer = costumerService.getCostumerById(costumerId);

        return ResponseEntity.ok().body(optionalCostumer);
    }

    @PostMapping()
    public ResponseEntity<CostumerDto> createCostumer(@RequestBody CreateCostumerDto createCostumerDto) {

        final CostumerDto createdCostumer = costumerService.createCostumer(createCostumerDto);

        final URI location = URI.create("/costumers/" + createdCostumer.getCostumerId());
        return ResponseEntity
                .created(location)
                .body(createdCostumer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostumerDto> updateCostumer(@PathVariable("id")Long costumerId, @RequestBody CostumerDto costumerDto) {

       costumerService.updateUser(costumerId, costumerDto);

       return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CostumerDto>deleteCostumer(@PathVariable("id") Long costumerId) {
        costumerService.deleteCostumer(costumerId);
        return ResponseEntity.noContent().build();
    }

}

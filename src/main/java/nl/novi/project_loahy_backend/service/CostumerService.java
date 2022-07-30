package nl.novi.project_loahy_backend.service;


import nl.novi.project_loahy_backend.Dto.CostumerDto;
import nl.novi.project_loahy_backend.Dto.CreateCostumerDto;
import nl.novi.project_loahy_backend.exeptions.CostumerEmailExistException;
import nl.novi.project_loahy_backend.exeptions.CostumerNotFoundException;
import nl.novi.project_loahy_backend.model.Costumer;
import nl.novi.project_loahy_backend.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CostumerService {
    private final CostumerRepository costumerRepository;


    @Autowired
    public CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<CostumerDto> getAllCostumers() {
        List<CostumerDto> collection = new ArrayList<>();
        List<Costumer> list = costumerRepository.findAll();
        for (Costumer costumer : list) {
            collection.add(fromCostumer(costumer));
        }
        return collection;
    }


    public CostumerDto getCostumerById(Long costumerId) {
        new CostumerDto();
        CostumerDto costumerDto;
        Optional<Costumer> costumer = costumerRepository.findById(costumerId);
        if (costumer.isPresent()) {
            costumerDto = fromCostumer(costumer.get());
        } else {
            throw new CostumerNotFoundException(costumerId);
        }
        return costumerDto;
    }


    public CostumerDto createCostumer(CreateCostumerDto createCostumerDto) {

        final Optional<Costumer> emailOptional =
                costumerRepository.findUserByCostumerEmailIs(createCostumerDto.getCostumerEmail());
        if(emailOptional.isPresent()){
            throw new CostumerEmailExistException(createCostumerDto.getCostumerEmail());
        }

        Costumer newCostumer = new Costumer();
        newCostumer.setCostumerName(createCostumerDto.getCostumerName());
        newCostumer.setCostumerEmail(createCostumerDto.getCostumerEmail());
        newCostumer.setCostumerPassword(createCostumerDto.getCostumerPassword());
        newCostumer.setCostumerAdres(createCostumerDto.getCostumerAdres());
        newCostumer.setCostumerPhone(createCostumerDto.getCostumerPhone());

        final Costumer savedCostumer = costumerRepository.save(newCostumer);

        final CostumerDto costumerDto = new CostumerDto();
        costumerDto.setCostumerId(savedCostumer.getCostumerId());
        costumerDto.setCostumerName(savedCostumer.getCostumerName());
        costumerDto.setCostumerEmail(savedCostumer.getCostumerEmail());
        costumerDto.setCostumerAdres(savedCostumer.getCostumerAdres());
        costumerDto.setCostumerPhone(savedCostumer.getCostumerPhone());

        return costumerDto;
    }


    public void updateUser(Long costumerId, CostumerDto newCostumer) {
        if (!costumerRepository.existsById(costumerId)) throw new CostumerNotFoundException(costumerId);
        Costumer costumer = costumerRepository.findById(costumerId).get();
        costumer.setCostumerName(newCostumer.getCostumerName());
        costumer.setCostumerPassword(newCostumer.getPassword());
        costumer.setCostumerEmail(newCostumer.getCostumerEmail());
        costumer.setCostumerAdres(newCostumer.getCostumerAdres());
        costumer.setCostumerPhone(newCostumer.getCostumerPhone());
        costumerRepository.save(costumer);
    }

    public void deleteCostumer(Long costumerId) {
        costumerRepository.deleteById(costumerId);
    }



    public static CostumerDto fromCostumer(Costumer costumer){

        var costumerDto = new CostumerDto();

        costumerDto.setCostumerId(costumer.getCostumerId());
        costumerDto.setCostumerName(costumer.getCostumerName());
        costumerDto.setCostumerEmail(costumer.getCostumerEmail());
        costumerDto.setCostumerAdres(costumer.getCostumerAdres());
        costumerDto.setCostumerPhone(costumer.getCostumerPhone());


        return costumerDto;
    }
}

package nl.novi.project_loahy_backend.service;


import nl.novi.project_loahy_backend.Dto.CreateCostumerDto;
import nl.novi.project_loahy_backend.Dto.CostumerDto;
import nl.novi.project_loahy_backend.exeptions.CostumerNotFoundException;
import nl.novi.project_loahy_backend.exeptions.CostumerEmailExistException;
import nl.novi.project_loahy_backend.model.Costumer;
import nl.novi.project_loahy_backend.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class CostumerService {
    private final CostumerRepository costumerRepository;

    @Autowired
    public CostumerService(CostumerRepository costumerRepository){this.costumerRepository = costumerRepository;}

    public List<CostumerDto> getAllCostumers() {
        List<Costumer> list = costumerRepository.findAll();
        return null;
    }


    public CostumerDto getCostumerById(Long CostumerId) {
        CostumerDto costumerDto = new CostumerDto();
        Optional<Costumer> costumer = costumerRepository.findById(CostumerId);
        if (costumer.isPresent()) {
            return fromCostumer(costumer.get());
        } else {
            throw new CostumerNotFoundException(CostumerId);
        }
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

    //later aanpassen
    public void updateUser(Long userNumber, CostumerDto newCostumer) {
        if (!costumerRepository.existsById(userNumber)) throw new CostumerNotFoundException();
        Costumer costumer = costumerRepository.findById(userNumber).get();
        costumerRepository.save(costumer);
    }

    public void deleteCostumer(Long costumerId) {
        costumerRepository.deleteById(costumerId);
    }

}

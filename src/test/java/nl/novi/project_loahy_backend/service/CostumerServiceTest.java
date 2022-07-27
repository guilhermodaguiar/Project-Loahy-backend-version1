package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.CreateCostumerDto;
import nl.novi.project_loahy_backend.exeptions.CostumerEmailExistException;
import nl.novi.project_loahy_backend.model.Costumer;
import nl.novi.project_loahy_backend.repository.CostumerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CostumerServiceTest {

    @Mock
    CostumerRepository costumerRepository;

    @Mock
    Costumer mockCostumerEmail;

    @InjectMocks
    CostumerService sut;

    @Test
    public void whenUserEmailExistsAnExceptionIsThrown(){

        //Arrange
        when(costumerRepository.findUserByUserEmailIs("ggd_daguiar@gmail.com"))
                .thenReturn(Optional.of(mockCostumerEmail));

        CreateCostumerDto userDto = new CreateCostumerDto();
        userDto.setCostumerEmail("ggd_daguiar@hotmail.com");

        //Act
        assertThrows(CostumerEmailExistException.class, () ->{
            sut.createCostumer(userDto);
                });

        //Assert


    }

}
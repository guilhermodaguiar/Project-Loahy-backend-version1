package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.exeptions.CostumerEmailExistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CostumerEmailExistExceptionTest {

    @Test
    public void userEmailIsPresentInExceptionMessage(){
        //Arrange
        final String expectedUserEmail = "ggd_daguiar@gmail.com";

        //Act
        CostumerEmailExistException sut = new CostumerEmailExistException(expectedUserEmail);

        //Assert
        assertTrue(sut.getMessage().contains("'" + expectedUserEmail + "'"));
    }
}

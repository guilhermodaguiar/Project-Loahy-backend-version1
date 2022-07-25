package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.exeptions.UserEmailExistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserEmailExistExceptionTest {

    @Test
    public void userEmailIsPresentInExceptionMessage(){
        //Arrange
        final String expectedUserEmail = "ggd_daguiar@gmail.com";

        //Act
        UserEmailExistException sut = new UserEmailExistException(expectedUserEmail);

        //Assert
        assertTrue(sut.getMessage().contains("'" + expectedUserEmail + "'"));
    }
}

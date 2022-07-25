package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.CreateUserDto;
import nl.novi.project_loahy_backend.exeptions.UserEmailExistException;
import nl.novi.project_loahy_backend.model.User;
import nl.novi.project_loahy_backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    User mockUserEmail;

    @InjectMocks
    UserService sut;

    @Test
    public void whenUserEmailExistsAnExceptionIsThrown(){

        //Arrange
        when(userRepository.findUserByUserEmailIs("ggd_daguiar@gmail.com"))
                .thenReturn(Optional.of(mockUserEmail));

        CreateUserDto userDto = new CreateUserDto();
        userDto.setUserEmail("ggd_daguiar@hotmail.com");

        //Act
        assertThrows(UserEmailExistException.class, () ->{
            sut.createUser(userDto);
                });

        //Assert


    }

}
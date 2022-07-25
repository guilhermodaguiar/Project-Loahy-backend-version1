package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.CreateUserDto;
import nl.novi.project_loahy_backend.Dto.UserDto;
import nl.novi.project_loahy_backend.exeptions.RecordNotFoundException;
import nl.novi.project_loahy_backend.exeptions.UserEmailExistException;
import nl.novi.project_loahy_backend.model.User;
import nl.novi.project_loahy_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){this.userRepository = userRepository;}




    public UserDto createUser(CreateUserDto createUserDto) {

        final Optional<User> emailOptional =
                userRepository.findUserByUserEmailIs(createUserDto.getUserEmail());
        if(emailOptional.isPresent()){
            throw new UserEmailExistException(createUserDto.getUserEmail());
        }

        User user = new User();
        user.setUserName(createUserDto.getUserName());
        user.setUserEmail(createUserDto.getUserEmail());
        user.setUserPassword(createUserDto.getUserPassword());
        user.setUserAdres(createUserDto.getUserAdres());
        user.setUserPhone(createUserDto.getUserPhone());

        final User savedUser = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setUserNumber(savedUser.getUserNumber());
        userDto.setUserName(savedUser.getUserName());
        userDto.setUserEmail(savedUser.getUserEmail());
        userDto.setUserAdres(savedUser.getUserAdres());
        userDto.setUserPhone(savedUser.getUserPhone());

        return userDto;
    }

    //later aanpassen
    public void updateUser(Long userNumber, UserDto newUser) {
        if (!userRepository.existsById(userNumber)) throw new RecordNotFoundException();
        User user = userRepository.findById(userNumber).get();
        userRepository.save(user);
    }

    public void deleteUser(Long userNumber) {
        userRepository.deleteById(userNumber);
    }

}

package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.CreateUserDto;
import nl.novi.project_loahy_backend.Dto.UserDto;
import nl.novi.project_loahy_backend.exeptions.RecordNotFoundException;
import nl.novi.project_loahy_backend.model.User;
import nl.novi.project_loahy_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long userNumber) {

        Optional<User> user = userRepository.findById(userNumber);

        if(user.isPresent()) {

            return user.get();

        } else {

            throw new RecordNotFoundException("Student does not exist");

        }

    }

    public UserDto createUser(CreateUserDto createUserDto) {

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

    public User updateUser(Long userNumber, User user) {

        Optional<User> optionalUser = userRepository.findById(userNumber);

        if (optionalUser.isPresent()) {

            User old = optionalUser.get();
            if(user.getUserNumber() != null){
                old.setUserNumber(userNumber);
            }
            if(user.getUserName() != null){
                old.setUserName(user.getUserName());
            }
            if(user.getUserEmail() != null){
                old.setUserEmail(user.getUserEmail());
            }
            if(user.getUserAdres() != null){
                old.setUserAdres(user.getUserAdres());
            }
            if(user.getUserPhone() != null){
                old.setUserPhone(user.getUserPhone());
            }

            return userRepository.save(old);

        } else {

            throw new RecordNotFoundException("User does not exist");
        }
    }

    public void deleteUser(Long userNumber) {

        userRepository.deleteById(userNumber);

    }

}

package nl.novi.project_loahy_backend.service;

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

    public User getUser(Long userId) {

        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()) {

            return user.get();

        } else {

            throw new RecordNotFoundException("Student does not exist");

        }

    }

    public User saveUser(User user) {

        return userRepository.save(user);

    }

    public User updateUser(Long userId, User user) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {

            User old = optionalUser.get();
            if(user.getUserId() != null){
                old.setUserId(userId);
            }
            if(user.getUserFirstName() != null){
                old.setUserFirstName(user.getUserFirstName());
            }
            if(user.getUserLastName() != null){
                old.setUserLastName(user.getUserLastName());
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

    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);

    }

}

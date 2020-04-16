package exarb.fmusers.service;

import exarb.fmusers.model.User;
import exarb.fmusers.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createNewUser(User user){
        return userRepository.save(user);
    }

}

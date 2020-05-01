package exarb.fmusers.service;

import exarb.fmusers.exception.RegistrationException;
import exarb.fmusers.model.LoginWeb;
import exarb.fmusers.model.User;
import exarb.fmusers.model.UserWeb;
import exarb.fmusers.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves a new user  if the username and the email does not already exist in the database.
     * @param userWeb
     * @return User
     */
    public User createNewUser(UserWeb userWeb){
        User user = convertToUser(userWeb);
        if (userRepository.existsByEmail(user.getEmail())){
            LOG.debug("Email {} is already registered", userWeb.getEmail());
            throw new RegistrationException("Email is already registered");
        }
        else if (userRepository.existsByUserName(user.getUserName())){
            LOG.debug("Username {} is already registered", userWeb.getUserName());
            throw new RegistrationException("Username is already registered");
        }
        else {
            User savedUser = userRepository.save(user);
            LOG.debug("Saved user to database with id: {}", savedUser.getId());
            return savedUser;
        }
    }

    /**
     * Method checks if the userName and the password matches.
     * If they do, the user is logged in, and a UserLoggedInEvent message is sent.
     * @param loginWeb
     * @return
     */
    public User logInUser(LoginWeb loginWeb){
        Optional<User> user = userRepository.findByUserName(loginWeb.getUserName());
        if (user.isPresent()){
            if (loginWeb.getPassword().equals(user.get().getPassword())) {
                // eventDispatcher.send(new TimerCountWorkEvent(user.get().getId(), user.get().getUserName()));
                return user.get();
            }

            else {
                LOG.debug("Wrong password for {}", loginWeb.getUserName());
                // throw new RegistrationException("Wrong password");
                return null;
            }
        }
        else {
            LOG.debug("User {} does not exist", loginWeb.getUserName());
            // throw new RegistrationException("User do not exist");
            return null;
        }
    }

    /**
     * Converts a UserWeb object to a User object.
     * @param web, object of UserWeb class.
     * @return User
     */
    private User convertToUser(UserWeb web){
        return new User(web.getFirstName(), web.getLastName(),
                web.getUserName(), web.getEmail(), web.getPassword());
    }
}

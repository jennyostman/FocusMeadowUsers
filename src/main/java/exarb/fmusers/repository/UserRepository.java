package exarb.fmusers.repository;

import exarb.fmusers.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUserName(String userName);

}

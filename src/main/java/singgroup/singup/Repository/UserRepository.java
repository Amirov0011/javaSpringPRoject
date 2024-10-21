package singgroup.singup.Repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import singgroup.singup.Dto.LoginDto;
import singgroup.singup.Entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByEmail(String username);
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);

}

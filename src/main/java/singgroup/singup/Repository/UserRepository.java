package singgroup.singup.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import singgroup.singup.Entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByEmail(String username);
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);

}

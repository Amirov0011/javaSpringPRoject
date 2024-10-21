package singgroup.singup.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import singgroup.singup.Config.ModelMapperConfig;
import singgroup.singup.Dto.LoginDto;
import singgroup.singup.Dto.ResetPasswordDto;
import singgroup.singup.Dto.UserRegisterDto;
import singgroup.singup.Entity.UserEntity;
import singgroup.singup.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl {
        private final UserRepository userRepository;
        private final ModelMapperConfig modelMapperConfig;

    public void register(UserRegisterDto userRegisterDto) {
        UserEntity user =modelMapperConfig.map(userRegisterDto,UserEntity.class);
        if (!user.getPassword().equals(user.getResetPassword())) {
            throw new RuntimeException("Reset password correctly");
        }
        if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        userRepository.save(user);
    }


    public  boolean login(LoginDto loginDto) {
        UserEntity user =userRepository.findByUsername(loginDto.getUsername());
        if (user == null) {
            throw new RuntimeException("User not found" + loginDto.getUsername());

        }
        return user.getPassword().equals(loginDto.getPassword());
    }



    public void resetPassword(ResetPasswordDto resetPasswordDto, String email) {
        UserEntity user = userRepository.findByEmail(resetPasswordDto.getEmail());

        if (!user.getEmail().equals(email)) {
            throw new RuntimeException("Invalid email");
        }
        user.setPassword(resetPasswordDto.getNewPassword());

        userRepository.save(user);



    }








   /* public UserRegisterDto createUser(UserRegisterDto user) {
            UserEntity userEntity = convertUserFS(user);
            userEntity = userRepository.save(userEntity);
            return user;

        }

        private UserEntity convertUserFS (UserRegisterDto userRegisterDto) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userRegisterDto.getUsername());
            userEntity.setPassword(userRegisterDto.getPassword());
            userEntity.setEmail(userRegisterDto.getEmail());
            userEntity.setId(userEntity.getId());
            userEntity.setOrganizationName(userRegisterDto.getOrganizationName());
            userEntity.setAddress(userRegisterDto.getAddress());
            userEntity.setPhoneNumber(userRegisterDto.getPhoneNumber());
            return userEntity;
        }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
    public Optional<UserEntity> findById(long id) {
        return userRepository.findById(id);
    }

    public ResponseEntity<UserEntity> update(long id, UserEntity user) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());


        userRepository.save(existingUser);
        return ResponseEntity.ok(existingUser);
    }

  */
}





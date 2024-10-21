package singgroup.singup.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import singgroup.singup.Config.ModelMapperConfig;
import singgroup.singup.Dto.LoginDto;
import singgroup.singup.Dto.ResetPasswordDto;
import singgroup.singup.Dto.UserRegisterDto;
import singgroup.singup.Entity.UserEntity;
import singgroup.singup.Repository.UserRepository;



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








}





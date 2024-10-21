package singgroup.singup.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import singgroup.singup.Dto.LoginDto;
import singgroup.singup.Dto.ResetPasswordDto;
import singgroup.singup.Dto.UserRegisterDto;

import singgroup.singup.service.UserServiceImpl;







@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;


    @PostMapping("/register")
    public ResponseEntity<UserRegisterDto> register(@RequestBody UserRegisterDto userRegisterDto) {
        userServiceImpl.register(userRegisterDto);

        return new ResponseEntity<>(userRegisterDto, HttpStatus.CREATED);
    }
    @PostMapping("login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto ) {
        if (userServiceImpl.login(loginDto)){
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
            
        }
        return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDto resetPasswordDto,String email) {
        userServiceImpl.resetPassword(resetPasswordDto,email);
        return new ResponseEntity<>("Reset Password Successful", HttpStatus.OK);
    }




















}

package singgroup.singup.Dto;

import lombok.Data;

import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRegisterDto {

    private String username;

    private String password;

    private String resetPassword;

    private String email;




}

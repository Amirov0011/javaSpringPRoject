package singgroup.singup.Dto;

import lombok.Data;

@Data
public class ResetPasswordDto {
    private String email;
    private String oldPassword;
    private String newPassword;

}

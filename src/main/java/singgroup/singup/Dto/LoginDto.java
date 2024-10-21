package singgroup.singup.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class LoginDto {

   private String username;

    private String password;
}

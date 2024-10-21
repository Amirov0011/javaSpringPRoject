package singgroup.singup.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import singgroup.singup.Dto.UserRegisterDto;
import singgroup.singup.Entity.UserEntity;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapperConfig getMapper(){
        return new ModelMapperConfig();
    }

/*
   public UserEntity map(UserRegisterDto userRegisterDto, Class<UserEntity> userEntityClass) {
     return null;
    }*/
}

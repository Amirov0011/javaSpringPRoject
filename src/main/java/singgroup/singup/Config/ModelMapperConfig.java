package singgroup.singup.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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

package cn.com.taiji.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoConfig {
    @Bean
    public UserDao userDao(){
        return new UserDao();
    }
}

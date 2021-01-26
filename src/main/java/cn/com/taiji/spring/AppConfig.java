package cn.com.taiji.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("cn.com.taiji.spring")//扫描包
//@Import({UserDaoConfig.class,UserServiceConfig.class,SchedueTask.class})
public class AppConfig {
    @Bean
    public UserService userService(){
        UserService userService=new UserService();
//        userService.setUserDao(userDao);
        return userService;
    }
//
//    @Bean
//    public UserDao userDao(){
//        return new UserDao();
//    }
}

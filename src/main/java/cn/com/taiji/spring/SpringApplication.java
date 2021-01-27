package cn.com.taiji.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

public class SpringApplication {
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("services.xml");
//        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));
//        UserService userService=context.getBean(UserService.class);
//        userService.save();
//        for(String beanName:context.getBeanDefinitionNames()){
//            System.out.println(beanName);
//        }

//        ApplicationContext context=new AnnotationConfigApplicationContext("cn.com.taiji.spring.AppConfig");
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));


//        System.out.println(SingleTonUser.getInstance());
//        System.out.println(SingleTonUser.getInstance());

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
//        context.addApplicationListener((new ApplicationStartedListener()));
        context.refresh();
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));
//        UserService userService=context.getBean(UserService.class);
//        UserService userService1=context.getBean(UserService.class);
//        userService.save();
//        System.out.println(userService);
//        System.out.println(userService1);

        UserDao userDao=context.getBean(UserDao.class);
//        System.out.println(userDao.getClass());
        //System.out.println(UserDao.class);
        //System.out.println(userDao.getClass());
       // System.out.println(UserDao.class.isAssignableFrom(userDao.getClass()));
        //System.out.println(userDao.getClass().getSuperclass());
        userDao.save();
        userDao.update();

//        UserService userService= (UserService) context.getBean("userService");
//        UserService userService=context.getBean(UserService.class);
//        System.out.println(userService.getClass());
//        userService.save();
    }

}


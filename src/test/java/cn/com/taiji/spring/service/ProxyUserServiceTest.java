package cn.com.taiji.spring.service;

import cn.com.taiji.spring.UserDao;
import cn.com.taiji.spring.UserService;
import cn.com.taiji.spring.UserServiceImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class ProxyUserServiceTest {

    @Test
    public void testProxyUserService(){
        ProxyUserService proxyUserService=new ProxyUserService(new UserServiceImpl());
        proxyUserService.save();
    }

    @Test
    public void testProxyUserServiceJdk(){
        ProxyUserServiceJdk proxyUserServiceJdk=new ProxyUserServiceJdk(new UserServiceImpl());
        UserService userService= (UserService) proxyUserServiceJdk.getProxy();
        userService.save();
        System.out.println(userService.getClass());
        System.out.println(new UserServiceImpl().getClass());
    }

    @Test
    public void testCglibProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new CglibMethodProxy());
        UserDao userDao= (UserDao) enhancer.create();
        userDao.save();
        System.out.println(userDao.getClass());
        System.out.println(new UserDao().getClass());
    }

//    AspectJ aop 部分注解和部分api  jdkdymatic cglib
}

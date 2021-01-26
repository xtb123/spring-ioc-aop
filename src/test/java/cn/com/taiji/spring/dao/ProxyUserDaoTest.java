package cn.com.taiji.spring.dao;

import cn.com.taiji.spring.UserDao;
import org.junit.Test;

public class ProxyUserDaoTest {

    @Test
    public void testProxyUserDao(){
        ProxyUserDao proxyUserDao=new ProxyUserDao(new UserDao());
        proxyUserDao.save();
    }
}

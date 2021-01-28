package cn.com.taiji.spring;

import cn.com.taiji.spring.servlet.HelloServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
    public static void run(String[] args) throws LifecycleException {


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

        Tomcat tomcat=new Tomcat();      //创建tomcat实例，用来启动tomcat
        Connector connector=new Connector();//设置协议，默认就是这个协议connector.setURIEncoding(“UTF-8”);//设置编码
//        connector.setURIEncoding("UTF-8");  //设置编码
        connector.setPort(9999);           //设置端口
        tomcat.getService().addConnector(connector);
       // tomcat.setBaseDir(".");          //tomcat存储自身信息的目录，比如日志等信息，根目录

        //设置appbase目录
        //设置webapp目录（tomcat的webapps文件夹）
//        String basePath=System.getProperty("user.dir")+ File.separator;
//        tomcat.getHost().setAppBase(basePath+".");
//        tomcat.addWebapp("","resources");

        StandardContext standardContext=new StandardContext();
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        standardContext.setPath("mvc");

        tomcat.getHost().addChild(standardContext);
        tomcat.addServlet("/mvc","helloServlet",new HelloServlet());
        standardContext.addServletMappingDecoded("/hello","helloServlet");

        tomcat.start();                    //启动tomcat
        tomcat.getServer().await();        //维持tomcat服务，否则tomcat一启动就会关闭
    }

}


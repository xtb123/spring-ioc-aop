package cn.com.taiji.spring;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootAnnotation
public class SpringWebApplication {
    public static void run(String[] args) throws LifecycleException {

//        dispatcherServlet.setApplicationContext(webApplicationContext);


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
        standardContext.setPath("/mvc");
        tomcat.getHost().addChild(standardContext);
        tomcat.start();                    //启动tomcat

        AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
//        webApplicationContext.register(MvcConfig.class);
        webApplicationContext.register(SpringWebApplication.class);
        webApplicationContext.setServletContext(standardContext.getServletContext());
        webApplicationContext.refresh();
        DispatcherServlet dispatcherServlet=new DispatcherServlet(webApplicationContext);

        tomcat.addServlet("/mvc","dispacher",dispatcherServlet);
//        standardContext.addServletMappingDecoded("/hello","dispacher");
        standardContext.addServletMappingDecoded("/","dispacher");

        tomcat.getServer().await();        //维持tomcat服务，否则tomcat一启动就会关闭
    }
}

package cn.com.taiji.spring;

import org.apache.catalina.LifecycleException;

@SpringBootAnnotation
public class BootApplication {
    public static void main(String[] args) throws LifecycleException {
        SpringWebApplication.run(args);
    }
}

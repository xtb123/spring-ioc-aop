package cn.com.taiji.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@ComponentScan("cn.com.taiji.spring")
@ComponentScan
public class MvcConfig implements WebMvcConfigurer {

//    common-file-upload,ervlet3.0
    @Bean("multipartResolver")
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }


    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/public/");
    }
}

package cn.com.taiji.spring.controller;

import cn.com.taiji.spring.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
//@RestController  //返回对象时，用json返回
@RequestMapping(value="/hello")
public class HelloController {

//    @RequestMapping("hello")
//    @ResponseBody
//    public String hello(){
//        System.out.println("hello");
//        return "hello";
//    }

    @Autowired
    ApplicationContext app;

//    @GetMapping("/index")
    @RequestMapping("/index")
    @ResponseBody
    public String index(Model model){
//        model.addAttribute("name","张三");
        System.out.println(app.getClass());
        System.out.println(app.getBean("multipartResolver"));
        CollectionUtils.arrayToList(app.getBeanDefinitionNames()).forEach(item-> System.out.println(item));
        return "hello";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        String fileName="D://vuews/"+File.separator+file.getName();
        file.transferTo(new File(fileName));
        return "success";
    }

//    @GetMapping("/user")
    @RequestMapping
    @ResponseBody
    public User user(){
        User user=new User("柳大华",12,"35");
        return user;
    }

}

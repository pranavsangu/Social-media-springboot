package com.example_web_services.restful_webservices.HelloWorld;

import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.aspectj.bridge.Message;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class HelloWorldController {
    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource){
        this.messageSource= messageSource;
    }
    @RequestMapping(method=RequestMethod.GET,path= "/hello-world")
    public String HelloWorld() {
        return "hello world";
    }
    @GetMapping(path ="/hello-world-get" )//.  better approach than request mapping
    public String HelloWorldGet(){
        return "hello world with get";
    }
    @GetMapping("/hello-world-bean" )//.  better approach than request mapping
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("helloworld Bean");
    }
    // path parameters
    // /users/{id}/todos/{id} => /users/2/todos/200
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name){
        return new HelloWorldBean("Hello from "+ name);

    }
    @GetMapping(path ="/hello-world-internationalized" )//.  I 18N demo
    public String HelloWorldInternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
        //return "hello world I18N";
    }

    


}

package com.example_web_services.restful_webservices.HelloWorld;


public class HelloWorldBean {
    private String hello;
    public HelloWorldBean(String hello){
        this.hello= hello;
    }

    public String getHello() {
        return hello;
    }

    @Override
    public String toString() {
        return "HelloWorldBean [hello=" + hello + "]";
    }
    

}

package com.example_web_services.restful_webservices.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1", "value2","value3");
    }
    @GetMapping("/filtering/List")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("value1", "value2","value3"),new SomeBean("val4","val5" ,"val6"));
    }
     @GetMapping("/filtering-view")
     @JsonView(View.View1.class)
    public SomeBean2 filteringWithview(){
        return new SomeBean2("value1", "value2","value3");
    }
    @GetMapping("/filtering-view/List")
    @JsonView(View.View2.class)
    public List<SomeBean2> filteringListwithView(){
        return Arrays.asList(new SomeBean2("value1", "value2","value3"),new SomeBean2("val4","val5" ,"val6"));
    }


}

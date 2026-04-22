package com.example_web_services.restful_webservices.Filtering;

import com.fasterxml.jackson.annotation.JsonView;

public class SomeBean2 {
    @JsonView(View.View1.class)
    private String field1;
    @JsonView(View.View2.class)
    private String field2;
    @JsonView({View.View1.class,View.View2.class})
    private String field3;

    
    public SomeBean2(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
    public String getField1() {
        return field1;
    }
    public String getField2() {
        return field2;
    }
    public String getField3() {
        return field3;
    }
    

}

// package com.example_web_services.restful_webservices.Versioning;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class VersioningPersonSbiController {
//      @GetMapping(value ="/{version}/personsbi",version= "1.0.0")//spring boot internal versioning system
//     public PersonV1 getFirstVersionPersonSbi() { // use spring.mvc.apiversion.use.path-segment=0 in application properties
//         return new PersonV1("bob");
//     }
//     @GetMapping(value ="/{version}/personsbi",version= "2.0.0")
//     public PersonV2 SecondVersionPersonSbi() {
//         return new PersonV2(new Name("bob", "bhai"));
//     }
//     @GetMapping(path = "personsbi", version  = "3.0.0")
//     public PersonV1 getFirstVersionOfPersonRequestParameterSbi() {
//         return new PersonV1("bob");
//     }
//     @GetMapping(path = "personsbi", version= "3.1.1") 
//     public PersonV2 getSecondVersionOfPersonRequestParameterSbi() {
//         return new PersonV2(new Name("bob","charles"));
//     }
//     @GetMapping(path = "personsbi/header", version= "1")
//     public PersonV1 getFirstVersionOfPersonRequestHeaderSbi() {
//         return new PersonV1("bob header");
//     }
//     @GetMapping(path = "personsbi/header", version = "2")
//     public PersonV2 getSecondVersionOfPersonRequestHeaderSbi() {
//         return new PersonV2(new Name("bob", "withheader"));
//     }
//      @GetMapping(path = "personsbi/accept", version="1")
//     public PersonV1 getFirstVersionOfPersonAcceptHeaderSbi() {
//         return new PersonV1("bob accept v1");
//     }
//      @GetMapping(path = "personsbi/accept", version = "2")
//     public PersonV2 getSecondVersionOfPersonAcceptHeaderSbi() {
//         return new PersonV2(new Name("bob", "accept v2"));
//     }


// }

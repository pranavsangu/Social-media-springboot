// package com.example_web_services.restful_webservices.Versioning;

// import org.springframework.web.bind.annotation.RestController;


// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


// @RestController
// public class VersioningPersonController {
//     @GetMapping("/v1/person")
//     public PersonV1 getFirstVersionPerson() {
//         return new PersonV1("bob");
//     }
//     @GetMapping("/v2/person")
//     public PersonV2 SecondVersionPerson() {
//         return new PersonV2(new Name("bob", "bhai"));
//     }
//     @GetMapping(path = "person", params = "version=3")
//     public PersonV1 getFirstVersionOfPersonRequestParameter() {
//         return new PersonV1("bob");
//     }
//     @GetMapping(path = "person", params = "version=2") //http://localhost:8080/person?version=2
//     public PersonV2 getSecondVersionOfPersonRequestParameter() {
//         return new PersonV2(new Name("bob","charles"));
//     }
//     @GetMapping(path = "person/header", headers = "X-API-VERSION=1")
//     public PersonV1 getFirstVersionOfPersonRequestHeader() {
//         return new PersonV1("bob header");
//     }
//     @GetMapping(path = "person/header", headers = "X-API-VERSION=2")
//     public PersonV2 getSecondVersionOfPersonRequestHeader() {
//         return new PersonV2(new Name("bob", "withheader"));
//     }
//      @GetMapping(path = "person/accept", produces = "application/vnd.company.app-v1+json")
//     public PersonV1 getFirstVersionOfPersonAcceptHeader() {
//         return new PersonV1("bob accept");
//     }
//      @GetMapping(path = "person/accept", produces = "application/vnd.company.app-v2+json")
//     public PersonV2 getSecondVersionOfPersonAcceptHeader() {
//         return new PersonV2(new Name("bob", "accept v2"));
//     }





    


// }

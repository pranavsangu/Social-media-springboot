package com.example_web_services.restful_webservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserResourceController {
    private UserDaoService service;
    public UserResourceController(UserDaoService service){
        this.service= service;
    }

    //get / users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUserId(@PathVariable int id){
        User user= service.findOne(id);
        if(user==null) throw new UserNotFoundException("id:"+id);
        EntityModel <User> entityModel = EntityModel.of(user); 
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all users"));

        return entityModel;
  
    }
    //Post users
    @PostMapping("/users")
    public ResponseEntity <User> createUser(@Valid @RequestBody User user){ // valid used to have validations
        User savedUser = service.saveUser(user);
        // location- /users/4
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                                                .path("{id}")
                                                .buildAndExpand(savedUser.getId())
                                                .toUri();//adds location
        //return ResponseEntity.created(null).build(); //sends created and shows 201 response


        return ResponseEntity.created(location).build(); //sends created and shows 201 response with location

    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUserById(id);
     
    }
    

    
}

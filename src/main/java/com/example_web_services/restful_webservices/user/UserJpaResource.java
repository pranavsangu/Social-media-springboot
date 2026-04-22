package com.example_web_services.restful_webservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example_web_services.restful_webservices.Entity.Post;
import com.example_web_services.restful_webservices.Entity.PostRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
    private UserRepository repository;
    private PostRepository postRepository;
    public UserJpaResource(UserRepository userRepository, PostRepository postRepository){
        this.repository= userRepository;
        this.postRepository= postRepository;
    }
    //get / users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUserId(@PathVariable int id){
        Optional<User> user= repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id);
        if(user==null) throw new UserNotFoundException("id:"+id);
        EntityModel <User> entityModel = EntityModel.of(user.get()); 
        // WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        // entityModel.add(link.withRel("all users"));

        return entityModel;
  
    }
    @PostMapping("/jpa/users")
    public ResponseEntity <User> createUser(@Valid @RequestBody User user){ // valid used to have validations
        User savedUser = repository.save(user);
        // location- /users/4
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                                                .path("/{id}")
                                                .buildAndExpand(savedUser.getId())
                                                .toUri();//adds location
        //return ResponseEntity.created(null).build(); //sends created and shows 201 response


        return ResponseEntity.created(location).build(); //sends created and shows 201 response with location

    }
    // @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    // public ResponseEntity<String> handleHttpMessageNotReadable(
    //         org.springframework.http.converter.HttpMessageNotReadableException ex) {
    //     return ResponseEntity.badRequest().body(ex.getMostSpecificCause().getMessage());
    // }
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
     
    }

     @GetMapping("/jpa/users/{id}/posts") //users posts
    public List<Post> retrievePostsForUser(@PathVariable int id){
        Optional<User> user= repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id);
        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts") //users posts
    public ResponseEntity<Post> createPostsForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user= repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id);
        post.setUser(user.get());
        //postRepository.save(post);
        Post savedPost = postRepository.save(post);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                                                .path("/{id}")
                                                .buildAndExpand(savedPost.getId())
                                                .toUri();
        return ResponseEntity.created(location).build();
    }

    // @PostMapping("/jpa/users")
    // public ResponseEntity <User> createUser(@Valid @RequestBody User user){ // valid used to have validations
    //     User savedUser = repository.save(user);
    //     // location- /users/4
    //     URI location= ServletUriComponentsBuilder.fromCurrentRequest()
    //                                             .path("/{id}")
    //                                             .buildAndExpand(savedUser.getId())
    //                                             .toUri();//adds location
    //     //return ResponseEntity.created(null).build(); //sends created and shows 201 response


    //     return ResponseEntity.created(location).build(); //sends created and shows 201 response with location

    // }




}

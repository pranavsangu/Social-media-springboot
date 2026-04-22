package com.example_web_services.restful_webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static int userCount=0;
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(++userCount, "Adaam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Alex", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Pete", LocalDate.now().minusYears(37)));

    }

    public List<User> findAll() {
        return users;

    }

    public User findOne(int id) {
        for(int i =0; i<users.size();i++){
            if(id== users.get(i).getId()){
                return users.get(i);
            }
        }
        return null;

        // Predicate<? super User> predicate = user -> user.getId().equals(id);
        // users.stream().filter(predicate);
    }
    public User saveUser(User user){
        user.setId(++userCount);
        users.add(user);
        return user;

    }
    public void deleteUserById(int id){
        for(int i=0;i<users.size();i++){
            if(id==users.get(i).getId()){
                users.remove(i);
            }
        }
    }

}

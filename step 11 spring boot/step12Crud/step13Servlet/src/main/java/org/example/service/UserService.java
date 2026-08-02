package org.example.service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Integer, User> userDB;

    public UserService(){
        userDB = new HashMap<>();
    }

    public User createUser(User user) {

        userDB.put(user.getId(), user);
        return user;

    }

    public List<User> getAllUsers(){
      List<User> usersRes = new ArrayList<>();
      for(User user: userDB.values()){
          usersRes.add(user);
      }
      return usersRes;
    }

    public User getUserById(Integer id){
        return userDB.getOrDefault(id, null);
    }
}

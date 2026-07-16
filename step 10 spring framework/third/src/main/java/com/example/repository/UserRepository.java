package com.example.repository;

import com.example.db.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final DatabaseConnection db;

    public UserRepository(DatabaseConnection db) {
        this.db = db;
    }

    public List<String> findAllUsers(){
        return db.getUsers();
    }

    public void save(String user){
        db.addUser(user);
    }

}

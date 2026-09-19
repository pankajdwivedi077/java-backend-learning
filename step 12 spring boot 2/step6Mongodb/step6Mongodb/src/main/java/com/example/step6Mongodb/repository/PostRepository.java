package com.example.step6Mongodb.repository;

import com.example.step6Mongodb.model.Post;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    Post findByProfile(String profile);

    @Aggregation(pipeline = {
            "{ '$match': { '$or': [ " +
                    "{ 'profile': { '$regex': ?0, '$options': 'i' } }, " +
                    "{ 'desc': { '$regex': ?0, '$options': 'i' } }, " +
                    "{ 'techs': { '$regex': ?0, '$options': 'i' } } " +
                    "] } }"
            // You can add more stages here, e.g., "{ '$sort': { 'profile': 1 } }", "{ '$limit': 10 }"
    })
    List<Post> findByText(String text);
}

package com.example.step6Mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private String profile;
    private String desc;
    private String[] techs;

    public Post() {
    }

    public Post(String profile, String desc, String[] techs) {
        this.profile = profile;
        this.desc = desc;
        this.techs = techs;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}

package com.example.step33OAuth.service;

import com.example.step33OAuth.entity.User2;
import com.example.step33OAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User2 registerOrUpdate(String provider, OidcUser oidcUser){

        String providerSubject = oidcUser.getSubject();

        String name = oidcUser.getClaimAsString("name");
        String email = oidcUser.getClaimAsString("email");

        Optional<User2> existingUser =
                userRepository.findByProviderAndProviderSubject(
                        provider, providerSubject);

        if(existingUser.isPresent()){
            User2 user = existingUser.get();
            user.setName(name);
            user.setEmail(email);

            return user;

            // Explicitly save the updated details to the database
//            return userRepository.save(user);
        }

        User2 newUser = new User2(name,email,provider,providerSubject);

        return userRepository.save(newUser);

    }

}

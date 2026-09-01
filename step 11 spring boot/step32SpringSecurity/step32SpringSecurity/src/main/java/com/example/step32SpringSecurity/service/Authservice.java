package com.example.step32SpringSecurity.service;

import com.example.step32SpringSecurity.dto.UserRegisterRequestDto;
import com.example.step32SpringSecurity.dto.UserRegisterResponseDto;
import com.example.step32SpringSecurity.entity.Role;
import com.example.step32SpringSecurity.entity.User;
import com.example.step32SpringSecurity.repository.RoleRepository;
import com.example.step32SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Authservice {

    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private RoleRepository roleRepository;

//    @Autowired
//    public Authservice(UserRepository userRepository, PasswordEncoder passwordEncoder,
//                       RoleRepository roleRepository){
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.roleRepository = roleRepository;
//    }

    @Autowired
    public Authservice(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserRegisterResponseDto registerUser(UserRegisterRequestDto register) {

        User user = new User();

        user.setUsername(register.getUsername());

        String encodedPassword = passwordEncoder.encode(register.getPassword());
        user.setPassword(encodedPassword);

        user.setEnabled(true);

        Role role = roleRepository.findByName("User").get();

        user.getRoles().add(role);
        userRepository.save(user);

        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("user registered successfully");
        return responseDto;
    }
}

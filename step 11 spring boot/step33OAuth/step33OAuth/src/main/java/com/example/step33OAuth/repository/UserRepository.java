package com.example.step33OAuth.repository;

import com.example.step33OAuth.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User2, Long> {

    Optional<User2> findByProviderAndProviderSubject(String provider,
                                                     String providerSubject);

}

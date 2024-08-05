package com.sut.ood.onlinefoodbackend.Model.User.Repository;

import com.sut.ood.onlinefoodbackend.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByUsernameAndPasswordAndEmail(String username, String password, String email);
}

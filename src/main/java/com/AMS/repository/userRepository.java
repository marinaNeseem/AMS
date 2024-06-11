package com.AMS.repository;
import com.AMS.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface userRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmailAndPassword(String email, String password);

    Users findByEmail(String Email);

}
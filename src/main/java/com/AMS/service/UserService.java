package com.AMS.service;
import com.AMS.Dto.*;
import com.AMS.model.Users;
import com.AMS.repository.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@Getter
@Setter

public class UserService {
    @Autowired
    private userRepository userRepository;
    public String Register(UserDto userDto) {
        Users user = new Users(
                userDto.getUser_name(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getType()
        );
        userRepository.save(user);
        return "Register Successfully!";
    }
    public String loginUser(LoginDto loginDto) {
        Users user = findUserByEmail(loginDto.getEmail());
        if (user == null) {
            return "Email doesn't exist!";
        }

        if (!passwordMatches(loginDto.getPassword(), user.getPassword())) {
            return "Password doesn't match!";
        }

        Optional<Users> authenticatedUser = authenticateUser(loginDto.getEmail(), user.getPassword());
        if (authenticatedUser.isPresent()) {
            return "Logged in!";
        } else {
            return "Login failed!";
        }
    }
    private Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private boolean passwordMatches(String loginDtoPassword, String userPassword) {
        return loginDtoPassword.equals(userPassword);
    }

    private Optional<Users> authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}

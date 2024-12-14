package ro.devmind.springsecurityauthorization.service;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.devmind.springsecurityauthorization.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final List<User> userList = new ArrayList<>();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public void addUser(User user) {
        userList.add(user);
    }

    public String authenticate(String username, String password) {
        User user = userList.stream()
                .filter(u -> u.getUsername().equals(username))
                .filter(u -> passwordEncoder.matches(password, u.getPassword()))
                .findFirst().orElse(null);

        if (null != user) {
            return jwtService.createToken(username);
        }

        throw new UsernameNotFoundException("Invalid username or password");
    }

    public User validateUser(String token) {
        String username = jwtService.validateToken(token);

        return userList.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @RolesAllowed("ADMIN")
    public void checkMyCredentials() {
        System.out.println("Congrats, you were able to execute this method");
    }
}

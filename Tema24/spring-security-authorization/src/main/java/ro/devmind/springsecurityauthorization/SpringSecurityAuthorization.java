package ro.devmind.springsecurityauthorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.devmind.springsecurityauthorization.models.User;
import ro.devmind.springsecurityauthorization.service.UserService;

import java.util.List;

@SpringBootApplication
public class SpringSecurityAuthorization implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAuthorization.class, args);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        userService.addUser(new User("admin", passwordEncoder.encode("admin"), List.of("ROLE_ADMIN")));
        userService.addUser(new User("user", passwordEncoder.encode("password"), List.of("ROLE_USER")));
        userService.addUser(new User("Fometescu", passwordEncoder.encode("fometescu"), List.of("ROLE_STAFF")));
        userService.addUser(new User("Mirel", passwordEncoder.encode("mirel"), List.of("ROLE_USER")));
    }
}

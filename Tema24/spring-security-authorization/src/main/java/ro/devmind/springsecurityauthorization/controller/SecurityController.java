package ro.devmind.springsecurityauthorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.devmind.springsecurityauthorization.dto.UserLoginDTO;
import ro.devmind.springsecurityauthorization.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping
public class SecurityController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserLoginDTO dto) {
        return userService.authenticate(dto.getUsername(), dto.getPassword());
    }

    @GetMapping("/whoami")
    public String protectedWhoami() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "You are: " + authentication.getName() + " with authorities " + authentication.getAuthorities().toString();
    }

    @GetMapping("/admin-only")
    public String adminOnly() {
        return "Congrats, you're an admin";
    }

    @GetMapping("/user-only")
    public String userOnly() {
        return "Congrats, you're an user";
    }

    @GetMapping("/method-security")
    public String methodSecurity() {
        userService.checkMyCredentials();

        return "Congrats, you managed to access this endpoint";
    }
}

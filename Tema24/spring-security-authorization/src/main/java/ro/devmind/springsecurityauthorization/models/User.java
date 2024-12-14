package ro.devmind.springsecurityauthorization.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private List<String> roles;
}

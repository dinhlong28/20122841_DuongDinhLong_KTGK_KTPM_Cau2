package iuh.loginservice.controllers;

import iuh.loginservice.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class LoginController {
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable long id){
        User user = restTemplate.getForObject("http://localhost:8083/api/v1/users/"+id, User.class);
        return user;
    }
}

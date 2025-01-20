package com.tekarch.TafUserService.Service;

import com.tekarch.TafUserService.Model.User;
import com.tekarch.TafUserService.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${datastore.service.url}")
    private String DATASOURCE_SERVICE_URL;

    public User registerUser(User user) {
        ResponseEntity<User> response = restTemplate.exchange(
                DATASOURCE_SERVICE_URL + "/users", HttpMethod.POST, new HttpEntity<>(user), User.class);
        return response.getBody();
    }

    public User getUserById(Long userId) {
        ResponseEntity<User> response = restTemplate.exchange(
                DATASOURCE_SERVICE_URL + "/users" + "/" + userId,
                HttpMethod.GET,
                null,
                User.class
        );
        return response.getBody();
    }

    public User updateUser(Long userId, User user) {
        ResponseEntity<User> response = restTemplate.exchange(
                DATASOURCE_SERVICE_URL + "/users" + "/" + userId,
                HttpMethod.PUT,
                new HttpEntity<>(user),
                User.class
        );
        return response.getBody();
    }

    public void deleteUser(Long userId) {
        restTemplate.exchange(
                DATASOURCE_SERVICE_URL + "/users" + "/" + userId,
                HttpMethod.DELETE,
                null,
                Void.class
        );
    }

}

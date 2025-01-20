package com.tekarch.TafUserService.Service.Interface;


import com.tekarch.TafUserService.Model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUserById(Long userId);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);

}

package com.amz.scm.services;

import java.util.List;

import com.amz.scm.entities.User;
import com.amz.scm.payloads.UserDto;

public interface UserService {

    UserDto saveUser(User user);
    UserDto updateUser(User user,String id);
    List<UserDto> getAllUsers();
    UserDto getUserById(String id);
    void deleteUser(String id);

    boolean isUserExists(String id);
    UserDto getUserByEmail(String email);





}

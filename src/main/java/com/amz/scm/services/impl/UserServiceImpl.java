package com.amz.scm.services.impl;

import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amz.scm.entities.User;
import com.amz.scm.exceptions.ApiError;
import com.amz.scm.exceptions.ResourceNotFoundException;
import com.amz.scm.payloads.UserDto;
import com.amz.scm.repositories.UserRepo;
import com.amz.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto saveUser(User user) {
        try {
            User savedUser = this.userRepo.save(user);
            UserDto savedUserDto = this.modelMapper.map(savedUser, UserDto.class);

            return savedUserDto;
        } catch (Exception e) {
            logger.error("Error saving User to Db: ", e);
            throw new ApiError("UserServiceImpl: Error saving user to Db.");
        }
    }


    @Override
    public UserDto updateUser(User user, String id) {
        User oldUser = this.userRepo
        .findById(id)
        .orElseThrow(()->new ResourceNotFoundException("User","user id","Not found"));

        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAbout(user.getAbout());
        oldUser.setProfilePic(user.getProfilePic());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setEnabled(user.isEnabled());
        oldUser.setEmailVerified(user.isEmailVerified());
        oldUser.setPhoneNumberVerified(user.isPhoneNumberVerified());
        oldUser.setProvider(user.getProvider());
        oldUser.setProviderId(user.getProviderId());
        oldUser.setContacts(user.getContacts());

        User updatedUser = this.userRepo.save(oldUser);
        UserDto updatedUserDto = this.modelMapper.map(updatedUser, UserDto.class);


        return updatedUserDto;
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = this.userRepo.findAll();
        List<UserDto> UserDtos = allUsers.stream()
            .map((user)-> this.modelMapper.map(user, UserDto.class)).toList();
        return UserDtos;
    }

    @Override
    public UserDto getUserById(String id) {
        User user = this.userRepo
            .findById(id)
            .orElseThrow(()->new ResourceNotFoundException("User","user id","Not found"));
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public void deleteUser(String id) {
        this.userRepo.deleteById(id);
    }

    @Override
    public boolean isUserExists(String id) {
        return this.userRepo.existsById(id);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = this.userRepo
            .findByEmail(email)
            .orElseThrow(()->new ResourceNotFoundException("User","user email","Not found"));
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

}

package com.sujit.blog.service.impl;

import com.sujit.blog.entities.User;
import com.sujit.blog.exceptions.ResourceNotFoundException;
import com.sujit.blog.payloads.UserDTO;
import com.sujit.blog.repositories.UserRepo;
import com.sujit.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDto){

        User user = dtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, Integer userId){

        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " id ", userId ));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = userRepo.save(user);

        return userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId){

        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " id ", userId));
        return userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepo.findAll();
        return userList.stream()
                .map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId){
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " id ", userId));
        userRepo.delete(user);
    }

    // UserDTO to User
    public User dtoToUser(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

    // User to UserDTO
    public UserDTO userToDto(User user){
        return modelMapper.map(user, UserDTO.class);
    }
}

package com.example.hms.service;

import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.User;
import com.example.hms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public UserResponse registerUser(UserRequest userRequest)
    {
        User user = new User();
        user.setFullName(userRequest.getFullName() == null?"":userRequest.getFullName());
        user.setEmail(userRequest.getEmail() == null?"":userRequest.getEmail());
        user.setPassword(userRequest.getPassword() == null?"":userRequest.getPassword());
        user.setAddress(userRequest.getAddress());
        user.setCity(userRequest.getCity());
        user.setGender(userRequest.getGender());
        user.setRegDate(LocalDateTime.now());
        User res = userRepository.save(user);
        return mapToResponse(res);
    }
    public UserResponse loginUser(User user)
    {
        User checkUser = userRepository.findByEmail(user.getEmail());
        if(checkUser == null)
        {
            throw new RuntimeException("User Not Found");
        }
        return mapToResponse(checkUser);
    }

    private UserResponse mapToResponse(User user)
    {
        UserResponse userResponse = new UserResponse();
        userResponse.setFullName(user.getFullName());
        userResponse.setEmail(user.getEmail());
        userResponse.setAddress(user.getAddress());
        userResponse.setCity(user.getCity());
        userResponse.setGender(user.getGender());
        userResponse.setRegDate(user.getRegDate());
        userResponse.setUpdationDate(user.getUpdationDate());
        return userResponse;
    }

    public List<UserResponse> getAllUsers(){
        List<User> u=userRepository.findAll();
        List<UserResponse> urobj=u.stream().map(this::mapToResponse).toList();
        return urobj;
    }

    public UserResponse updateUser(Long id,UserRequest userRequest){
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user.setFullName(userRequest.getFullName());
        user.setAddress(userRequest.getAddress());
        user.setCity(userRequest.getCity());
        user.setGender(userRequest.getGender());
        user.setEmail(userRequest.getEmail());
        user.setUpdationDate(LocalDateTime.now());
        UserResponse userResponse=mapToResponse(user);
        return userResponse;
    }
    public UserResponse getUserById(Long id){
        User u=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        UserResponse userResponse=mapToResponse(u);
        return userResponse;
    }
}

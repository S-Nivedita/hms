package com.example.hms.service;

import com.example.hms.dto.ContactQueryRequest;
import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.ContactQuery;
import com.example.hms.model.User;
import com.example.hms.repository.ContactQueryRepository;
import com.example.hms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactQueryRepository contactQueryRepository;

    public UserServiceImpl(UserRepository userRepository, ContactQueryRepository contactQueryRepository)
    {
        this.userRepository = userRepository;
        this.contactQueryRepository = contactQueryRepository;
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

    public String saveContactQueries(ContactQueryRequest contactQueryRequest)
    {
        ContactQuery contactQuery = new ContactQuery();
        contactQuery.setFullName(contactQueryRequest.getFullName());
        contactQuery.setEmail(contactQueryRequest.getEmail());
        contactQuery.setContactNo(contactQueryRequest.getContactNo());
        contactQuery.setMessage(contactQueryRequest.getMessage());
        contactQuery.setPostingDate(LocalDateTime.now());
        contactQuery.setRead(false);
        ContactQuery query = contactQueryRepository.save(contactQuery);
        return "Your information is successfully submitted";
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
}

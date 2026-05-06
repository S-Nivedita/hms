package com.example.hms.service;

import com.example.hms.dto.ChangePasswordRequest;
import com.example.hms.dto.ContactQueryRequest;
import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.Admin;
import com.example.hms.model.ContactQuery;
import com.example.hms.model.User;
import com.example.hms.repository.ContactQueryRepository;
import com.example.hms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public List<UserResponse> getAllUsers()
    {
        List<User> u=userRepository.findAll();
        List<UserResponse> urobj=u.stream().map(this::mapToResponse).toList();
        return urobj;
    }

    public UserResponse updateUser(Long id,UserRequest userRequest)
    {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user.setFullName(userRequest.getFullName());
        user.setAddress(userRequest.getAddress());
        user.setCity(userRequest.getCity());
        user.setGender(userRequest.getGender());
        user.setEmail(userRequest.getEmail() != null?userRequest.getEmail():user.getEmail());
        user.setUpdationDate(LocalDateTime.now());
        UserResponse userResponse=mapToResponse(user);
        return userResponse;
    }

    public String deleteUser(Long id)
    {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
        {
            userRepository.deleteById(id);
            return "User with ID:"+id+" has been deleted sucessfully";
        }
        throw new RuntimeException("User with ID:"+id+" not found");
    }

    public UserResponse getUserById(Long id)
    {
        User u=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        UserResponse userResponse=mapToResponse(u);
        return userResponse;
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

    @Override
    public void changePassword(Long userId, ChangePasswordRequest request)
    {
        User user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Admin Not Found"));
        if(!user.getPassword().equals(request.getCurrentPassword()))
        {
            throw new RuntimeException("Incorrect Password");
        }
        if(!request.getNewPassword().equals(request.getConfirmPassword()))
        {
            throw new RuntimeException("Password mismatch");
        }
        user.setPassword(request.getConfirmPassword());
        user.setUpdationDate(LocalDateTime.now());
        userRepository.save(user);
    }

    private UserResponse mapToResponse(User user)
    {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getId());
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

package org.example.service;

import org.example.documents.Users;
import org.example.repository.UserRepository;

public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void addUser(Users user)
    {
        //We check if username doesn't exist
        userRepository.addUser(user);
    }
}

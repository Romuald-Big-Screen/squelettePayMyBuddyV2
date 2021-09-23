package com.PayMyBudy.service;

import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;

@Service
public class ConnectionService {
    private final UserRepository userRepository;
    private final ConnectionRepository connectionRepository;

    public ConnectionService(UserRepository userRepository, ConnectionRepository connectionRepository) {
        this.userRepository = userRepository;
        this.connectionRepository = connectionRepository;
    }

    public List <String> findConnectionsEmail(){
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) Security
        User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email not found"));
        return connectionRepository.findConnectionsByUser1Email(connectedUser.getEmail()).stream().map(connection::getUser2).map(User::getEmail);
    }
}

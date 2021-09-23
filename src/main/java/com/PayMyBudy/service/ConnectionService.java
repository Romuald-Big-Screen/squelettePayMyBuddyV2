package com.PayMyBudy.service;

import com.PayMyBudy.model.Connection;
import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.AddConnectionForm;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public void addConnection(final AddConnectionForm form) {

        User user = userRepository
                .findUserByMail(form.getEmail())
                .orElseThrow(()->new RuntimeException("user with email "+form.getEmail()+" not found"));
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email  not found"));
        Connection connection = new Connection();
        connection.setUser1(connectedUser);
        connection.setUser2(user);
        connectionRepository.save(connection);

    }
}

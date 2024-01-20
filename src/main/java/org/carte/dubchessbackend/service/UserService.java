package org.carte.dubchessbackend.service;

import org.carte.dubchessbackend.model.User;
import org.carte.dubchessbackend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return this.repo.findAll();
    }

    public void deleteUser(User user) {
        if (!repo.existsById(user.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "couldn't find user");
        }
        this.repo.delete(user);

    }
}

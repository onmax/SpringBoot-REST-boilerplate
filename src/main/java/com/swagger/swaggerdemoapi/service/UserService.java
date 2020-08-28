package com.swagger.swaggerdemoapi.service;

import com.swagger.swaggerdemoapi.entities.User;
import com.swagger.swaggerdemoapi.exceptions.UserNotFoundException;
import com.swagger.swaggerdemoapi.model.UserBean;
import com.swagger.swaggerdemoapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User postUser(UserBean userBean) {
        return repository.save(new User().fromBean(userBean));
    }

    public User getUser(Integer userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User editUser(UserBean newUserBean, Integer userId) {
        return repository.findById(userId)
                .map(user -> {
                    user.setName(newUserBean.getName());
                    user.setEmail(newUserBean.getEmail());
                    user.setAge(newUserBean.getAge());
                    return repository.save(user);
                }).get();
    }

    public void deleteUser(Integer userId) {
        repository.deleteById(userId);
    }
}
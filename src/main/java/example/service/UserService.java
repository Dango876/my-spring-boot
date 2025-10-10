package example.service;

import example.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);
}

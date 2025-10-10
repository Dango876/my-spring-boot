package example.service;

import example.entity.User;
import example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userJpaRepository;

    @Autowired
    public UserServiceImpl(UserRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userJpaRepository.findAll();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userJpaRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userJpaRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("User not found whit id: " + id);
        }
    }
}

package hu.elte.alkfejl.issuetracker.service;

import hu.elte.alkfejl.issuetracker.model.User;
import hu.elte.alkfejl.issuetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hu.elte.alkfejl.issuetracker.model.User.Role.USER;

/**
 * @author
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        user.setRole(USER);
        userRepository.save(user);
    }

    public boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }
}
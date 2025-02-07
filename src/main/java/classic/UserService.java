package classic;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private MD5 hasher;

    public UserService(UserRepository userRepository, MD5 hasher) {
        this.userRepository = userRepository;
        this.hasher = hasher;
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public void updateUser(String username, String password) {
        User user = userRepository.getByUsername(username);
        String hash = hasher.hash(password);
        user.setPassword(hash);
        userRepository.updateUser(user);
    }

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

}

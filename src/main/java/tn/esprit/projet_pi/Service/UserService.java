package tn.esprit.projet_pi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.projet_pi.Log.JwtService;
import tn.esprit.projet_pi.Repository.UserRepo;
import tn.esprit.projet_pi.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterface{
    @Autowired
    UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(String email, String password) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            User u = user.get();
            if (passwordEncoder.matches(password,u.getMdp()))
                return JwtService.generateToken(u);
        }

        return null;

    }

    @Override
    public User register(User user) {
        user.setMdp(passwordEncoder.encode(user.getMdp()));
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public List<User> getUserByName(String username) {
        return List.of();
    }

    @Override
    public List<User> getUserByRole(String role) {
        return List.of();
    }
}

package tn.esprit.projet_pi.Service;

import tn.esprit.projet_pi.entity.User;

import java.util.List;

public interface UserInterface {
    public String login(String email, String password);
    public User register(User user);

    public List<User> getAllUsers();
    public User getUserById(int id);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public boolean updateUser(User user);
    public boolean deleteUser(int id);
    public boolean addUser(User user);
    public List<User> getUserByName(String username);
    public List<User> getUserByRole(String role);
}

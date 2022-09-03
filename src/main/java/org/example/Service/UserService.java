package org.example.Service;

import org.example.DAO.UserDAO;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> index() {
        return userDAO.index();
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(int id, User modifiedUser) {
        userDAO.update(id, modifiedUser);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }
}

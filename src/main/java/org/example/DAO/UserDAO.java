package org.example.DAO;

import org.example.models.User;
import java.util.List;

public interface UserDAO {

    List<User> index();

    User getUserById(int id);

    void save(User user);

    void update(int id, User modifiedUser);

    void delete(int id);
}

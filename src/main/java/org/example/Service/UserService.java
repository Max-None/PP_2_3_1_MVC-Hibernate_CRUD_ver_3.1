package org.example.Service;

import org.example.models.User;
import java.util.List;

public interface UserService {
    List<User> index();

    User getUserById(int id);

    void save(User user);

    void update(int id, User modifiedUser);

    void delete(int id);
}

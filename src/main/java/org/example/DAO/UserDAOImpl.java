package org.example.DAO;

import org.example.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return (List<User>) entityManager.createQuery("SELECT user FROM User user").getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(int id, User modifiedUser) {
        User user = entityManager.find(User.class, id);
        user.setName(modifiedUser.getName());
        user.setSurname(modifiedUser.getSurname());
        user.setAge(modifiedUser.getAge());
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
}
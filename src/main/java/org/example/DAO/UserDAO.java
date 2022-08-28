package org.example.DAO;

import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
public class UserDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from User p", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    public void update(int id, User modifiedUser) {
        Session session = sessionFactory.getCurrentSession();
        User userForUpdate = session.get(User.class, id);
        userForUpdate.setName(modifiedUser.getName());
        userForUpdate.setSurname(modifiedUser.getSurname());
        userForUpdate.setAge(modifiedUser.getAge());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }
}
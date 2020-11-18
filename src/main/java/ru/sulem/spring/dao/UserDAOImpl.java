package ru.sulem.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sulem.spring.models.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("select u from ru.sulem.spring.models.User u").list();
    }

    @Override
    public void addUser(User user) {
            Session session=sessionFactory.getCurrentSession();
            session.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);

    }

    @Override
    public void editUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

//    @Override
//    public int userCount() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("select count(*) from users", Number.class).getSingleResult().intValue();
//    }
}

package Application.DAOs.impl;

import Application.DAOs.UserDAOCustom;
import Application.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAOCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean checkLogin(User user) {
        Query query = entityManager.createNativeQuery("SELECT * FROM linksports.user " +
                "WHERE username LIKE :username and password LIKE :password", User.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        return query.getSingleResult() != null;
    }

    //Ejemplo
    @Override
    public List getFirstNamesLike(String firstName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM linksports.user as user" +
                "WHERE user.nombre LIKE ?", User.class);
        query.setParameter(1, firstName + "%");
        return query.getResultList();
    }

    @Override
    public Iterable<User> getUsersByLastName(String lastName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM linksports.user as user" +
                "WHERE user.apellido LIKE ?", User.class);
        query.setParameter(1, lastName + "%");
        return query.getResultList();
    }

    @Override
    public Iterable<User> getUsersByDeportesLike(String sport) {
        Query query = entityManager.createNativeQuery("SELECT * FROM linksports.user as user" +
                "WHERE user.deporte LIKE ?", User.class);
        query.setParameter(1, sport + "%");
        return query.getResultList();
    }
}

package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO extends AbstractDAO {
    public List<User> list(){
        return entityManager.createQuery("select u from User u").getResultList();
    }
    public void createUser(User user){
        hibernateUtil.save(user);
    }
    public void deleteUser(Long userId){
        hibernateUtil.delete(User.class, userId);
    }
    public List<User> getUserByName(String name){
        Query query = entityManager.createQuery("select u from User u where u.name = :name", User.class);
        return query.setParameter("name", name).getResultList();
    }
    public User getUserByEMail(String email){
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.email = :email", User.class);
        return query.setParameter("email", email).getSingleResult();
    }
    public User getUserByLogin(String login){
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.login = :login", User.class);
        return query.setParameter("login", login).getSingleResult();
    }
}

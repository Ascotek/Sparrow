package dao;

import hibernate.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.text.html.parser.Entity;

public class AbstractDAO {
    final HibernateUtil hibernateUtil = HibernateUtil.getInstance();
    final EntityManager entityManager = HibernateUtil.getInstance().getEntityManager();

}

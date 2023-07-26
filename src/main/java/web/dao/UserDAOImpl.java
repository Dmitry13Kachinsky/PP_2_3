package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(showById(id));
    }

    @Override
    public void edit(int id, User user) {
        User updated = entityManager.find(User.class, id);
        updated.setId(user.getId());
        updated.setName(user.getName());
        updated.setSurname(user.getSurname());
        entityManager.merge(updated);
    }

    @Override
    public User showById(int id) {
        return entityManager.find(User.class, id);
    }
}

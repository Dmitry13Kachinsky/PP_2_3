package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAOImpl implements UserDAO {
    private static int PEOPLE_COUNT;
    private final List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++PEOPLE_COUNT, "Bob", "Boba"));
        users.add(new User(++PEOPLE_COUNT, "Tom", "Goth"));
        users.add(new User(++PEOPLE_COUNT, "John", "Over"));
        users.add(new User(++PEOPLE_COUNT, "Bill", "Nick"));
        users.add(new User(++PEOPLE_COUNT, "Sam", "Dann"));

    }

    @Override
    public List<User> users() {
        return users;
    }

    @Override
    public void add(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.set(user.getId(), user);
    }

    @Override
    public User show(int id) {
        return users.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}

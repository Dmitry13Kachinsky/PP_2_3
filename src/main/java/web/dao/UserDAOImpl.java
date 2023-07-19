package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAOImpl implements UserDAO {

    private final List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("Bob", "Boba"));
        users.add(new User("Tom", "Goth"));
        users.add(new User("John", "Over"));
        users.add(new User("Bill", "Nick"));
        users.add(new User("Sam", "Dann"));

    }
    @Override
    public List<User> users(int count) {
        if (count == 0) {
            return users;
        }
        return users.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public void add(User user) {
        users.add(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.set(user.getId(), user);
    }
}

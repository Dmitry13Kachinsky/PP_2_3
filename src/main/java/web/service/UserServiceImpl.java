package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService{
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User("Bob", "Boba"));
        users.add(new User("Bob", "Boba"));
        users.add(new User("Bob", "Boba"));
        users.add(new User("Bob", "Boba"));
        users.add(new User("Bob", "Boba"));

    }

    @Override
    public List<User> users(int count) {
        if (count == 0) {
            return users;
        }
        return users.stream().limit(count).collect(Collectors.toList());
    }
}

package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "951!Dmstk13";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> users() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setName(resultSet.getString("surname"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void add(User user) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES(14, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(int id, User updatedUser) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET name=?, surname=? WHERE id=?");
            preparedStatement.setString(1, updatedUser.getName());
            preparedStatement.setString(2, updatedUser.getSurname());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User show(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT FROM users WHERE id=?");
            preparedStatement.setInt(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();
           resultSet.next();
           user = new User();
           user.setId(resultSet.getInt("id"));
           user.setName(resultSet.getString("name"));
           user.setSurname(resultSet.getString("surname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

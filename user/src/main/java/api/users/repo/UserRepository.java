package api.users.repo;


import api.users.model.User;

import java.util.Map;

public interface UserRepository {

    User saveUser(User user);

    User updateUser(User user);

    User findUser(String id);

    Map<String, User> findAllUsers();

    void deleteUser(String id);

    void listAllUsers();
}

package user.portal.repo;


import user.portal.model.User;

import java.util.Map;

public interface UserRepository {

    void saveUser(User user);

    void updateUser(User user);

    User findUser(String id);

    Map<String, User> findAllUsers();

    void deleteUser(String id);

    void listAllUsers();
}

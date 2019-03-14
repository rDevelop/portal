package user.portal.repo;

import user.portal.model.User;

import java.util.Map;

public interface UserService {

    User create(User user);

    User delete(String id);

    Map<String, User> findAll();

    User findById(String id);

    User update(User user);
}

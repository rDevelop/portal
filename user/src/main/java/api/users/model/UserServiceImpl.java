package api.users.model;

import api.users.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        repository.saveUser(user);
        return user;
    }

    @Override
    public User delete(String id) {
        User user = findById(id);
        if(user != null){
            repository.deleteUser(user.getId());
        }
        return user;
    }

    @Override
    public Map<String, User> findAll() {
        return repository.findAllUsers();
    }

    @Override
    public User findById(String id) {
        return repository.findUser(id);
    }

    @Override
    public User update(User user) {
        repository.updateUser(user);
        return user;
    }
}

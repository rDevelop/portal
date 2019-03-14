package user.portal.repo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import user.portal.config.RedisConfig;
import user.portal.model.User;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class UserQueryTest {

    @Autowired
    private UserRepository UserRepository;


    @Test
    public void getAllUsers() {
        final Map<String, User> users = UserRepository.findAllUsers();
        for (Map.Entry<String, User> entry : users.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    @Test
    public void getSome() {
        UserRepository.listAllUsers();
    }

}

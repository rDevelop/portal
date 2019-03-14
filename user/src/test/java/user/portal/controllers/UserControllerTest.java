package user.portal.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import user.portal.config.RedisConfig;
import user.portal.model.User;
import user.portal.repo.UserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void create() {
        userService.create(new User("1", "Rob", "Litvin", "robLitvin@me.comm"));
        System.out.println(userService.findById("1"));

    }

    @Test
    public void findOne() {
        System.out.println(userService.findById("1"));

    }

    @Test
    public void update(){

        String id = "3";
        User user = new User(id,"User107", "User107", "update@user.com");
        assert(user.getFirstName().equals("User107"));
        userService.create(user);
        assert(userService.findById(id).getFirstName().equals("User107"));
        user.setFirstName("Charlie");
        userService.update(user);
        assert(userService.findById(id).getFirstName().equals("Charlie"));
        findAllUsers();

    }

    @Test
    public void delete() {
        String id = "4";
        userService.create(new User(id, "Rob", "Litvin", "robLitvin@me.comm"));
        System.out.println(userService.findById(id));
        userService.delete(id);
        System.out.println(userService.findById(id));
        findAllUsers();
    }

    @Test
    public void findAllUsers() {
        List<User> users = new ArrayList<>();
        userService.findAll().forEach((o, o2) -> users.add((User) o2));
        users.forEach(o -> System.out.println(o));
    }
}

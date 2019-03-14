package user.portal.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.portal.model.User;
import user.portal.repo.UserService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/users"})
public class UserController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user){

        LOGGER.info("{}:{} ", "User", user);

        return userService.create(user);
    }

    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public User update(@PathVariable("id") String id, @RequestBody User user){
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") String id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        userService.findAll().forEach((o, o2) -> users.add((User)o2));
        LOGGER.info("{}:{} ", "Users", users);

        return users;
    }
}

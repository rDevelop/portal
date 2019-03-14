package user.portal.controllers;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import user.portal.repo.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(MvcControllerTest.class)
public class MvcControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;


    @Test
    public void findAllUsers() throws Exception {
                mvc.perform(get("/findAll"));

    }
//        List<User> users = new ArrayList<>();
//        userService.findAll().forEach((o, o2) -> users.add((User) o2));
//        users.forEach(o -> System.out.println(o));


}

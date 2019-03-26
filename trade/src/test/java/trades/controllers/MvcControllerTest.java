package trades.controllers;


import api.config.RedisConfig;
import api.trades.model.TradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(MvcControllerTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class MvcControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TradeService tradeService;


    @Test
    public void findAllUsers() throws Exception {
                mvc.perform(get("/findAll"));

    }
//        List<User> users = new ArrayList<>();
//        userService.findAll().forEach((o, o2) -> users.add((User) o2));
//        users.forEach(o -> System.out.println(o));


}

package user.portal.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import user.portal.config.RedisConfig;
import user.portal.model.User;

import java.util.Map;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class UserRepositoryIntegrationTest {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Test.class);

    @Autowired
    private UserRepository UserRepository;

    @Test
    public void whenSavingUser_thenAvailableOnRetrieval() throws Exception {
        final User user = new User("5", "John", "Doe", "jdoh@dohhead.com");
        UserRepository.saveUser(user);
        final User retrievedUser = UserRepository.findUser(user.getId());
        assertEquals(user.getId(), retrievedUser.getId());

    }

    @Test
    public void whenUpdatingUser_thenAvailableOnRetrieval() throws Exception {
        final User user = new User("6", "John", "Doe", "");
        UserRepository.saveUser(user);
        user.setFirstName("Richard");
        user.setLastName("Watson");
        UserRepository.saveUser(user);
        final User retrievedUser = UserRepository.findUser(user.getId());
        LOGGER.info("{}:{} ", retrievedUser.getId(), retrievedUser.getFirstName());
        assertEquals(user.getFirstName(), retrievedUser.getFirstName());

    }

    @Test
    public void whenSavingUsers_thenAllShouldAvailableOnRetrieval() throws Exception {
        final User engUser = new User("7", "John Doe", "Doe", "jdoh@dohhead.com");
        final User medUser = new User("8", "Gareth", "Houston", "gar@gar.com");
        UserRepository.saveUser(engUser);
        UserRepository.saveUser(medUser);
        final Map<String, User> retrievedUser = UserRepository.findAllUsers();
        retrievedUser.forEach((o, o2) -> System.out.println((User)o2));
        LOGGER.info("{}:{} ", "Size " , retrievedUser.size());
        //assertEquals(retrievedUser.size(), 4);
        assert(retrievedUser.size() > 2);


    }

//    @Test
//    public void whenDeletingUser_thenNotAvailableOnRetrieval() throws Exception {
//        final User user = new User("Eng2015001", "John Doe", User.Gender.MALE, 1);
//        UserRepository.saveUser(user);
//        UserRepository.deleteUser(user.getId());
//        final User retrievedUser = UserRepository.findUser(user.getId());
//        assertNull(retrievedUser);
//    }


}
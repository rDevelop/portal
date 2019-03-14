package user.portal.repo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import user.portal.model.User;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);
    private static final String KEY = "USER";

    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void saveUser(final User user) {
        LOGGER.info("{}:{}:{} ", "saveUser " , user.getId(), user);

        hashOperations.put(KEY, user.getId(), user);
    }

    public void updateUser(final User user) {
        hashOperations.put(KEY, user.getId(), user);
    }

    public User findUser(final String id) {
        return (User) hashOperations.get(KEY, id);
    }

    public Map<String, User> findAllUsers() {
        return hashOperations.entries(KEY);
    }

    public void deleteUser(final String id) {
        hashOperations.delete(KEY, id);
    }

    public void listAllUsers() {
        final Map<String, User> keys = hashOperations.entries(KEY);
        for (Map.Entry<String, User> entry : keys.entrySet()) {
            LOGGER.info("{}:{} ", entry.getKey(), entry.getValue());
        }
    }
}
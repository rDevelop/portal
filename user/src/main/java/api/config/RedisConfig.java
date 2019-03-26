package api.config;

import api.users.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import api.Receiver;

import java.util.concurrent.CountDownLatch;

/**
 * Created by rob on 6/20/17.
 */
@Configuration
@ComponentScan("api")
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("localhost");
        jedisConnectionFactory.setPort(6379);
        return jedisConnectionFactory;
    }

    @Bean
    RedisMessageListenerContainer container(MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template() {
        return new StringRedisTemplate(jedisConnectionFactory());
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate() {
        final RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }
}

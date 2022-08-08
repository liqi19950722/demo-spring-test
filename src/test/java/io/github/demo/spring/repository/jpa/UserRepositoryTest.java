package io.github.demo.spring.repository.jpa;

import io.github.demo.spring.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/8/8
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        var user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@gmail.com");
        userRepository.save(user);

        assertNotNull(user.getId());
    }
}
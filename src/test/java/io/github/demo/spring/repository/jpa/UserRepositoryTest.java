package io.github.demo.spring.repository.jpa;

import io.github.demo.spring.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/8/8
 */
//@Sql(scripts = {"file:sql/ddl/user_schema.sql"})
//@SqlMergeMode(value = SqlMergeMode.MergeMode.MERGE)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class UserRepositoryTest {
    @Container
    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>(DockerImageName.parse("mysql:8.0.30"))
            .withDatabaseName("demo")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void dataSourceProperties(DynamicPropertyRegistry registry) {
        mysqlContainer.start();
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
    }

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

    @Sql(scripts = {"file:sql/data/test_user_data.sql"})
    @Test
    public void test_users() {
        var users = userRepository.findAll();
        assertEquals(3, users.size());
    }
}
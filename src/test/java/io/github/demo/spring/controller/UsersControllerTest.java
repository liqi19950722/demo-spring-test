package io.github.demo.spring.controller;

import io.github.demo.spring.domain.user.User;
import io.github.demo.spring.domain.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/9/19
 */
@WebMvcTest(value = {UsersController.class})
public class UsersControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Users users;

    @BeforeEach
    public void setup() {
        User user_01 = new User();
        user_01.setName("张三");
        user_01.setId(1L);
        user_01.setAge(18);
        user_01.setEmail("san.zhang@gmail.com");
        List<User> userList = List.of(user_01);
        when(users.getAll()).thenReturn(userList);
    }

    @Test
    public void should_return_users() throws Exception {
        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("张三"))
                .andExpect(jsonPath("$[0].age").value(18))
                .andExpect(jsonPath("$[0].email").value("san.zhang@gmail.com"));
    }
}

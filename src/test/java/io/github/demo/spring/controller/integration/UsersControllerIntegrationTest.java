package io.github.demo.spring.controller.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/9/19
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsersControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @Transactional
    @Rollback
    @Sql(scripts = "file:sql/data/test_user_data.sql")
    public void should_return_users() throws Exception {
        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].id").isNotEmpty())
                .andExpect(jsonPath("$[0].name").value("张三"))
                .andExpect(jsonPath("$[0].age").value(17))
                .andExpect(jsonPath("$[0].email").value("zhangsan@gmail.com"))
                .andExpect(jsonPath("$[1].id").isNotEmpty())
                .andExpect(jsonPath("$[1].name").value("李四"))
                .andExpect(jsonPath("$[1].age").value(18))
                .andExpect(jsonPath("$[1].email").value("lisi@gmail.com"))
                .andExpect(jsonPath("$[2].id").isNotEmpty())
                .andExpect(jsonPath("$[2].name").value("王五"))
                .andExpect(jsonPath("$[2].age").value(19))
                .andExpect(jsonPath("$[2].email").value("wangwu@gmail.com"));
    }

}

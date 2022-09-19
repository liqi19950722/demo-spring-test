package io.github.demo.spring.controller;

import io.github.demo.spring.domain.user.User;
import io.github.demo.spring.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/9/19
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private Users users;

    @GetMapping
    public List<User> list() {
        return users.getAll();
    }
}

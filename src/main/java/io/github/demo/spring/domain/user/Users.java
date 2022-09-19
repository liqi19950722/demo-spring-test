package io.github.demo.spring.domain.user;

import io.github.demo.spring.repository.jpa.UserRepository;
import io.github.demo.spring.repository.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/8/8
 */
@Component
public class Users {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    public List<User> getAll() {
        return userMapper.selectAll();
    }
}

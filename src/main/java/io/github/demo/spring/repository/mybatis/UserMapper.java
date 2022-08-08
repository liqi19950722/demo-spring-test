package io.github.demo.spring.repository.mybatis;

import io.github.demo.spring.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/8/8
 */
@Mapper
public interface UserMapper {
    List<User> selectAll();
}

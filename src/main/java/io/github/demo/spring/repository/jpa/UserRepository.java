package io.github.demo.spring.repository.jpa;

import io.github.demo.spring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/8/8
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

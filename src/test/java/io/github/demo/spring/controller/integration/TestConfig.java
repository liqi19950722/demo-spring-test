package io.github.demo.spring.controller.integration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/9/19
 */
@Configuration
@EnableAutoConfiguration
@AutoConfigurationPackage(basePackages = {
        "io.github.demo.spring.repository",
        "io.github.demo.spring.domain.user"
})
/*
choose one with  @AutoConfigurationPackage
@EnableJpaRepositories(basePackages = {
        "io.github.demo.spring.repository.jpa"
})
@EntityScan(basePackages = {
        "io.github.demo.spring.domain.user"
})
@MapperScan(basePackages = {
        "io.github.demo.spring.repository.mybatis"
})*/
public class TestConfig {
}

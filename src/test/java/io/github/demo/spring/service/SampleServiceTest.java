package io.github.demo.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/10/13
 */
@SpringJUnitConfig(value = SampleServiceTest.TestConfig.class)
public class SampleServiceTest {

    @Autowired
    SampleService service;
    @Test
    public void should_(){
        assertNotNull(service);
    }
    @ComponentScan(basePackages = {"io.github.demo.spring.service"})
    @Configuration
    static class TestConfig {

    }
}

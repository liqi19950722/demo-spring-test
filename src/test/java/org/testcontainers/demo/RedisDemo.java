package org.testcontainers.demo;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/8/9
 */
@Testcontainers
public class RedisDemo {
    @Container
    public GenericContainer redis = new GenericContainer<>(DockerImageName.parse("redis:7.0.4")).withExposedPorts(6379);

    @BeforeEach
    public void before() {
        String host = redis.getHost();
        Integer port = redis.getFirstMappedPort();
        System.out.printf("host %s port %d\n", host, port);
    }

    @Test
    public void test() {
        assertTrue(redis.isRunning());
    }
}

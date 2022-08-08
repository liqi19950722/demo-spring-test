package io.github.demo.spring.controller;

import com.alibaba.cola.dto.SingleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/8/8
 */
@RestController
public class DemoController {

    @GetMapping(value = "/demo/foo")
    public SingleResponse<String> foo() {
        return SingleResponse.of("foo");
    }
}

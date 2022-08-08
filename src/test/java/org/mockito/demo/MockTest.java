package org.mockito.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * @author qi.li
 * @email liq@hzgjgc.com
 * @since 2022/8/8
 */
public class MockTest {

    @Test
    public void demo_mock() {
        DemoService mock = Mockito.mock(DemoService.class);
        when(mock.echo()).thenReturn("mock echo");

        String echoValue = mock.echo();
        assertEquals("mock echo", echoValue);
    }

    @Test
    public void demo_spy() {
        DemoService spy = Mockito.spy(new DemoService());

        assertEquals("echo hello world", spy.echo());
    }

    class DemoService {
        public String echo() {
            return "echo hello world";
        }
    }
}

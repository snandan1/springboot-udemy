package com.luv2code.springboot.demo.mycoolapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerThatUsesTwoSingletonBeansTests {

    private final String serverUrl = "http://localhost";

    @LocalServerPort
    private int serverPort;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${spring.security.user.name}")
    private String userName;

    @Value("${spring.security.user.password}")
    private String password;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getVolleyballWorkoutShouldReturnCorrectMessage() {
        System.out.printf("%s:%d%s/volleyball-workout", serverUrl, serverPort, contextPath);
        assertThat(
                this.testRestTemplate
                        .withBasicAuth(userName, password)
                        .getForObject(
                                String.format("%s:%d%s/volleyball-workout", serverUrl, serverPort, contextPath), String.class))
                .contains("Practice jumping in the court Practice jumping in the court");
    }

    @Test
    public void getBeanEqualityShouldShowBeansAreEqual() {
        System.out.printf("%s:%d%s/bean-equality", serverUrl, serverPort, contextPath);
        assertThat(this.testRestTemplate
                .withBasicAuth(userName, password)
                .getForObject(
                        String.format("%s:%d%s/bean-equality", serverUrl, serverPort, contextPath), String.class))
                .isEqualToIgnoringCase("True");
    }
}

package br.com.gabrielluizsf.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloworldApplicationTests {

	HelloworldApplication app = new HelloworldApplication();

	@Test
	void contextLoads() {
	}
	@Test
    public void testHelloWorld() {
        String result = app.helloWorld();
        assertEquals("Hello World", result);
    }

}

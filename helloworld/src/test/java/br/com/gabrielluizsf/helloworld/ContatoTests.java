package br.com.gabrielluizsf.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContatoTests {
    Contato app = new Contato();

    @Test
    public void testId(){
        int id  = 5;
        app.setId(id);
        
        int result = app.getId();
        assertEquals(id, result);
    }

    @Test
    public void testNome(){
        String nome = "Gabriel";
        app.setNome(nome);

        String result = app.getNome();
        assertEquals(nome, result);
    }
    @Test
    public void testEmail(){
        String email = "gabriel@gmail.com";
        app.setEmail(email);

        String result = app.getEmail();
        assertEquals(email, result);
    }
}

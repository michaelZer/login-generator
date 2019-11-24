package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {

    @Test
    public void passwordGenerationTest(){
        String password = new PasswordGeneration().getRandomPassword();
        assertEquals(8, password.length());
    }
}
package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginService loginService;
    LoginGenerator loginGenerator;

    @Before
    public void setUp(){
        //GIVEN
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void ct1(){
        //WHEN
        String loginPDUR = loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
        String loginJRAL2 = loginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
        //THEN
        assertEquals("The login should be PDUR", "PDUR", loginPDUR);
        assertEquals("The login should be JRAL2", "JRAL2", loginJRAL2);
    }

    @Test
    public void ct2(){
        //WHEN
        String login = loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
        //THEN
        assertEquals("The login should be JROL1", "JROL1", login);
    }

    @Test
    public void ct3(){
        //WHEN
        String login = loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        //THEN
        assertEquals("The login should be PDUR", "PDUR", login);
    }
}
package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private String[] loginsExistants;
    private LoginService loginService;

    @Before
    public void setUp(){
        //GIVEN
        loginsExistants = new String[] {"login0", "login1", "log2"};
        loginService = new LoginService(loginsExistants);
    }
    @Test
    public void loginExistsTest(){
        //GIVEN
        String existingLogin = "login0";
        String notExistingLogin = "login4";
        //WHEN/THEN
        assertTrue(loginService.loginExists(existingLogin));
        assertFalse(loginService.loginExists(notExistingLogin));
    }

    @Test
    public void addLoginTest(){
        //WHEN
        loginService.addLogin("login3");
        //THEN
        assertTrue(loginService.loginExists("login3"));
    }

    @Test
    public void findAllLoginsStartingWithTest() {
        //GIVEN
        List<String> expected = new ArrayList<String>();
        expected.add(loginsExistants[0]);
        expected.add(loginsExistants[1]);
        //WHEN
        List<String> prefIsLogin = loginService.findAllLoginsStartingWith("login");
        //THEN
        assertEquals(expected, prefIsLogin);
    }

    @Test
    public void findAllLoginsTest() {
        //GIVEN
        List<String> expected = new ArrayList<String>();
        expected.add(loginsExistants[2]);
        expected.add(loginsExistants[0]);
        expected.add(loginsExistants[1]);
        //WHEN
        List<String> logins = loginService.findAllLogins();
        //THEN
        assertEquals(expected, logins);
    }
}
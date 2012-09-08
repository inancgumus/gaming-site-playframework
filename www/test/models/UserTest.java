package models;

import org.junit.*;
import java.util.*;
import play.test.*;

public class UserTest extends UnitTest {
    
    @Before
    public void setup() {
        Fixtures.deleteAll();
        Fixtures.load("data.yml");
    }
    
    @Test
    public void createAndRetrieve() {
        User inancgumus = User.find("byName", "Inanc Gumus").first();
        
        assertNotNull(inancgumus);
        assertEquals("Inanc Gumus", inancgumus.name);
        assertEquals("test1@oyunsensin.com", inancgumus.email);
        assertEquals("test1", inancgumus.password);
    }

    @Test
    public void tryAuthenticate() {
        shouldBeAValidUser("test1@oyunsensin.com", "test1");
        shouldBeAValidUser("test2@oyunsensin.com", "test2");
        shouldNotBeAValidUser("test1@oyunsensin.com", "wrong");
        shouldNotBeAValidUser("test2@oyunsensin.com", "test1");
    }
    
    private void authenticate(String username, String password) {
        User.authenticate(username, password);
    }
    
    private void shouldBeAValidUser(String username, 
        String password) {
            assertNull(authenticate(username, password));
    }

    private void shouldNotBeAValidUser(String username, 
        String password) {
            assertNotNull(authenticate(username, password));
    }
}

package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from
        // https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()), "Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Austin Q.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("austish", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s25-05", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Austin Q."), "Team should contain Austin Q.");
        assertTrue(t.getMembers().contains("Awin"), "Team should contain Awin.");
        assertTrue(t.getMembers().contains("Jim"), "Team should contain Jim.");
        assertTrue(t.getMembers().contains("Vishal"), "Team should contain Vishal.");
        assertTrue(t.getMembers().contains("Hien"), "Team should contain Hien.");
        assertTrue(t.getMembers().contains("Michael"), "Team should contain Michael.");
    }
}

package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void testEquals_Case1_SameObject() {
        // Case 1: Comparing an object to itself
        Team teamA = new Team("Team A");
        assertTrue(teamA.equals(teamA));
    }

    @Test
    public void testEquals_Case2_DifferentClass() {
        // Case 2: Comparing a Team object to an object of a different class
        Team teamA = new Team("Team A");
        String notATeam = "I am not a Team object";
        assertFalse(teamA.equals(notATeam));
    }

    @Test
    public void testEquals_Case3_TT_EqualObjects() {
        // Case 3 (T, T): Different objects, same name, same members
        Team teamA1 = new Team("Team A");
        teamA1.addMember("Alice");
        teamA1.addMember("Bob");

        Team teamA2 = new Team("Team A");
        teamA2.addMember("Alice");
        teamA2.addMember("Bob");

        assertTrue(teamA1.equals(teamA2));
    }

    @Test
    public void testEquals_Case3_TF_SameNameDifferentMembers() {
        // Case 3 (T, F): Different objects, same name, different members
        Team teamA1 = new Team("Team A");
        teamA1.addMember("Alice");
        teamA1.addMember("Bob");

        Team teamA2 = new Team("Team A");
        teamA2.addMember("Alice");
        teamA2.addMember("Charlie"); // Different member

        assertFalse(teamA1.equals(teamA2));
    }

    @Test
    public void testEquals_Case3_FT_DifferentNameSameMembers() {
        // Case 3 (F, T): Different objects, different name, same members
        Team teamA = new Team("Team A");
        teamA.addMember("Alice");
        teamA.addMember("Bob");

        Team teamB = new Team("Team B"); // Different name
        teamB.addMember("Alice");
        teamB.addMember("Bob");

        assertFalse(teamA.equals(teamB));
    }

    @Test
    public void testEquals_Case3_FF_DifferentNameDifferentMembers() {
        // Case 3 (F, F): Different objects, different name, different members
        Team teamA = new Team("Team A");
        teamA.addMember("Alice");
        teamA.addMember("Bob");

        Team teamB = new Team("Team B"); // Different name
        teamB.addMember("Charlie");
        teamB.addMember("David"); // Different members

        assertFalse(teamA.equals(teamB));
    }

    @Test
    public void hashCodeTest() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);

    }
}

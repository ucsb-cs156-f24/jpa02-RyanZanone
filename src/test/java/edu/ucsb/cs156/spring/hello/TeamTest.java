package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        assert team.equals(team);
    }

    @Test
    public void equals_different_class() {
        String test = "test";
        assert !(team.equals(test));
    }

    @Test
    public void equals_name_and_members_same() {
        Team team2 = new Team("test-team");
        assert team.equals(team2);
    }

    @Test 
    public void equals_name_and_members__both_diff() {
        Team team2 = new Team("team2");
        team2.addMember("Ryan");
        assert !(team.equals(team2));
    }

    @Test 
    public void equals_names_diff_members_same() {
        Team team2 = new Team("team2");
        assert !(team.equals(team2));
    }

    @Test 
    public void equals_members_diff_names_same() {
        Team team2 = new Team("test-team");
        team2.addMember("Ryan");
        assert !(team.equals(team2));
    }

    @Test 
    public void hashCode_same_code() {
        Team team1 = new Team("test-team");
        team1.addMember("Ryan");
        Team team2 = new Team("test-team");
        team2.addMember("Ryan");
        int expectedResult = -1225835781;
        assertEquals(expectedResult, team1.hashCode());
        assertEquals(expectedResult, team2.hashCode());
    }

}

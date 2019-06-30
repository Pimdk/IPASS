package models;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private int id;
    private String name;
    private int year;
    private List<Team> teams;

    public Competition(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
        teams = new ArrayList<>();
    }

    public Competition() {
        teams = new ArrayList<>();
    }

    public void addTeam(Team team)
    {
        teams.add(team);
    }

    public void removeTeam(Team team)
    {
        for (Team registeredTeam: teams) {
            if(registeredTeam.getId() == team.getId())
            {
                teams.remove(registeredTeam);
                break;
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Team> getTeams()
    {
        return teams;
    }
}

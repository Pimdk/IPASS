package repositories;

import dbcontexts.TeamContext;
import models.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    private TeamContext context;
    private List<Team> teams;

    public TeamRepository(TeamContext context) {
        this.context = context;
        teams = new ArrayList<>(context.getAllTeams());
    }

    public List<Team> getAllTeams()
    {
        return teams;
    }
}

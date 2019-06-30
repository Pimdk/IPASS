package dbcontexts;

import models.Team;

import java.util.List;

public class TeamTestContext implements TeamContext {
    @Override
    public void createTeam(Team team) {

    }

    @Override
    public Team readTeam(int id) {
        return null;
    }

    @Override
    public List<Team> getAllTeams() {
        return null;
    }

    @Override
    public void updateTeam(Team team) {

    }

    @Override
    public void deleteTeam(Team team) {

    }
}

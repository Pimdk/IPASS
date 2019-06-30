package dbcontexts;

import models.Team;

import java.util.List;

public interface TeamContext {
    void createTeam(Team team);

    Team readTeam(int id);

    List<Team> getAllTeams();

    void updateTeam(Team team);

    void deleteTeam(Team team);
}

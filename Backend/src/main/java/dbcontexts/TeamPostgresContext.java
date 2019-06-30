package dbcontexts;

import models.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TeamPostgresContext extends PostgresBaseDao implements TeamContext {
    @Override
    public void createTeam(Team team) {
        try (Connection con = super.getConnection()){
            String query = "INSERT INTO Team(TeamID, LeeftijdsKlasse, Klasse, Naam) VALUES(team_seq, "+team.getId()+", "+team.getAgeRanking()+", "+team.getRanking()+", "+team.getName()+";";
            PreparedStatement prpst = con.prepareStatement(query);
            prpst.executeQuery();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
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

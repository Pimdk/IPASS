package dbcontexts;

import models.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerPostgresContext extends PostgresBaseDao implements PlayerContext {
    @Override
    public void createPlayer(Player player) {
        try (Connection con = super.getConnection()){
            int spelerID = player.getId();
            String vn = player.getForname();
            String an = player.getSurname();
            String gen = player.getGender();
            Date verj = player.getBirthday();
            String email = player.getEmail();
            String query = "INSERT INTO Speler(SpelerID, Voornaam, Achternaam, Geslacht, Leeftijd, Email) VALUES(speler_seq, "+vn+", "+an+", "+gen+", "+verj+", "+email+");";
            PreparedStatement prpst = con.prepareStatement(query);
            prpst.executeUpdate();
        } catch (SQLException sqle){
            System.out.println("SQL statement klopt niet");
        }

    }

    @Override
    public Player readPlayer(int id) {
        try (Connection con = super.getConnection()){
            String query = "Select * from Speler Where SpelerID = "+id+";";
            PreparedStatement prpst = con.prepareStatement(query);
            ResultSet postgreResultSet = prpst.executeQuery();
            while (postgreResultSet.next()){
                String voornaam = postgreResultSet.getString("Voornaam");
                String achternaam = postgreResultSet.getString("Achternaam");
                String geslacht = postgreResultSet.getString("Geslacht");
                Date leeftijd = postgreResultSet.getDate("Leeftijd");
                int spelerid = postgreResultSet.getInt("SpelerID");
                String email = postgreResultSet.getString("Email");
                Player speler = new Player(spelerid, voornaam, achternaam, geslacht, leeftijd, null, email);
                return speler;
                }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Player> getAllPlayers() {
        List<Player> spelerlist = new ArrayList<Player>();
        try (Connection con = super.getConnection()){
            String query = "Select * from Speler;";
            PreparedStatement prpst = con.prepareStatement(query);
            ResultSet postgreResultSet = prpst.executeQuery();
            while(postgreResultSet.next()) {
                String voornaam = postgreResultSet.getString("Voornaam");
                String achternaam = postgreResultSet.getString("Achternaam");
                String geslacht = postgreResultSet.getString("Geslacht");
                Date leeftijd = postgreResultSet.getDate("Leeftijd");
                int spelerid = postgreResultSet.getInt("SpelerID");
                String email = postgreResultSet.getString("Email");
                Player speler = new Player(spelerid, voornaam, achternaam, geslacht, leeftijd, null, email);
                spelerlist.add(speler);
            }return spelerlist;

            }
         catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePlayer(Player player) {
        try (Connection con = super.getConnection()) {
            String query = "UPDATE Speler SET Spelerid = "+player.getId()+", Voornaam = "+player.getForname()+", Achternaam = "+player.getSurname()+", Geslacht = "+player.getGender()+", Leeftijd = "+player.getBirthday()+", Email = "+player.getEmail()+";";
            PreparedStatement prpst = con.prepareStatement(query);
            prpst.executeQuery();
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
<<<<<<< HEAD
    public void deletePlayer(Player player) {
        try(Connection con = super.getConnection()){
            String query = "DELETE From Speler WHERE SpelerID = "+player.getId()+";";
            PreparedStatement prpst = con.prepareStatement(query);
            prpst.executeQuery();
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
=======
    public void deletePlayer(int id) {

>>>>>>> 979c32f6a1879691bc86bdae0d826f08cbcb2a5d
    }
}

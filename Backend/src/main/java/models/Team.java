package models;

import java.util.List;

public class Team {
    private int id;
    private String name;
    private String ageRanking;
    private String ranking;
    private List<Player> players;

    public Team(int id, String name, String ageRanking, String ranking) {
        this.id = id;
        this.name = name;
        this.ageRanking = ageRanking;
        this.ranking = ranking;
    }

    public Team() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAgeRanking() {
        return ageRanking;
    }

    public String getRanking() {
        return ranking;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public void removePlayer(Player player)
    {
        for (Player registeredPlayer: players
             ) {
            if(registeredPlayer.getId() == player.getId())
            {
                players.remove(registeredPlayer);
                break;
            }
        }
    }
}

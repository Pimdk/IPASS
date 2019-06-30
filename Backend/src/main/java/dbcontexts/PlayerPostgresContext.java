package dbcontexts;

import models.Player;

import java.util.List;

public class PlayerPostgresContext implements PlayerContext {
    @Override
    public void createPlayer(Player player) {

    }

    @Override
    public Player readPlayer(int id) {
        return null;
    }


    @Override
    public List<Player> getAllPlayers() {
        return null;
    }

    @Override
    public void updatePlayer(Player player) {

    }

    @Override
    public void deletePlayer(int id) {

    }
}

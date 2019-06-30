package dbcontexts;

import models.Player;

import java.util.Date;
import java.util.List;

public class PlayerTestContext implements PlayerContext {
    @Override
    public void createPlayer(Player player) {

    }

    @Override
    public Player readPlayer(int id) {
        Player player = new Player(1, "nick", "thijssen", "male", new Date(), "nickthijssen1994", "nickthijssen1994@gmail.com");
        return player;
    }

    @Override
    public List<Player> getAllPlayers() {
        return null;
    }

    @Override
    public void updatePlayer(Player player) {

    }

    @Override
    public void deletePlayer(Player player) {

    }
}

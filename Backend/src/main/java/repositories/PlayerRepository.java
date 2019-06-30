package repositories;

import dbcontexts.PlayerContext;
import models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private PlayerContext context;
    private List<Player> players;

    public PlayerRepository(PlayerContext context) {
        this.context = context;
        players = new ArrayList<>();
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public boolean addNewPlayer(Player player) {
        for (Player registeredPlayer : players) {
            if (registeredPlayer.getForname().equalsIgnoreCase(player.getForname()) && registeredPlayer.getSurname().equalsIgnoreCase(player.getSurname()) && registeredPlayer.getBirthday().equals(player.getBirthday())) {
                return false;
            } else {
                context.createPlayer(player);
            }
        }
        return true;
    }

    public Player getPlayer(int id)
    {
        return context.readPlayer(id);
    }
}

package repositories;

import dbcontexts.PlayerContext;
import models.Player;

import java.util.List;

public class PlayerRepository {
    private PlayerContext context;

    public PlayerRepository(PlayerContext context) {
        this.context = context;
    }

    public List<Player> getAllPlayers() {
        return context.getAllPlayers();
    }

    public boolean addNewPlayer(Player player) {
        for (Player registeredPlayer : context.getAllPlayers()) {
            if (registeredPlayer.getForname().equalsIgnoreCase(player.getForname()) && registeredPlayer.getSurname().equalsIgnoreCase(player.getSurname()) && registeredPlayer.getBirthday().equals(player.getBirthday())) {
                return false;
            } else {
                context.createPlayer(player);
            }
        }
        return true;
    }

    public void updatePlayer(Player player)
    {
        for (Player registeredPlayer : context.getAllPlayers()) {
            if (registeredPlayer.getId() == player.getId()) {
                context.updatePlayer(player);
                break;
            }
        }
    }

    public Player getPlayer(int id) {
        return context.readPlayer(id);
    }

    public boolean deletePlayer(int id) {
        for (Player registeredPlayer : context.getAllPlayers()) {
            if (registeredPlayer.getId() == id) {
                context.deletePlayer(id);
                return true;
            }
        }
        return false;
    }
}

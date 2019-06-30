package dbcontexts;

import models.Player;

import java.util.List;

public interface PlayerContext {
    void createPlayer(Player player);

    Player readPlayer(int id);

    List<Player> getAllPlayers();

    void updatePlayer(Player player);

    void deletePlayer(int id);
}

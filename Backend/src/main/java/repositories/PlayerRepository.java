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

    public List<Player> getAllPlayers()
    {
        return context.getAllPlayers();
    }
}

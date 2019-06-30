package dbcontexts;

import models.Player;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerTestContext implements PlayerContext {

    private List<Player> players;

    public PlayerTestContext() {
        players = new ArrayList<>();
        players.add(new Player(1, "Nick", "Thijssen", "male", new Date(), "nickthijssen1994", "nickthijssen1994@gmail.com"));
        players.add(new Player(2, "Pim", "de Kort", "male", new Date(), "pimdk69", "pimdk@gmail.com"));
        players.add(new Player(3, "Jaap", "Klerx", "male", new Date(), "jaapklerx420", "jaapklerx@gmail.com"));
        players.add(new Player(4, "Ivo", "Prince", "male", new Date(), "ivoprince", "ivoprince1994@gmail.com"));
    }

    @Override
    public void createPlayer(Player player) {

    }

    @Override
    public Player readPlayer(int id) {
        for (Player registeredPlayer : players) {
            if (registeredPlayer.getId() == id) {
                return registeredPlayer;
            }
        }
        return new Player();
    }

    @Override
    public List<Player> getAllPlayers() {
        return players;
    }

    @Override
    public void updatePlayer(Player player) {

    }

    @Override
    public void deletePlayer(Player player) {

    }
}

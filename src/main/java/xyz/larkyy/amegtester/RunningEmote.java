package xyz.larkyy.amegtester;

import org.bukkit.entity.Player;
import xyz.larkyy.aquaticmodelengine.api.model.spawned.player.PlayerModel;

public class RunningEmote {

    private final Player player;
    private final PlayerModel playerModel;

    public RunningEmote(Player player, PlayerModel playerModel) {
        this.player = player;
        this.playerModel = playerModel;
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }
}

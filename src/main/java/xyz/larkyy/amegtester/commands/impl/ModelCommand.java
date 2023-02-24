package xyz.larkyy.amegtester.commands.impl;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.larkyy.amegtester.Amegtester;
import xyz.larkyy.amegtester.commands.ICommand;

public class ModelCommand implements ICommand {
    @Override
    public void run(CommandSender sender, String[] args) {
        if (!sender.hasPermission("amegtester.admin")) {
            return;
        }

        if (!(sender instanceof Player player)) {
            return;
        }

        if (args.length < 2) {
            return;
        }

        switch (args[1].toLowerCase()) {
            case "spawn": {
                if (args.length == 3) {
                    var model = Amegtester.getInstance().getModelsHandler().spawnModel(args[2],player.getLocation());
                    model.applyModel();
                    sender.sendMessage("Model spawned!");
                }
            }
        }

    }
}

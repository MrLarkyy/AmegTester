package xyz.larkyy.amegtester.commands.impl;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.larkyy.amegtester.Amegtester;
import xyz.larkyy.amegtester.commands.ICommand;

public class EmoteCommand implements ICommand {
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
            case "play": {
                if (args.length == 4) {
                    Amegtester.getInstance().getEmoteHandler().playEmote(player,args[2],args[3],false);
                    return;
                } else if (args.length == 6) {
                    Amegtester.getInstance().getEmoteHandler().playEmote(player,args[2],args[3],args[4],args[5],false);
                    return;
                }
            }
            case "stop": {
                Amegtester.getInstance().getEmoteHandler().stopEmote(player);
            }
            case "forcestop": {
                Amegtester.getInstance().getEmoteHandler().forceStopEmote(player);
            }
            case "list": {

            }
        }
    }
}

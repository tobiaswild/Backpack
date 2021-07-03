package de.tocoolmh58.backpack.command;

import de.tocoolmh58.backpack.Main;
import de.tocoolmh58.backpack.backpack.Backpack;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackpackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            Main.noPlayer(sender);
            return false;
        }
        if (!player.hasPermission("backpack.command")) {
            Main.noPermission(player);
            return false;
        }
        if (args.length > 0) {
            sendUsage(sender);
            return false;
        }
        Backpack backpack = Main.getInstance().getBackpackManager().getBackpack(player.getUniqueId());
        player.openInventory(backpack.getInventory());
        return true;
    }

    public void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.BLUE + "Verwendung: /backpack");
    }
}

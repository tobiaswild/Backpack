/*
* Original Source-Code by @DerBanko
*/

package de.tocoolmh58.backpack;

import de.tocoolmh58.backpack.backpack.BackpackManager;
import de.tocoolmh58.backpack.command.BackpackCommand;
import de.tocoolmh58.backpack.utils.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private Config config;
    private BackpackManager backpackManager;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    @Override
    public void onEnable() {
        getCommand();
        backpackManager = new BackpackManager();
    }

    @Override
    public void onDisable() {
        backpackManager.save();
        config.save();
    }

    public void getCommand() {
        this.getCommand("backpack").setExecutor(new BackpackCommand());
    }

    public static void noPlayer(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Dazu musst du ein Spieler sein");
    }
    public static void noPermission(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Dazu hast du keine Rechte");
    }

    public static Main getInstance() {
        return instance;
    }
    public Config getConfiguration() {
        return config;
    }
    public BackpackManager getBackpackManager() {
        return backpackManager;
    }

}

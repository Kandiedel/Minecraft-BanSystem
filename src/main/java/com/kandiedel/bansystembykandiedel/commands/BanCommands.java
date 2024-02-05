package com.kandiedel.bansystembykandiedel.commands;

import com.kandiedel.bansystembykandiedel.BanSystemByKandiedel;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BanCommands implements CommandExecutor {
    private BanSystemByKandiedel banSystemByKandiedel;
    public BanCommands(BanSystemByKandiedel banSystemByKandiedel) {
        this.banSystemByKandiedel = banSystemByKandiedel;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (cmd.getName().equalsIgnoreCase("ban")) {
            if (args.length >= 2) {
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fThe §d§l/ban §fcommand is still in the working progress!");
                return true;
            }
            sender.sendMessage("");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "§0§l          §dUsage§0§l");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /ban <Player> <Reason>");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage("");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("tempban")) {
            if (args.length >= 4) {
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fThe §d§l/tempban §fcommand is still in the working progress!");
                return true;
            }
            sender.sendMessage("");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "§0§l                    §dUsage§0§l");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "§f/tempban <player> <number> <d | w | y> <Reason>");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage("");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("unban")) {
            if (args.length == 1) {
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fThe §d§l/unban §fcommand is still in the working progress!");
                return true;
            }
            sender.sendMessage("");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "§0§l        §dUsage§0§l");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /unban <Player>");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage("");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("check")) {
            if (args.length == 1) {
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fThe §d§l/tempban §fcommand is still in the working progress!");
                return true;
            }
            sender.sendMessage("");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "§0§l            §dUsage§0§l");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /check <Player >");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage(banSystemByKandiedel.PREFIX + "");
            sender.sendMessage("");
            return true;
        }

        return false;
    }
}

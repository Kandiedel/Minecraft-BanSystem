package com.kandiedel.bansystembykandiedel.commands;

import com.kandiedel.bansystembykandiedel.BanSystemByKandiedel;
import com.kandiedel.bansystembykandiedel.ban.BanManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class InfoCommand implements CommandExecutor {

    private BanSystemByKandiedel banSystemByKandiedel;
    public InfoCommand(BanSystemByKandiedel banSystemByKandiedel) {
        this.banSystemByKandiedel = banSystemByKandiedel;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        sender.sendMessage("");
        sender.sendMessage(banSystemByKandiedel.PREFIX + "");
        sender.sendMessage(banSystemByKandiedel.PREFIX + "§fPlugin By §d§l§nKandiedel");
        sender.sendMessage(banSystemByKandiedel.PREFIX + "");
        sender.sendMessage("");

        return false;
    }
}

package com.kandiedel.bansystembykandiedel.utils;

import com.kandiedel.bansystembykandiedel.BanSystemByKandiedel;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sun.security.util.Password;

import javax.sound.sampled.Port;

public class Messages {

    private BanSystemByKandiedel banSystemByKandiedel;

    private String language;

    public Messages(BanSystemByKandiedel banSystemByKandiedel) {
        this.banSystemByKandiedel = banSystemByKandiedel;
        language = banSystemByKandiedel.getConfig().getString("Text.Language");
    }

    // Plugin messages

    public void pluginLoadedMessage() {
        switch (language) {
            case "ENGLISH": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage(banSystemByKandiedel.PREFIX + "§f-> §d§lBanSystemByKandiedel§f§l successfully loaded!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            case "GERMAN": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage(banSystemByKandiedel.PREFIX + "§f-> §d§lBanSystemByKandiedel§f§l erfolgreich geladen!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            default: {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
        }
    }

    // MySQL messages

    public void mySQLConnectedMessage() {
        switch (language) {
            case "ENGLISH": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("§d§l[MySQL] §fMySQL §a§lconnected§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            case "GERMAN": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("§d§l[MySQL] §fMySQL §a§lverbunden§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            default: {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
        }
    }
    public void mySQLNotConnectedMessage() {
        switch (language) {
            case "ENGLISH": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("§d§l[MySQL] §fMySQL §c§lnot connected§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            case "GERMAN": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("§d§l[MySQL] §fMySQL §c§lnicht verbunden§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            default: {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
        }
    }
    public void senderMySQLNotConnectedMessage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§l§fMySQL §c§lnot connected§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§l§fMySQL §c§lnicht verbunden§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
        }
    }
    public void mySQLCantCreateTableMessage() {
        switch (language) {
            case "ENGLISH": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("§d§l[MySQL] §fMySQL Table §c§lcan't be created§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            case "GERMAN": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("§d§l[MySQL] §fMySQL Table §c§lkonnte nicht erstellt werden§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            default: {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
        }
    }
    public void mySQLSupportMessage() {
        switch (language) {
            case "ENGLISH": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("§d§l[MySQL] §f§lIf you want MySQL support, you must fill out the configuration!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            case "GERMAN": {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("§d§l[MySQL] §f§lWenn du MySQL Support wuenscht, bitte einmal die configuration ausfuellen!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
            default: {
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                Bukkit.getConsoleSender().sendMessage("");
                Bukkit.getConsoleSender().sendMessage("");
                break;
            }
        }
    }

    // BanCommands messages

    public void sendBanUsage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /ban <Player> <Reason>");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /ban <Spieler> <Grund>");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }
    public void sendTempbanUsage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /tempban <Player> <Multiplier> <m | h | d | w | y> <Reason>");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /tempban <Spieler> <Multiplikator> <m | h | d | w | y> <Grund>");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }
    public void sendUnbanUsage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /unban <Player>");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /unban <Spieler>");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }

    }
    public void sendCheckUsage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /check <Player>");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f  /check <Spieler>");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }

    }

    public void sendPerms(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§c  Not enough permissions!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§c  Nicht genügend Rechte!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }

    }

    public void alreadyBannedMessage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§c§lThis player is already banned!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§c§lDieser Spieler ist bereits gebannt!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

    // Ban messages

    public void permbanMessage(CommandSender sender, String playername, String reason) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fYou have banned §d§l" + playername + "§f.");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fReason:");
                sender.sendMessage(banSystemByKandiedel.PREFIX + " - §f§l" + reason);
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fDu hast §d§l" + playername + " §fgebannt.");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fGrund:");
                sender.sendMessage(banSystemByKandiedel.PREFIX + " - §f§l" + reason);
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

    // Tempban messages

    public void tempbanMessage(CommandSender sender, String playername, String reason, int multiplier, String character) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "You have banned §d§l" + playername +  " §ffor §d§l" + multiplier + character + "§f.");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fReason:");
                sender.sendMessage(banSystemByKandiedel.PREFIX + " - §f§l" + reason);
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fDu hast §d§l" + playername +  " §ffür §d§l" + multiplier + character + " §fgebannt.");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fGrund:");
                sender.sendMessage(banSystemByKandiedel.PREFIX + " - §f§l" + reason);
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

    public void multiplierMessage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f<Multiplier> has to be a number!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f<Multiplikator> muss eine Nummer sein!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

    public void characterMessage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f<m | h | d | w | y> Must be one of the characters!");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f<m | h | d | w | y> Muss einer der Zeichen sein!");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

    // Unban messages

    public void notBannedMessage(CommandSender sender) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§c§lThis player is not banned!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§c§lDieser Spieler ist nicht gebannt!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

    public void unbanMessage(CommandSender sender, String playername) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fYou have unbanned §d§l" + playername + "§f.");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§fDu hast §d§l" + playername + " §fentbannt.");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

    // Check message

    public void checkNotBannedMessage(CommandSender sender, String playername) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lName: §f" + playername);
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lBanned: §c✘");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lName: §f" + playername);
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lGebannt: §c✘");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

    public void checkBannedMessage(CommandSender sender, String playername, String reason, String untilTime) {
        switch (language) {
            case "ENGLISH": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lName: §f" + playername);
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lBanned: §a✔");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lReason:");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "  §f§l" + reason);
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lUntil:");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "  §f§l" + untilTime);
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            case "GERMAN": {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lName: §f" + playername);
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lGebannt: §a✔");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lGrund:");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "  §f§l" + reason);
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§d§lBis:");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "  §f§l" + untilTime);
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
            default: {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(banSystemByKandiedel.PREFIX + "§f-> §c§lWrong language§f!");
                sender.sendMessage("");
                sender.sendMessage("");
                break;
            }
        }
    }

}

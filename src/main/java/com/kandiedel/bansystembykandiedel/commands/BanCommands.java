package com.kandiedel.bansystembykandiedel.commands;

import com.kandiedel.bansystembykandiedel.BanSystemByKandiedel;
import com.kandiedel.bansystembykandiedel.ban.BanManager;
import com.kandiedel.bansystembykandiedel.mysql.MySQLManager;
import com.kandiedel.bansystembykandiedel.utils.Messages;
import com.sun.nio.sctp.SendFailedNotification;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class BanCommands implements CommandExecutor {

    private Messages messages;
    private BanSystemByKandiedel banSystemByKandiedel;
    private BanManager banManager;
    private MySQLManager mySQLManager;
    public BanCommands(Messages messages, BanSystemByKandiedel banSystemByKandiedel, MySQLManager mySQLManager, BanManager banManager) {
        this.messages = messages;
        this.banSystemByKandiedel = banSystemByKandiedel;
        this.mySQLManager = mySQLManager;
        this.banManager = banManager;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("bansystem.cmd.ban") || sender.hasPermission("bansystem.cmd.tempban") || sender.hasPermission("bansystem.cmd.unban") || sender.hasPermission("bansystem.cmd.check")) {
            if (mySQLManager.isConnected()) {
                if (cmd.getName().equalsIgnoreCase("ban")) {
                    if (sender.hasPermission("bansystem.cmd.ban")) {
                        if (args.length >= 2) {
                            String playername = args[0];
                            if(!banManager.isBanned(getUUID(playername))) {
                                String reason = "";
                                for(int i = 1;i < args.length; i++) {
                                    reason += args[i] + " ";
                                }
                                Calendar cal = Calendar.getInstance();
                                String currentTime = String.valueOf(cal.getTimeInMillis());

                                banManager.ban(getUUID(playername), playername, reason, currentTime);

                                messages.permbanMessage(sender, playername, reason);
                                return true;
                            }
                            messages.alreadyBannedMessage(sender);
                            return true;
                        }
                        messages.sendBanUsage(sender);
                        return true;
                    }
                    messages.sendPerms(sender);
                    return true;
                }
                if (cmd.getName().equalsIgnoreCase("tempban")) {
                    if (sender.hasPermission("bansystem.cmd.tempban")) {
                        if (args.length >= 4) {
                            String playername = args[0];
                            if(!banManager.isBanned(getUUID(playername))) {
                                int multiplier = 0;
                                try {
                                    multiplier = Integer.parseInt(args[1]);
                                } catch (NumberFormatException e) {
                                    messages.multiplierMessage(sender);
                                    return true;
                                }
                                String character = args[2];
                                String reason = "";
                                for (int i = 3; i < args.length;i++) {
                                    reason += args[i] + " ";
                                }

                                Calendar cal = Calendar.getInstance();
                                String currentTime = String.valueOf(cal.getTimeInMillis());
                                switch (character) {
                                    case "m": {
                                        cal.add(Calendar.MINUTE, multiplier);
                                        break;
                                    }
                                    case "h": {
                                        cal.add(Calendar.HOUR, multiplier);
                                        break;
                                    }
                                    case "d": {
                                        cal.add(Calendar.HOUR, 24*multiplier);
                                        break;
                                    }
                                    case "w": {
                                        cal.add(Calendar.HOUR, 24*7*multiplier);
                                        break;
                                    }
                                    case "y": {
                                        cal.add(Calendar.YEAR, multiplier);
                                        break;
                                    }
                                    default: {
                                        messages.characterMessage(sender);
                                        return true;
                                    }
                                }
                                String untilTime = String.valueOf(cal.getTimeInMillis());


                                banManager.tempban(getUUID(playername), playername, reason, currentTime, untilTime);
                                messages.tempbanMessage(sender, playername, reason, multiplier, character);
                                return true;
                            }
                            messages.alreadyBannedMessage(sender);
                            return true;
                        }
                        messages.sendTempbanUsage(sender);
                        return true;
                    }
                    messages.sendPerms(sender);
                    return true;
                }
                if (cmd.getName().equalsIgnoreCase("unban")) {
                    if (sender.hasPermission("bansystem.cmd.unban")) {
                        if (args.length == 1) {
                            String playername = args[0];
                            if (banManager.isBanned(getUUID(playername))) {
                                banManager.unban(getUUID(playername));

                                messages.unbanMessage(sender, playername);
                                return true;
                            }
                            messages.notBannedMessage(sender);
                            return true;
                        }
                        messages.sendUnbanUsage(sender);
                        return true;
                    }
                    messages.sendPerms(sender);
                    return true;
                }
                if (cmd.getName().equalsIgnoreCase("check")) {
                    if (sender.hasPermission("bansystem.cmd.check")) {
                        if (args.length == 1) {
                            String playername = args[0];
                            if (banManager.isBanned(getUUID(playername))) {
                                long current = System.currentTimeMillis();
                                long end = banManager.getBanEndMillis(getUUID(playername));
                                String permaEnd = banManager.getBanEndPerma(getUUID(playername));
                                if (end - current > 0 || permaEnd.equals("-1")) {
                                    messages.checkBannedMessage(sender, playername, banManager.getReason(getUUID(playername)), banManager.getBanEndDate(getUUID(playername)));
                                    return true;
                                }
                                messages.checkNotBannedMessage(sender, playername);
                                return true;
                            }
                            messages.checkNotBannedMessage(sender, playername);
                            return true;
                        }
                        messages.sendCheckUsage(sender);
                        return true;
                    }
                    messages.sendPerms(sender);
                    return true;
                }
                return true;
            }
            messages.senderMySQLNotConnectedMessage(sender);
            return true;
        }
        messages.sendPerms(sender);
        return false;
    }

    private String getUUID(String playername) {
        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
    }
}

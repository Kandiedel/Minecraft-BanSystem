package com.kandiedel.bansystembykandiedel.ban;

import com.kandiedel.bansystembykandiedel.BanSystemByKandiedel;
import com.kandiedel.bansystembykandiedel.mysql.MySQLManager;
import com.kandiedel.bansystembykandiedel.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class BanManager {

    private Messages messages;
    private BanSystemByKandiedel banSystemByKandiedel;
    private MySQLManager mySQLManager;

    public BanManager(Messages messages, BanSystemByKandiedel banSystemByKandiedel, MySQLManager mySQLManager) {
        this.messages = messages;
        this.banSystemByKandiedel = banSystemByKandiedel;
        this.mySQLManager = mySQLManager;
    }

    public void ban(String uuid, String playername, String reason, String currentTime) {
        mySQLManager.update("INSERT INTO SuspendedPlayers (UUID, Playername, BanStart, BanEnd, Reason) VALUES ('"+uuid+"','"+playername+"','"+currentTime+"','-1','"+reason+"')");
        if(Bukkit.getPlayer(playername) != null) {
            Bukkit.getPlayer(playername).kickPlayer( "\n" +
                    "§c§l§nYou are banned from this Server!" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "§d§lReason: " +
                    "\n" +
                    "§f"+ getReason(uuid) +
                    "\n" +
                    "\n" +
                    "\n" +
                    "§d§lFrom: §f" +
                    "\n" +
                    getBanStartDate(uuid) +
                    "\n" +
                    "\n" +
                    "§d§lUntil: §f" +
                    "\n" +
                    getBanEndDate(uuid) +
                    "\n" +
                    "\n" +
                    "\n");
        }
    }

    public void tempban(String uuid, String playername, String reason, String currentTime, String untilTime) {
        mySQLManager.update("INSERT INTO SuspendedPlayers (UUID, Playername, BanStart, BanEnd, Reason) VALUES ('"+uuid+"','"+playername+"','"+currentTime+"','"+untilTime+"','"+reason+"')");
        if(Bukkit.getPlayer(playername) != null) {
            Bukkit.getPlayer(playername).kickPlayer( "\n" +
                    "§c§l§nYou are banned from this Server!" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "§d§lReason: " +
                    "\n" +
                    "§f"+ getReason(uuid) +
                    "\n" +
                    "\n" +
                    "\n" +
                    "§d§lFrom: §f" +
                    "\n" +
                    getBanStartDate(uuid) +
                    "\n" +
                    "\n" +
                    "§d§lUntil: §f" +
                    "\n" +
                    getBanEndDate(uuid) +
                    "\n" +
                    "\n" +
                    "\n");
        }
    }

    public void unban(String uuid) {
        mySQLManager.update("DELETE FROM SuspendedPlayers WHERE UUID='"+uuid+"'");
    }

    public boolean isBanned(String uuid) {
        ResultSet rs = mySQLManager.getResult("SELECT * FROM SuspendedPlayers WHERE UUID='"+uuid+"'");
        try {
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Long getBanStartMillis(String uuid) {
        ResultSet rs = mySQLManager.getResult("SELECT * FROM SuspendedPlayers WHERE UUID='"+uuid+"'");
        try {
            while (rs.next()) {
                return Long.valueOf(rs.getString("BanStart"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long NULL = 0;
        return NULL;
    }
    public String getBanStartDate(String uuid) {
        ResultSet rs = mySQLManager.getResult("SELECT * FROM SuspendedPlayers WHERE UUID='"+uuid+"'");
        try {
            while (rs.next()) {
                Long BanStartMillis = Long.valueOf(rs.getString("BanStart"));

                Calendar cal = Calendar.getInstance();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date banStartDate = new Date(BanStartMillis);
                return (dateFormat.format(banStartDate) + "\n" + "\n" + "§f( §n" + cal.getTimeZone().getID() + "§f )");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public Long getBanEndMillis(String uuid) {
        ResultSet rs = mySQLManager.getResult("SELECT * FROM SuspendedPlayers WHERE UUID='"+uuid+"'");
        try {
            while (rs.next()) {
                return Long.valueOf(rs.getString("BanEnd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long NULL = 0;
        return NULL;
    }
    public String getBanEndPerma(String uuid) {
        ResultSet rs = mySQLManager.getResult("SELECT * FROM SuspendedPlayers WHERE UUID='"+uuid+"'");
        try {
            while (rs.next()) {
                return rs.getString("BanEnd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String getBanEndDate(String uuid) {
        ResultSet rs = mySQLManager.getResult("SELECT * FROM SuspendedPlayers WHERE UUID='"+uuid+"'");
        try {
            while (rs.next()) {
                if(rs.getString("BanEnd").equals("-1")) {
                    return "PERMANENTLY";
                }
                Long BanStartMillis = Long.valueOf(rs.getString("BanEnd"));

                Calendar cal = Calendar.getInstance();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date banStartDate = new Date(BanStartMillis);
                return (dateFormat.format(banStartDate) + "\n" + "\n" + "§f( §n" + cal.getTimeZone().getID() + "§f )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getReason(String uuid) {
        ResultSet rs = mySQLManager.getResult("SELECT * FROM SuspendedPlayers WHERE UUID='"+uuid+"'");
        try {
            while (rs.next()) {
                return rs.getString("Reason");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

}

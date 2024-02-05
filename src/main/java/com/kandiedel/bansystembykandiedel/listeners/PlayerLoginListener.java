package com.kandiedel.bansystembykandiedel.listeners;

import com.kandiedel.bansystembykandiedel.BanSystemByKandiedel;
import com.kandiedel.bansystembykandiedel.ban.BanManager;
import com.kandiedel.bansystembykandiedel.mysql.MySQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLoginListener implements Listener {

    private BanSystemByKandiedel banSystemByKandiedel;
    private MySQLManager mySQLManager;
    private BanManager banManager;

    public PlayerLoginListener(BanSystemByKandiedel banSystemByKandiedel, MySQLManager mySQLManager, BanManager banManager) {
        this.banSystemByKandiedel = banSystemByKandiedel;
        this.mySQLManager = mySQLManager;
        this.banManager = banManager;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if (mySQLManager.isConnected()) {
            Player player = e.getPlayer();
            String uuid = player.getUniqueId().toString();
            if(banManager.isBanned(player.getUniqueId().toString())) {
                long current = System.currentTimeMillis();
                long end = banManager.getBanEndMillis(uuid);
                String permaEnd = banManager.getBanEndPerma(uuid);
                if(end - current > 0 || permaEnd.equals("-1")) {
                    e.disallow(PlayerLoginEvent.Result.KICK_BANNED,"\n" +
                            "§c§l§nYou are banned from this Server!" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "§d§lReason: " +
                            "\n" +
                            "§f"+ banManager.getReason(uuid) +
                            "\n" +
                            "\n" +
                            "\n" +
                            "§d§lFrom: §f" +
                            "\n" +
                            banManager.getBanStartDate(uuid) +
                            "\n" +
                            "\n" +
                            "§d§lUntil: §f" +
                            "\n" +
                            banManager.getBanEndDate(uuid) +
                            "\n" +
                            "\n" +
                            "\n");;
                }else {
                    banManager.unban(uuid);
                }
            }
        }
    }
}

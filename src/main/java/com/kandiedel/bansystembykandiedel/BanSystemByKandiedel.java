package com.kandiedel.bansystembykandiedel;

import com.kandiedel.bansystembykandiedel.ban.BanManager;
import com.kandiedel.bansystembykandiedel.commands.BanCommands;
import com.kandiedel.bansystembykandiedel.commands.InfoCommand;
import com.kandiedel.bansystembykandiedel.listeners.PlayerLoginListener;
import com.kandiedel.bansystembykandiedel.mysql.MySQLManager;
import com.kandiedel.bansystembykandiedel.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanSystemByKandiedel extends JavaPlugin {

    private MySQLManager mySQLManager;
    private BanManager banManager;
    public String PREFIX;

    @Override
    public void onEnable() {

        PREFIX = " §d§lBanSystem  §f";

        this.saveDefaultConfig();

        Messages messages = new Messages(this);

        connectMySQL(messages, this.getConfig().getString("MySQL.Host"),
                3306,
                this.getConfig().getString("MySQL.Database"),
                this.getConfig().getString("MySQL.User"),
                this.getConfig().getString("MySQL.Password"));

        banManager = new BanManager(messages, this, mySQLManager);

        BanCommands banCMD = new BanCommands(messages, this, mySQLManager, banManager);

        getCommand("ban").setExecutor(banCMD);
        getCommand("tempban").setExecutor(banCMD);
        getCommand("unban").setExecutor(banCMD);
        getCommand("check").setExecutor(banCMD);

        getCommand("i").setExecutor(new InfoCommand(this));

        Bukkit.getPluginManager().registerEvents(new PlayerLoginListener(this, mySQLManager, banManager), this);

        messages.pluginLoadedMessage();

    }

    @Override
    public void onDisable() {
        disconnectMySQL();
    }

    private void connectMySQL(Messages messages, String host, int port, String database, String user, String password) {
        mySQLManager = new MySQLManager(messages, host, port, database, user, password);
        if(!(host.isEmpty() || database.isEmpty() || user.isEmpty() || password.isEmpty())) {
            mySQLManager.createBannedTable();
            return;
        }
        messages.mySQLSupportMessage();
    }
    private void disconnectMySQL() {
        mySQLManager.disconnect();
    }
}

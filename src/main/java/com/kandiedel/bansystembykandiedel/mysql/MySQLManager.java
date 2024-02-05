package com.kandiedel.bansystembykandiedel.mysql;

import com.kandiedel.bansystembykandiedel.utils.Messages;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLManager {

    private Messages messages;

    private Connection con;

    private String host;
    private int port;
    private String database;
    private String user;
    private String password;

    public MySQLManager(Messages messages, String host, int port, String database, String user, String password) {
        this.messages = messages;
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;

        connect();
    }

    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", user, password);
            messages.mySQLConnectedMessage();
        } catch (SQLException e) {
            messages.mySQLNotConnectedMessage();
        }
    }

    public void disconnect() {
        try {
            if(isConnected()) {
                this.con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        if (this.con != null) {
            return true;
        }
        return false;
    }

    public Connection getConnection() {
        return this.con;
    }

    public void createBannedTable() {
        if (this.con != null) {
            try {
                this.con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS SuspendedPlayers (UUID VARCHAR(255), Playername VARCHAR(255), BanStart VARCHAR(255), BanEnd VARCHAR(255), Reason VARCHAR(255))");
            } catch (SQLException e) {
                messages.mySQLCantCreateTableMessage();
            }
        }
    }

    public void update(String qry) {
        if(isConnected()) {
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ResultSet getResult(String qry) {
        if(isConnected()) {
            try {
                return con.createStatement().executeQuery(qry);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}

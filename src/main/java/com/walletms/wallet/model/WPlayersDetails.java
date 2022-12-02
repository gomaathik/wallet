package com.walletms.wallet.model;

import javax.persistence.*;

@Entity
@Table (name = "PlayerDetails")
public class WPlayersDetails {
    @Id
    @Column
    private int playerId;
    @Column
    private String player;
    @Column
    private int balance;
    public WPlayersDetails(int playerId, int balance,String name) {
        this.playerId = playerId;
        this.player=name;
        this.balance=balance;
         }
    public WPlayersDetails() {

    }
    public String getPlayer() {
        return player;
    }
    public void setPlayer(String player) {
        this.player = player;
    }

    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

}


package com.walletms.wallet.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "WPlayersTransaction", columnNames = {"transId"})})
public class WPlayersTransaction {
    @Column
    private int playerId;
    @Column
    private String player;
    @Column
    private String transType; //to find credit or debit transaction
    @Id
    @Column(name = "transId", unique = true)
    private int transId; //random number for transaction reference
    @Column
    private int amt; // amount for credit or debit

    public WPlayersTransaction(int playerId, String name, String transType, int transId, int amt) {
        this.playerId = playerId;
        this.player = name;
        this.transType = transType;
        this.transId = transId;
        this.amt = amt;
    }

    public WPlayersTransaction() {
    }

    public WPlayersTransaction(int i) {
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

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    //@Override
    //public String toString() {
    //return "WPlayersTransaction [PlayerId=" + playerId + ",Player=" +player + ", TransType=" + transType + ", TransID=" + transId + ",Amount=" +amt +"]";
    //}

}
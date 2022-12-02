package com.walletms.wallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PlayerTransInfo")
public class WPlayerTransInfo {
    @Id
    @Column
    private int playerId;
    @Column
    private String transType; //to find credit or debit transaction
    @Column
    private int transId; //random number for transaction reference
    @Column
    private int amt; // amount for credit or debit

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

    public void setBalance(int transId) {
        this.transId = transId;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "PlayerTransInfo [PlayerId=" + playerId + ", TransType=" + transType + ",Amount=" + amt + "]";
    }


}

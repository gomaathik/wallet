package com.walletms.wallet.service;

import com.walletms.wallet.model.WPlayerTransInfo;
import com.walletms.wallet.model.WPlayersDetails;
import com.walletms.wallet.model.WPlayersTransaction;
import com.walletms.wallet.repository.WPlayersTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WPlayersTransactionService {
    @Autowired
    WPlayersTransactionRepository repository;
    @Autowired
    WPlayersDetailsService wPlayersDetailsService;

    public WPlayersTransaction getTrans(int id) {
        return repository.findById(id).get();
    }

    public List<WPlayersTransaction> getAllPlayers() {
        List<WPlayersTransaction> Players = new ArrayList<WPlayersTransaction>();
        repository.findAll().forEach(Player -> Players.add(Player));
        return Players;
    }

    public List<WPlayersTransaction> getAllTransType(int playerTransById) {
        WPlayersTransaction wPlayersTransaType = (WPlayersTransaction) repository.findAllByPlayerId(playerTransById);
        String transType = wPlayersTransaType.getTransType();

        return repository.findAllByPlayerId(playerTransById);
    }

    public List<WPlayersTransaction> getAllTrans(int id) {
        return repository.findAllByPlayerId(id);

    }

    public WPlayersTransaction processTransaction(WPlayerTransInfo Player) {
        System.out.println("Inside PROCESS TRANSACTION" + Player.getPlayerId());
        WPlayersDetails obj = wPlayersDetailsService.getPlayerById(Player.getPlayerId());
        System.out.println("Player data type" + Player);
        int balance = obj.getBalance();
        String name = obj.getPlayer();
        int playerId = Player.getPlayerId();
        String transType = Player.getTransType();
        int transId = Player.getTransId();
        //int transId=0;
        int amt = Player.getAmt();
        int total = 0;
        if (transType.equals("credit")) {
            total = balance + amt; //credit function
        } else if (balance > amt) {
            total = balance - amt; //debit function
        } else
            throw new EntityExistsException("Insufficient balance");

        WPlayersDetails totBalance = new WPlayersDetails(playerId, total, name);
        wPlayersDetailsService.saveOrUpdate(totBalance); //updating Player Detail table for TOTAL
        WPlayersTransaction result = new WPlayersTransaction(playerId, name, transType, transId, amt);
        System.out.println("result----" + result);

        return result;


    }

    public void saveOrUpdate(WPlayersTransaction Player)//change name
    {
        if (repository.existsById(Player.getTransId())) {
            throw new EntityExistsException("Transaction Already Exist");
        }

        repository.save(Player);
    }

    public WPlayersTransaction getBalBy(int checkAccNo) {
        return repository.findById(checkAccNo).get();
    }
}

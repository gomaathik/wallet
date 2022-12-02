package com.walletms.wallet.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.walletms.wallet.model.WPlayersDetails;
import com.walletms.wallet.repository.WPlayersDetailsRepository;

@Service
public class WPlayersDetailsService {
    @Autowired
    WPlayersDetailsRepository repository;
    public WPlayersDetails getPlayerById(int playerId) {
       return repository.findById(playerId).get();
    }

    public WPlayersDetails getBalanceByPlayerId(int playerId) {
        return repository.findById(playerId).get();
    }

    public List<WPlayersDetails> getPlayer(int a){
        List<WPlayersDetails> Players =new ArrayList<WPlayersDetails>();
        repository.findAll().forEach(Player-> Players.add(Player));
        return Players;
    }
public List<WPlayersDetails> getAllPlayers(){
        List<WPlayersDetails> Players = new ArrayList<WPlayersDetails>();
        repository.findAll().forEach(Player -> Players.add(Player));
        return Players;
    }
    public void saveOrUpdate(WPlayersDetails Player) {
        repository.save(Player);
    }
}

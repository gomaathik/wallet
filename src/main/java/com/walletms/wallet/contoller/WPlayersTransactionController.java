package com.walletms.wallet.contoller;

import com.walletms.wallet.model.WPlayerTransInfo;
import com.walletms.wallet.model.WPlayersDetails;
import com.walletms.wallet.model.WPlayersTransaction;
import com.walletms.wallet.service.WPlayersDetailsService;
import com.walletms.wallet.service.WPlayersTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityExistsException;
import java.util.List;

@RestController
@RequestMapping(path = "/wallet")
public class WPlayersTransactionController {
    @Autowired
    WPlayersTransactionService wPlayersTransactionService;
    @Autowired
    WPlayersDetailsService wPlayersDetailsService;
    private Object ArrayList;

    //getting all player with current balance (playerId, player, balance)
    @GetMapping("/allPlayerTransaction")
    public List<WPlayersDetails> getAllPlayers() {
        return wPlayersDetailsService.getAllPlayers();
    }

    // Getting transaction History of Per Player
    @GetMapping("/transaction/{playerId}")
    public List<WPlayersTransaction> getTrans(@PathVariable("playerId") int playerId) {
       return wPlayersTransactionService.getAllTrans(playerId);
           }

    //for update the transaction database for all the players
    @PostMapping("/transaction")
    public void addTransaction(@RequestBody WPlayerTransInfo Player) {
        try {
            WPlayersTransaction wPlayersTransaction = wPlayersTransactionService.processTransaction(Player);
            wPlayersTransactionService.saveOrUpdate(wPlayersTransaction);
        } catch (EntityExistsException exc) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, exc.getMessage(), exc);
        }
    }
}

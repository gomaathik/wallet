package com.walletms.wallet.contoller;

import com.walletms.wallet.model.WPlayersDetails;
import com.walletms.wallet.service.WPlayersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/wallet")
public class WPlayersDetailsController {
    @Autowired
    WPlayersDetailsService wPlayersDetailsService;

    @GetMapping("/player/{playerId}")//Current Balance Per Player
    public WPlayersDetails getBalanceByPlayerId(@PathVariable("playerId") int playerId) {
        return wPlayersDetailsService.getBalanceByPlayerId(playerId);
    }


}
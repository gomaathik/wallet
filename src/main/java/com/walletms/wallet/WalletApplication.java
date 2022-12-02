package com.walletms.wallet;

import com.walletms.wallet.model.WPlayersDetails;
import com.walletms.wallet.repository.WPlayersDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class WalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }
}

@Component
class StaticPlayerDatabaseLoader implements CommandLineRunner {
    @Autowired
    private WPlayersDetailsRepository detailsRepository;

    @Override
    public void run(String... args) throws Exception {
        WPlayersDetails player1 = new WPlayersDetails();
        player1.setPlayerId(112231);
        player1.setPlayer("Jack");
        player1.setBalance(2000);
        detailsRepository.save(player1);

        WPlayersDetails player2 = new WPlayersDetails();
        player2.setPlayerId(112232);
        player2.setPlayer("John");
        player2.setBalance(2300);
        detailsRepository.save(player2);

        WPlayersDetails player3 = new WPlayersDetails();
        player3.setPlayerId(112233);
        player3.setPlayer("Julie");
        player3.setBalance(2800);
        detailsRepository.save(player3);

        WPlayersDetails player4 = new WPlayersDetails();
        player4.setPlayerId(112234);
        player4.setPlayer("John");
        player4.setBalance(3000);
        detailsRepository.save(player4);
    }
}
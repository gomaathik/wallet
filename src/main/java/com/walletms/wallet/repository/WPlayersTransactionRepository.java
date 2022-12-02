package com.walletms.wallet.repository;

import com.walletms.wallet.model.WPlayersTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WPlayersTransactionRepository extends CrudRepository<WPlayersTransaction, Integer> {
     List<WPlayersTransaction> findAllByPlayerId(int playerId);

}

package com.walletms.wallet.repository;

import com.walletms.wallet.model.WPlayersDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WPlayersDetailsRepository extends CrudRepository<WPlayersDetails, Integer> {
}

package com.walletms.wallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.walletms.wallet.model.WPlayersDetails;

@Repository
public interface WPlayersDetailsRepository extends CrudRepository<WPlayersDetails, Integer>  {
}

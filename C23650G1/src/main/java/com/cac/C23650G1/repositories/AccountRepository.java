package com.cac.C23650G1.repositories;

import com.cac.C23650G1.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByAlias(String alias);
    boolean existsByAccountNumber (String accountNumber);

}

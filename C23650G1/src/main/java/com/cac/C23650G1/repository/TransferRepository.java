package com.cac.C23650G1.repository;

import com.cac.C23650G1.entities.Transfer;
import com.cac.C23650G1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}

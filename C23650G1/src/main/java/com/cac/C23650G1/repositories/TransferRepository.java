package com.cac.C23650G1.repositories;

import com.cac.C23650G1.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository <Transfer, Long> {
}

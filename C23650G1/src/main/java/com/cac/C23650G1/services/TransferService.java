package com.cac.C23650G1.services;

import com.cac.C23650G1.entities.Transfer;
import com.cac.C23650G1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public List<Transfer> getTransfers(){
        List <Transfer> transfers = transferRepository.findAll();
        return transfers;
    }

    public Transfer getTransferById(Long id){
        Transfer transfer = transferRepository.findById(id).get();
        return (transfer);
    }

    public String deleteTransferById(Long id){
        if (transferRepository.existsById(id)){
            transferRepository.deleteById(id);
            return "La transferencia " + id + " ha sido eliminada";
        }

        return "La transferencia " + id + " no ha sido eliminada";
    }

    public Transfer addTransfer (Transfer newTransfer) {
        return newTransfer;
    }
}

package com.cac.C23650G1.services;

import com.cac.C23650G1.entities.Account;
import com.cac.C23650G1.entities.Transfer;
import com.cac.C23650G1.entities.dtos.TransferDto;
import com.cac.C23650G1.entities.enums.AccountType;
import com.cac.C23650G1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransferService {

    @Autowired
    private final TransferRepository transferRepository;

    @Autowired
    private final AccountRepository accountRepository;

    public TransferService(TransferRepository transferRepository, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    //Obtener una lista de todas las transferencias
    public List<Transfer> getTransfers(){
        return transferRepository.findAll();

    }

    //Obtener una sola transferencia por su ID
    public ResponseEntity<?> getTransferById(Long id){
        return transferRepository.findById(id)
                .map(transfer -> ResponseEntity.ok(transfer))  // Usuario encontrado
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Transfer(id,null, null, null, null )));
    }

    //Eliminar una sola transferencia por su ID
    public String deleteTransferById(Long id){
        if (transferRepository.existsById(id)){
            transferRepository.deleteById(id);
            return "La transferencia " + id + " ha sido eliminada";
        }

        return "La transferencia " + id + " no ha sido eliminada";
    }

    //Crear una sola transferencia
    public ResponseEntity<?> createTransfer (TransferDto newTransfer) {
        Transfer transfer = new Transfer();
        String errorMessage;

        if(isAccountExists(newTransfer.getIdAccountSender()) && isAccountExists(newTransfer.getIdAccountRecipient())) { //Validamos que existan las dos cuentas
            if(checkAccountCompatibility(newTransfer.getIdAccountSender(), newTransfer.getIdAccountRecipient())) { //Verificamos que los tipos de cuenta sean compatibles
                if(hasSufficientFunds(newTransfer.getIdAccountSender(), newTransfer.getAmount())) { //Verificamos si la cuenta emisora tiene fondos suficientes
                    Account senderAccount = accountRepository.findById(newTransfer.getIdAccountSender()).get();
                    Account recipientAccount = accountRepository.findById(newTransfer.getIdAccountRecipient()).get();

                    senderAccount.setAmount(senderAccount.getAmount().subtract(newTransfer.getAmount()));
                    recipientAccount.setAmount(recipientAccount.getAmount().add(newTransfer.getAmount()));

                    accountRepository.save(senderAccount);
                    accountRepository.save(recipientAccount);

                    transfer.setIdAccountRecipient(newTransfer.getIdAccountRecipient());
                    transfer.setIdAccountSender(newTransfer.getIdAccountSender());
                    transfer.setAmount(newTransfer.getAmount());
                    transfer.setDate(LocalDate.now());

                    transfer = transferRepository.save(transfer);

                    return ResponseEntity.ok(transfer);
                } else {
                    errorMessage = "La cuenta emisora no tiene los fondos suficientes";
                }
            } else {
                errorMessage = "El tipo de cuenta emisora y el tipo de cuenta receptora no son compatibles";
            }
        }
        else {
            errorMessage = "Una de las cuentas (o las dos) no existen";
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    public boolean isAccountExists(Long idAccount) {
        return accountRepository.existsById(idAccount);
    }

    public boolean checkAccountCompatibility(Long idAccountSender, Long idAccountRecipient) {
        boolean check = false;

        AccountType accountTypeSender = accountRepository.findById(idAccountSender).get().getType();
        AccountType accountTypeRecipient = accountRepository.findById(idAccountRecipient).get().getType();

        if(accountTypeSender.equals(AccountType.CAJA_AHORRO_DOLAR)) { //La cuenta que envía dinero es CAJA DE AHORRO EN DOLARES
            if(accountTypeRecipient.equals(AccountType.CAJA_AHORRO_DOLAR)) { //La cuenta que recibe dinero es CAJA DE AHORRO EN DOLARES
                check = true;
            }
        } else { //La cuenta que envía dinero es EN PESOS
            if(! accountTypeRecipient.equals(AccountType.CAJA_AHORRO_DOLAR)) { //La cuenta que recibe NO ES CAJA DE AHORRO EN DOLARES
                check = true;
            }
        }
        return check;
    }

    public boolean hasSufficientFunds (Long idAccountSender, BigDecimal amount) {
        return accountRepository.findById(idAccountSender).get().getAmount().compareTo(amount) >= 0;
    }
}

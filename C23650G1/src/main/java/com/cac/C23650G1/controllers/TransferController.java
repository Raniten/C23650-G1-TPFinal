package com.cac.C23650G1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    //OBTENER la lista de TODAS las transferencias (GET)
    @GetMapping
    public List<Transfer> getTransfers() {
        return transferService.getTransfers();

    }

    //OBTENER UNA SOLA trasnferencia por su ID (GET)
    @GetMapping(value="/{id}")
    public Transfer getTransferById(@PathVariable Long id) {
        return transferService.getTransferById(id);
    }

    // ELIMINAR UNA SOLA transferencia (DELETE)
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteTransferById(@PathVariable Long id) {
        transferService.deleteTransferById(id);
        return ResponseEntity.noContent().build();
    }

    //CREAR UN SOLO usario (POST)
    @PostMapping
    public Transfer createTransfer(@RequestBody TransferDto newTransfer) {

        return transferService.addTransfer(newTransfer);
    }
}

package com.cac.C23650G1.controllers;

import com.cac.C23650G1.entities.Transfer;
import com.cac.C23650G1.entities.dtos.TransferDto;
import com.cac.C23650G1.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<List<Transfer>> getTransfers() {
        return ResponseEntity.status(HttpStatus.OK).body(transferService.getTransfers());

    }

    //OBTENER UNA SOLA trasnferencia por su ID (GET)
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getTransferById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(transferService.getTransferById(id));
    }

    // ELIMINAR UNA SOLA transferencia (DELETE)
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteTransferById(@PathVariable Long id) {
        transferService.deleteTransferById(id);
        return ResponseEntity.noContent().build();
    }

    //CREAR UNA SOLA transferencia (POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTransfer(@RequestBody TransferDto newTransfer) {

        return ResponseEntity.status(HttpStatus.OK).body(transferService.createTransfer(newTransfer));
    }
}

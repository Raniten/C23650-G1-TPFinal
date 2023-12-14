package com.cac.C23650G1.entities;

import com.cac.C23650G1.entities.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "accounts")
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo-cuenta")
    private AccountType type;

    private String cbu;
    private String alias;
    @Column(name = "saldo-cuenta")
    private BigDecimal amount;
    @Column(name = "fecha-creaccion")
    private LocalDateTime createdAm ;
    @Column(name = "fecha-actualizacion")
    private LocalDateTime updatedAm;

    //cuando hagamos la relacion entre entities esta sera la FK
    //private owner;



}

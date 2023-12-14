package com.cac.C23650G1.entities;


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
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "monto")
    private BigDecimal amount;
    @Column(name = "cuenta-origen")
    private Account originAccount;
    @Column(name = "cuenta-destino")
    private Account destinyAccount;
    @Column(name = "fecha-transferencia")
    private LocalDateTime dateTransfer;

}

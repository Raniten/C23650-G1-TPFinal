package com.cac.C23650G1.entities;


import com.cac.C23650G1.entities.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // definimos account como una entidad
@Table(name = "cuentas") // creamos una tabla en la BBD con numbre cuentas
@Getter
@Setter
@AllArgsConstructor // creamos el constructos sobrecargado
@NoArgsConstructor  // creamos el constructor vacio
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAccount")
public class Account {

    @Id //numero unico de identificacion (clave primaria)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // con IDENTITY la base de datos gestione la generación de valores para la clave primaria
    private long idAccount; // numero de identificacion unico

    @Column(name = "activa")
    private boolean isActive; // booleano para indicar si la cuenta esta activa

    @Column(name = "tipo_cuenta")
    private AccountType type; // tipo de cuenta 1 de 4

    // private String moneda; // pesos o dolares  >> lo podemos saber  con el tipo de cuenta

    private String accountNumber;
    private String cbu;  // numero al cual se hacen las transferencias
    private String alias; // 3 palabras que identifican la cuenta

    @Column(name = "monto")
    private BigDecimal amount; // dinero en la cuenta

    @Column(name = "fecha_creacion")
    private LocalDateTime created_account;

    @Column(name = "fecha_modificacion")
    private LocalDateTime updated_account;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

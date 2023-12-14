package com.cac.C23650G1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "homebanking_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String dni;

    private String email;

    private String address;

    @Column(name = "fecha_nacimiento")
    private Date birthday_date;

    @Column(name = "fecha_creacion")
    private LocalDateTime created_at;

    @Column(name = "fecha_modificacion")
    private LocalDateTime updated_at;

   @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Account> accounts;


}



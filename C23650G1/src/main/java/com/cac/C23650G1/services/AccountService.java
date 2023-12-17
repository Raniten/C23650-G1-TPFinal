package com.cac.C23650G1.services;

import com.cac.C23650G1.entities.Account;
import com.cac.C23650G1.entities.dtos.AccountDto;
import com.cac.C23650G1.mappers.AccountMapper;
import com.cac.C23650G1.repositories.AccountRepository;
import com.cac.C23650G1.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cac.C23650G1.exception.EntityNotFoundException;
import com.cac.C23650G1.exception.IllegalArgumentException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final UserRepository userRepository;

    private AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public AccountDto getAccountById(Long id) {
        Account acc = accountRepository.findById(id).get();
        return AccountMapper.accountToDto(acc);
    }

    public List<AccountDto> getAccounts() {
        return accountRepository.findAll().stream()
                .map(AccountMapper::accountToDto)
                .collect(Collectors.toList());
    }

    public AccountDto createAccount(AccountDto newAccountDto) {
        if (!userRepository.existsById(newAccountDto.getIdUser())) {
            throw new EntityNotFoundException(
                    "No existe el usuario con id " + newAccountDto.getIdUser() + " en la base de datos");
        }
        newAccountDto.setAlias(generateRandomAlias());
        while (accountRepository.existsByAlias(newAccountDto.getAlias())) {
            newAccountDto.setAlias(generateRandomAlias());
        }

        // Generamos un número de cuenta, si existe en la base de datos, seguimos
        // generando hasta que sea único
        newAccountDto.setAccountNumber(generateRandomDigits(10));

        while (accountRepository.existsByAccountNumber(newAccountDto.getAccountNumber())) {
            newAccountDto.setAccountNumber(generateRandomDigits(10));
        }

        // Generamos un CBU aleatorio incluyendo el numero de cuenta generado
        newAccountDto.setCbu(
                "23650" + generateRandomDigits(15) + newAccountDto.getAccountNumber() + generateRandomDigits(1));

        newAccountDto.setIdAccount(0L);
        newAccountDto.setCreated_account(LocalDateTime.now());
        newAccountDto.setUpdated_account(LocalDateTime.now());

        Account newAccount = AccountMapper.dtoToAccount(newAccountDto);
        newAccount.setUser(userRepository.findById(newAccountDto.getIdUser()).get());
        accountRepository.save(newAccount);
        return AccountMapper.accountToDto(accountRepository.save(newAccount));
    }

    public AccountDto inactiveAccount(Long id, AccountDto dto) {
        if (accountRepository.existsById(id)) {
            Account acc = accountRepository.findById(id).get();

            if (dto.isActive()) {
                acc.setActive(false);
            }

            return AccountMapper.accountToDto(acc);
        } else {
            return null;
        }
    }

    public AccountDto activeAccount(Long id, AccountDto dto) {
        if (accountRepository.existsById(id)) {
            Account acc = accountRepository.findById(id).get();

            if (!dto.isActive()) {
                acc.setActive(true);
            }

            return AccountMapper.accountToDto(acc);
        } else {
            return null;
        }
    }

    public AccountDto updateAccount(Long id, AccountDto dto) {
        if (accountRepository.existsById(id)) {
            Account acc = accountRepository.findById(id).get();

            if (dto.getAlias() != null) {
                acc.setAlias(dto.getAlias());
            }

            if (dto.getType() != null) {
                acc.setType(dto.getType());
            }

            if (dto.getCbu() != null) {
                acc.setCbu(dto.getCbu());
            }

            if (dto.getAmount() != null) {
                acc.setAmount(dto.getAmount());
            }

            return AccountMapper.accountToDto(acc);

        } else {
            return null;
        }
    }

    public String deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return "Cuenta eliminada";
        } else {
            return "No se pudo eliminar la cuenta";
        }
    }

    public String updateAlias(String id, String alias) {
        // NOTE: Ejemplo de excepción funcionando.
        if (alias == null || alias.isEmpty()) {
            throw new IllegalArgumentException("El alias no puede ser nulo o vacío");
        }
        return "updateAlias" + id + " " + alias;
    }

    public String generateRandomAlias() {
        String[] words = { "manzana", "gato", "sol", "casa", "rojo", "agua", "luz", "tierra", "mar", "hoja",
                "perro", "azul", "noche", "flor", "nieve", "nube", "viento", "planta", "libro", "cielo",
                "guitarra", "café", "montaña", "ciudad", "pájaro", "diente", "fruta", "delfín", "luna", "puente",
                "río", "ojo", "estrella", "naranja", "piedra", "camino", "ventana", "música", "cuerpo", "playa",
                "árbol", "corazón", "caracol", "tren", "elefante", "nube", "lápiz", "pintura", "camisa", "silla" };
        Random random = new Random();

        // Elegir tres palabras aleatorias

        return words[random.nextInt(words.length)] + "." +
                words[random.nextInt(words.length)] + "." +
                words[random.nextInt(words.length)];
    }

    public String generateRandomDigits(int length) {
        if (length <= 0) {
            throw new java.lang.IllegalArgumentException("La longitud debe ser mayor que cero.");
        }

        Random random = new Random();
        // Generar una secuencia de dígitos aleatorios y convertirla en un String
        String randomDigits = random.ints(length, 0, 10) // Dígitos del 0 al 9
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());

        return randomDigits;
    }

}

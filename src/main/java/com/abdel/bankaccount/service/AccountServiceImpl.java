package com.abdel.bankaccount.service;

import com.abdel.bankaccount.dto.BankAccountRequestDTO;
import com.abdel.bankaccount.dto.BankAccountResponseDTO;
import com.abdel.bankaccount.entities.BankAccount;
import com.abdel.bankaccount.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;

//    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
//        this.bankAccountRepository = bankAccountRepository;
//    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder()
                .id(savedBankAccount.getId())
                .createdAt(savedBankAccount.getCreatedAt())
                .balance(savedBankAccount.getBalance())
                .currency(savedBankAccount.getCurrency())
                .type(savedBankAccount.getType())
                .build();
        return bankAccountResponseDTO;
    }
}

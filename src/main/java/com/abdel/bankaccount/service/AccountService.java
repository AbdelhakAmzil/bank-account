package com.abdel.bankaccount.service;

import com.abdel.bankaccount.dto.BankAccountRequestDTO;
import com.abdel.bankaccount.dto.BankAccountResponseDTO;
import com.abdel.bankaccount.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
}

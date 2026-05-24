package com.abdel.bankaccount.repositories;

import com.abdel.bankaccount.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}

package com.PayMyBudy.service;

import com.PayMyBudy.model.Account;
import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.AccountRepository;
import com.PayMyBudy.repository.TransferRepository;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.TransferForm;
import com.PayMyBudy.service.form.TransferToAccountForm;
import com.PayMyBudy.service.form.TransferToBankForm;
import org.hibernate.id.ForeignGenerator;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.security.Security;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferService {

    private final UserRepository userRepository;
    private final TransferRepository transferRepository;
    private  final AccountRepository accountRepository;

    public TransferService(UserRepository userRepository, TransferRepository transferRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    public List<Transfer>findTransactions() {
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email not found"));
        return transferRepository.findTransferByUserId(connectedUser.getId());

    }

    public User findAccount(){
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email  not found"));


    }

    public void transfer(TransferForm form) {
        if (form != null) {
            org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                    .orElseThrow(() -> new RuntimeException("user with email  not found"));
            User to = userRepository.findUserByMail(form.getTo())
                    .orElseThrow(() -> new RuntimeException("user with email  not found"));
            Transfer transfer = new Transfer();
            transfer.setDate(LocalDateTime.now());
            transfer.setAmountBeforeFee(form.getAmount());
            transfer.setAmountAfterFee(form.getAmount() - form.getAmount() * 0.005);
            transfer.setFrom(connectedUser);
            transfer.setTo(to);


            accountRepository.save(connectedUser.getAccount().minus(transfer.getAmountBeforeFee()));
            accountRepository.save(to.getAccount().plus(transfer.getAmountAfterFee()));
            transferRepository.save(transfer);


        } else {

        }
    }
/*
    public List<Transfer>transfer() {
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email not found"));
        return transferRepository.

    } */



    public String findIban() {
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email not found"));
        Account account = accountRepository.findAccountByUserId(connectedUser.getId());
        return account.getIban();

    }

    public void transferToBank(TransferToBankForm form) {
        if (form != null) {
            org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                    .orElseThrow(() -> new RuntimeException("user with email not found"));
            accountRepository.save(connectedUser.getAccount().minus(form.getAmount()));
        } else {

        }
    }


    public void transferToAccount(TransferToAccountForm form) {
        if (form != null) {
            org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                    .orElseThrow(() -> new RuntimeException("user with email not found"));
            accountRepository.save(connectedUser.getAccount().plus(form.getAmount()));
        } else {

        }
     }

}

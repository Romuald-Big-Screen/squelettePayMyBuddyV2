package com.PayMyBudy.webApp.controller;



import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import com.PayMyBudy.service.ConnectionService;
import com.PayMyBudy.service.TransferService;
import com.PayMyBudy.service.UserService;
import com.PayMyBudy.service.form.TransferForm;
import com.PayMyBudy.service.form.TransferToAccountForm;
import com.PayMyBudy.service.form.TransferToBankForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class TransferController {

    private final TransferService transferService;
    private final ConnectionService connectionService;
    private final UserService userService;

    public TransferController(TransferService transferService, ConnectionService connectionService, UserService userService) {
        this.transferService = transferService;
        this.connectionService = connectionService;
        this.userService = userService;
    }

    @PostMapping("transfer")
    public ModelAndView transfer(Model model, @ModelAttribute("transferForm") TransferForm form) {
        transferService.transfer(form);
        List<String> contacts = connectionService.findConnectionsEmail();
        List<Transfer> transactions = transferService.findTransactions();
        model.addAttribute("connections", contacts);
        model.addAttribute("transfers", transactions);
        return new ModelAndView("transfer","tranferForm", new TransferForm());
    }

    @GetMapping("transfer")
    public ModelAndView transfer(Model model) {
        List<String> contacts = connectionService.findConnectionsEmail();
        List<Transfer> transactions = transferService.findTransactions();
        model.addAttribute("connections",contacts);
        model.addAttribute("transfers", transactions);
        return new ModelAndView("transfer","transferForm", new TransferForm());
    }
    @GetMapping("transfer-to-bank")
    public ModelAndView transferToBank(Model model) {
        String iban = transferService.findIban();
        User account = userService.findAccount();
        model.addAttribute("account", account);
        model.addAttribute("iban", iban);
        return new ModelAndView("transfer-to-bank", "transferToBankForm", new TransferToBankForm());
    }
    @PostMapping("transfer-to-bank")
    public ModelAndView transferCashToBank(Model model, @ModelAttribute("transferToBankForm") TransferToBankForm form) {
        transferService.transferToBank(form);
        String iban = transferService.findIban();
        User account = userService.findAccount();
        model.addAttribute("account", account);
        model.addAttribute("iban", iban);
        return new ModelAndView("transfer-to-bank", "transferToBankForm", new TransferToBankForm());
    }
    @GetMapping("transfer-to-account")
    public ModelAndView transferToaccount(Model model) {
        return new ModelAndView("transfer-to-account", "transferToAccountForm", new TransferToAccountForm());
    }
    @PostMapping("transfer-to-account")
    public ModelAndView transferCashToAccount(Model model, @ModelAttribute("transferToAccountForm") TransferToAccountForm form) {
        transferService.transferToAccount(form);

        return new ModelAndView("transfer-to- account", "transferToAccountForm", new TransferToAccount());
    }

}

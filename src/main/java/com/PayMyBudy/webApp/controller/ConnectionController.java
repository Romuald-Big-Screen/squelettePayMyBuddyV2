package com.PayMyBudy.webApp.controller;

import com.PayMyBudy.service.ConnectionService;
import com.PayMyBudy.service.form.AddConnectionForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("connection")
public class ConnectionController {
    private final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @GetMapping()
    public ModelAndView getAddConnectionForm(Model model) {
        return new ModelAndView("add-connection", "addConnectionForm", new AddConnectionForm());
    }
    @PostMapping()
    public ModelAndView addConnection(@ModelAttribute("addConnectionForm") AddConnectionForm form) {
        connectionService.addConnection(form);
        return new ModelAndView("add-connection", "addConnectionForm", new AddConnectionForm());
    }
}

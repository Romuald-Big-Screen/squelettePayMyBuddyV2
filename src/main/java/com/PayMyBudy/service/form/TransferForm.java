package com.PayMyBudy.service.form;

import lombok.Data;

@Data
public class TransferForm {
    private Double amount;
    private String connection;
    private String To;
}

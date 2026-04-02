package com.acmebank.bankingapi.model;

public record TransferRequest(String fromAccountId, String toAccountId, double amount) {
}

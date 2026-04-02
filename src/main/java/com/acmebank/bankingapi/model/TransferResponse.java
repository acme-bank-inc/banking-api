package com.acmebank.bankingapi.model;

public record TransferResponse(String transactionId, String status, String fromAccountId,
                                String toAccountId, double amount) {
}

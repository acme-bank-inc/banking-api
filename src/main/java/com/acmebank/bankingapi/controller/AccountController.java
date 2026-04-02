package com.acmebank.bankingapi.controller;

import com.acmebank.bankingapi.model.Account;
import com.acmebank.bankingapi.model.TransferRequest;
import com.acmebank.bankingapi.model.TransferResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountController {

    private static final List<Account> ACCOUNTS = List.of(
            new Account("ACC001", "Alice Johnson", "checking", 5200.75),
            new Account("ACC002", "Bob Smith", "savings", 18430.00),
            new Account("ACC003", "Carol Davis", "checking", 920.50)
    );

    private static final Map<String, Account> ACCOUNT_MAP = ACCOUNTS.stream()
            .collect(Collectors.toMap(Account::id, Function.identity()));

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return ACCOUNTS;
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable String id) {
        Account account = ACCOUNT_MAP.get(id);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @PostMapping("/transfers")
    public ResponseEntity<TransferResponse> createTransfer(@RequestBody TransferRequest request) {
        if (!ACCOUNT_MAP.containsKey(request.fromAccountId()) || !ACCOUNT_MAP.containsKey(request.toAccountId())) {
            return ResponseEntity.badRequest().build();
        }
        TransferResponse response = new TransferResponse(
                UUID.randomUUID().toString(),
                "completed",
                request.fromAccountId(),
                request.toAccountId(),
                request.amount()
        );
        return ResponseEntity.ok(response);
    }
}

# Banking API

Core banking REST API for Acme Bank Inc. This is a fictional test application used for ETM ASMP testing scenarios.

## What It Does

Provides a minimal set of banking endpoints that return hardcoded data. No database or external dependencies are required.

### Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | /api/accounts | List all accounts |
| GET | /api/accounts/{id} | Get a single account by ID |
| POST | /api/transfers | Create a fund transfer between accounts |

### Sample Account IDs

- ACC001 (Alice Johnson, checking)
- ACC002 (Bob Smith, savings)
- ACC003 (Carol Davis, checking)

## Prerequisites

- Java 17 or later

## How to Run

```bash
make build
make run
```

The API starts on port 8080.

## Available Make Targets

| Target | Description |
|--------|-------------|
| `make build` | Compile and package the application |
| `make run` | Start the application |
| `make test` | Run tests |
| `make clean` | Remove build artifacts |

## Example Requests

```bash
# List accounts
curl http://localhost:8080/api/accounts

# Get single account
curl http://localhost:8080/api/accounts/ACC001

# Transfer funds
curl -X POST http://localhost:8080/api/transfers \
  -H "Content-Type: application/json" \
  -d '{"fromAccountId":"ACC001","toAccountId":"ACC002","amount":100.00}'
```

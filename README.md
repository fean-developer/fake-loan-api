# Fake Loan API

API de simulação e gerenciamento de empréstimos, contas e usuários, desenvolvida em Java com Spring Boot e MongoDB.

## Funcionalidades
- Simulação de empréstimos
- Aprovação e rejeição de empréstimos
- Gerenciamento de contas bancárias
- Cadastro e consulta de usuários

## Endpoints principais

### Empréstimos (`/loans`)
- `POST /loans/simulate` — Simula um empréstimo
- `POST /loans/{id}/approve` — Aprova um empréstimo
- `POST /loans/{id}/reject` — Rejeita um empréstimo

### Contas (`/accounts`)
- `POST /accounts` — Cria uma conta para um usuário
- `GET /accounts/{id}` — Consulta uma conta por ID
- `POST /accounts/save` — Salva/atualiza uma conta

### Usuários (`/users`)
- `GET /users` — Lista todos os usuários
- `GET /users/{id}` — Consulta um usuário por ID
- `POST /users` — Cria um novo usuário

## Como rodar o projeto

1. **Pré-requisitos:**
   - Java 17+
   - Maven
   - MongoDB

2. **Configuração:**
   - Configure o `application.yml` com as credenciais do MongoDB.

3. **Build e execução:**
   ```sh
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

4. **Acesso:**
   - A API estará disponível em `http://localhost:8080`

## Estrutura do Projeto
- `model/` — Entidades do domínio
- `repository/` — Interfaces de acesso a dados
- `services/` — Lógica de negócio
- `controllers/` — Endpoints REST

## Observações
- Este projeto é um POC (prova de conceito) e pode ser expandido conforme a necessidade.
- Para testar os endpoints, utilize ferramentas como Postman ou Insomnia.

---

Desenvolvido por Hero-offers — 2025

# Sistema de Processamento de Pedidos

Este projeto implementa um sistema de pedidos para uma loja virtual, aplicando diferentes estratégias de controle de concorrência para gerenciar o estoque de produtos durante eventos de alta demanda, como a Black Friday.

## 📌 Funcionalidades
- **Processamento de pedidos sem controle de concorrência** (`/pedido/novo`)
- **Processamento de pedidos com Lock Otimista** (`/pedido_otimista/novo`)
- **Processamento de pedidos com Lock Pessimista** (`/pedido_pessimista/novo`)
- **Gerenciamento de produtos e estoque**
- **Registro de logs para monitoramento**

## 🛠 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database (para testes) / PostgreSQL (produção)**
- **Maven**

## 📂 Estrutura do Projeto
```
├── src/main/java/com/iftm/edu/br/vini_iftm
│   ├── docs        # Log do projeto
│   ├── controller  # Endpoints REST
│   ├── model       # Entidades do banco de dados
│   ├── repository  # Interfaces JPA
│   ├── service     # Lógica de negócios
│   ├── log         # Logs de execução
└── docs            # Documentação e relatórios de desempenho
```

## 🔧 Configuração e Execução
### Requisitos:
- **Java 17+**
- **Maven**
- **Banco de Dados (H2/PostgreSQL)**

Os resultados, incluindo tempo médio de resposta e taxa de erro, podem ser encontrados na pasta `docs`.

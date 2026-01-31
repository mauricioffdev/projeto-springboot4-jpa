# Workshop Spring Boot & JPA

Projeto desenvolvido durante o curso de Java Completo, do professor Nélio Alves, atualizado para as tecnologias mais recentes do mercado. Trata-se de uma API RESTful para gerenciamento de pedidos, usuários, categorias e produtos.

**Acesse a API online (Live Demo):** [https://projeto-springboot4-jpa.onrender.com/users](https://projeto-springboot4-jpa.onrender.com/users)
*(Nota: Como está no plano gratuito, a primeira requisição pode levar cerca de 1 minuto para "acordar" o servidor).*

## Tecnologias Utilizadas

- **Java 21/25** (Atualizado)
- **Spring Boot 4** (Migração da versão 2)
- **Spring Data JPA** & **Hibernate**
- **PostgreSQL** (Banco de Produção)
- **H2 Database** (Banco de Teste em memória)
- **Docker** (Containerização para Deploy)
- **Maven** (Gerenciamento de dependências)

## Desafios e Aprendizados

Este projeto foi além do código básico. Durante o desenvolvimento, foram implementadas soluções para cenários reais:
- Tratamento de exceções personalizado (Database & Resource Not Found).
- Configuração de **Profiles** (Test vs Prod).
- **Deploy no Render** utilizando Docker (substituindo o Heroku).
- Solução de conflitos de ambiente entre Windows e Linux (CRLF/UTF-8) via Dockerfile.

## Como rodar localmente

1. Clone o repositório:
   ```bash
   git clone [https://github.com/mauricioffdev/projeto-springboot4-jpa.git]  
   
2. Configure o banco de dados no application-test.properties ou use o perfil padrão (H2).  

3. Execute a aplicação via IntelliJ ou Maven: mvn spring-boot:run  
  

   Desenvolvido por Maurício Filadelfo Filho 




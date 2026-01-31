
### 2. O Diário de Bordo (DEPLOY_LOG.md)

# Diário de Deploy: Spring Boot no Render.com

**Data:** 31/01/2026
**Contexto:** O Heroku tornou-se pago. Migramos para o Render (Free Tier) com PostgreSQL.

## 1. Configuração do Projeto (Spring Boot)
- Criamos o arquivo `system.properties` na raiz com `java.runtime.version=21`.
- No `application-prod.properties`, usamos variáveis de ambiente para não vazar senhas:

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}  

2. O Problema do Windows vs Linux (Erro 127 e MalformedInput)
Tivemos problemas ao rodar o mvnw gerado no Windows dentro do container Linux do Render.

Erro 127: O Linux não achava o comando mvnw por causa das quebras de linha (CRLF).

Erro MalformedInput: O Maven falhou ao ler acentos (ç, ã) nos comentários do application.properties.

3. A Solução (Dockerfile + Limpeza)
Optamos por usar Docker para ter controle total do ambiente.

Dockerfile Final: Usamos uma abordagem "Multi-stage":

Imagem Maven oficial (ignora o mvnw local bugado).

Imagem leve (Alpine/Slim) apenas com JRE para rodar.

Removemos todos os acentos dos arquivos de propriedades e Dockerfile.

Forçamos UTF-8 no pom.xml:  
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

Mauricio Filadelfo Filho 
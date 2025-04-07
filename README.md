# Sistema de Reserva de Salas 🏢🗓️

> Este projeto é uma aplicação distribuída composta por três microsserviços: **Usuário**, **Sala** e **Reserva**. Cada serviço possui sua responsabilidade isolada e se comunicam entre si através de REST APIs.

## 🔧 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- PostgreSQL
- Docker e Docker Compose
- Lombok
- OpenFeign (para comunicação entre microsserviços)
- Flyway (migrações de banco de dados)

---

## 📁 Estrutura do Projeto

```bash
/projeto/ 
          ├── docker-compose.yml 
          ├── reserva-usuario/  
            ├── Dockerfile  
            └── src/... 
            ├── reserva-sala/  
              ├── Dockerfile 
              └── src/... 
            ├── reserva-service/  
              ├── Dockerfile  
              └── src/...
```

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Docker
- Docker Compose

### Subindo os serviços

Na raiz do projeto (onde está o `docker-compose.yml`):

```bash
docker-compose up --build
```
### 🌐 Endpoints dos Microsserviços

| Serviço  | Porta | Endpoint Base                                     |
|----------|-------|---------------------------------------------------|
| Usuário  | 8081  | [http://localhost:8081/reserva-sala/usuarios](http://localhost:8081/reserva-sala/usuarios)             |
| Sala     | 8082  | [http://localhost:8082/reserva-sala/salas](http://localhost:8082/reserva-sala/salas)                   |
| Reserva  | 8083  | [http://localhost:8083/reserva-sala/reserva](http://localhost:8083/reserva-sala/reserva) |


### 🛠️ Endpoints Importantes
## Usuário
> GET /reserva-sala/usuarios/{id} → Busca usuário por ID

> POST /reserva-sala//usuarios → Cadastra um novo usuário

## Sala
> GET /reserva-sala/salas/{id} → Busca sala por ID

> POST /reserva-sala/salas → Cadastra uma nova sala

## Reserva
> POST /reserva-sala/reserva → Cadastra uma nova reserva (valida se usuário e sala existem)

### 📦 Banco de Dados
- Cada microsserviço possui seu banco de dados PostgreSQL isolado.

- As tabelas são gerenciadas via Flyway em cada serviço.

### 🧩 Comunicação Entre Microsserviços
- O serviço de reserva-service utiliza OpenFeign para buscar dados do usuario-service e sala-service.

### 📌 TODO
 - Implementar autenticação com JWT
 - Criar testes automatizados
 - Documentar com Swagger e revisar

### 🧑‍💻 Autor
Cesar Pisa - Desenvolvedor backend em evolução 🚀
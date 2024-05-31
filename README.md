# Prática da arquitetura multi tenant

## Técnologias Usadas
- Java 17
- Spring boot 3
- Spring Jpa and Hibernate
- PostgreSQL

## Praticas Usadas
- Arquitetura MVC
- Estrutura de camadas
- Migrations com Flyway

## Como rodar o projeto

Rode um banco postgres e mude [nesse arquivo](./src/main/resources/application.yml) as propriedades com os dados do seu banco

Apos configurar o banco entre na pasta onde foi clonado o projeto e rode o comando abaixo no terminal:
```bash
  ./gradlew bootRun
```

## Endpoints

### GET users

/v1/users

request header: 

- TENANT: [nome-do-schema] (header opcional se não mandar ele por padrão usa o schema public)
  esse header serve pra fazer a troca de tenant 


retorno:
```json
[
  {
    "id": 1,
    "name": "PUBLICO"
  },
  {
    "id": 1,
    "name": "PUBLICO"
  }
]
```

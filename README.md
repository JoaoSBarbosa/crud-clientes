![GitHub top language](https://img.shields.io/github/languages/top/JoaoSBarbosa/crud-clientes)



# CRUD de Clientes ☕

Este projeto implementa um CRUD (Create, Read, Update, Delete) para gerenciar clientes. Ele inclui diversas camadas, como service, entity, dto, controller e repository para manter uma estrutura organizada. Abaixo são listadas as funcionalidades principais do projeto:

## Funcionalidades

1. **Listar todos os clientes paginados:** Endpoint para recuperar uma lista paginada de todos os clientes cadastrados.
2. **Listar cliente por ID:** Endpoint para obter os detalhes de um cliente específico a partir do seu ID.
3. **Inserir novo cliente:** Endpoint para adicionar um novo cliente ao banco de dados.
4. **Atualizar cliente:** Endpoint para atualizar os dados de um cliente existente.
5. **Deletar cliente:** Endpoint para remover um cliente do banco de dados.

## Estrutura do Projeto

O projeto está dividido em diferentes camadas:

- **Entity:** Contém a classe `Client` que representa a entidade Cliente.
- **DTO:** Contém os objetos de transferência de dados para facilitar a comunicação entre as camadas.
- **Service:** Responsável pela lógica de negócio e intermediação entre o Controller e o Repository.
- **Controller:** Gerencia as requisições HTTP, processa os dados e interage com o Service.
- **Repository:** Realiza operações de persistência de dados no banco de dados.

## Como Usar

Para executar o projeto localmente, siga os passos abaixo:

1. Clone o repositório em sua máquina local.

   ```
   git clone https://github.com/JoaoSBarbosa/crud-clientes.git
   ```

2. Importe o projeto em sua IDE preferida.

3. Configure um banco de dados conforme as configurações definidas no arquivo `application.properties`.

4. Execute o aplicativo.

5. Acesse os endpoints utilizando um cliente de API (como Postman ou Insomnia) ou utilize uma interface de usuário, se houver.

## Testes

1. #### POST

   ![Post client](/src/main/resources/public/img/insert.png)

2. #### GET - BY ID

   ![Post client](/src/main/resources/public/img/getById.png)

3. GET- Page

   ![Post client](/src/main/resources/public/img/pages.png)

4. PUT - Update

   ![Post client](/src/main/resources/public/img/put.png)

5. DELETE

   ![Post client](/src/main/resources/public/img/delete.png)

## Tecnologias Utilizadas



- Java
- Spring Boot
- Hibernate
- H2 Database (para ambiente de desenvolvimento)

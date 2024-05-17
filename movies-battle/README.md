# Movie Battle
## _API Rest para teste técnico  - Equipe AdaTech_
[![N|Solid](https://pbs.twimg.com/profile_images/1453086096489959428/s915qXTs_200x200.jpg)](https://nodesource.com/products/nsolid)
## Filmes

Para inicializar a base de filmes, foi feito um webscraping do [IMDB](https://breakdance.github.io/breakdance/) de 50 filmes do gênero de ação.

## Swagger
O swagger-ui está em um subindo junto ao docker-compose, para acessá-lo basta seguir para:
```sh
http:localhost:8080
```

## OpenAPI 3.0 Collection

Para ter acesso a documentação OpenAPI 3.0 basta acessar o caminho:

```bash

movie-battle
    |
    |doc
    |    |___openapi.json

```

## Docker

Foi disponibilizado um **docker-compose.yml na raiz do projeto** para que a aplicação seja facilmente testada. Basta executar:

```sh
docker-compose up
```
## Endpoints

Porta padrão: **8080**

| Host | Método | Endpoint | Objetivo |
 | ------ | ------ | ------ | ------ |
| http://localhost:8080 | POST | /movie-battle/v1/iniciar | Iniciar uma nova partida
| http://localhost:8080 | GET | /movie-battle/v1/iniciar-rodada | Iniciar uma nova rodada
| http://localhost:8080 | GET | /movie-battle/v1/escolher-opcao | Escolher uma opção entre filmes
| http://localhost:8080 | GET | movie-battle/v1/gamOver  | End a game
| http://localhost:8080 | GET | movie-battle/v1/scoreBoard | Show the Score Board 

## Usuários

A seguir segue a lista de usuários criados que serão necessários para o jogo, o protocolo usado para autenticação foi o **Basic Authentication**

| Nome | Usuário | Senha |
| ------ | ------ | ------ |
| User1 | adatech | 123
| User2 | usuario2 | 123
| User3 | usuario3 | 123
| User4 | usuario4 | 123
| User5 | usuario5 | 123
| User6 | usuario6 | 123
| User7 | usuario7 | 123
| User8 | usuario8 | 123
| User9 | usuario9 | 123
| User10 | usuario10 | 123


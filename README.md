
<h1 align="center"> FUT 8</h1>



<h3 align="center">Descrição</h3>
O microsserviçosem presente desenvolvimento, tem como objetivo realizar o cadastro de jogos de futebol, bem como a organizaçõ de torneios entre times, permitindo o cadastro prévio e operações básicas de um crud para jogadores, times e jogos.



<h3 align="center">Funcionalidades</h3>

- Realizar o cadastro de novos usuários para que os mesmos possam realizar o acessos aos endpoints  disponibilizados
- Realizar o cadastro de novos jogadores, cada um tendo seu documento, email e senha para acessar aos endpoints
- Realizar o cadastro de novos times, para que os mesmos possam ser inscritos em jogos e torneios
- Realizar a criação e organização de chaves de torneios e organização pontuaria de campeonatos com base nos jogos informados de cada time


<h3 align="center">Pré-requisitos</h3>

-   [Docker](https://docs.docker.com/get-docker/) - Ainda não implementado
-   [JAVA](https://www.java.com/pt-BR/)
-  [GIT]([JAVA](https://www.java.com/pt-BR/))

<h3 align="center">Iniciando a aplicação</h3>

-  Abrir um terminal do sistema operacional
-   No terminal, clone o projeto:
```
git clone https://github.com/junioryes13/fut8

```
-	Dentro do Intelijj, acessar os menus: File > Open >> Abrir o diretório no qual o projeto foi clonado >> Selecionar o arquivo Pom.XML e clicar em "OK"

- Após o projeto ser aberto e todas as dependências serem baixadas, clicar com o botão direito sobre a classe Fut8Application e selecionar a opção Run Fut8Application.Main()

<h3 align="center">Endpoints mapeados </h3>

<h3>  POST</h3>

- http://localhost:8080/api/jogadores - cadastrar jogador

<h3>  GET</h3>

- http://localhost:8080/api/jogadores - Listar todos os jogadores

- http://localhost:8080/api/jogadores/{id} - Listar jogador pelo id

- http://localhost:8080/api/jogadores/{documento} - Listar jogador pelo documento

<h3>  Swagger</h3>

Acessar no navegador no 

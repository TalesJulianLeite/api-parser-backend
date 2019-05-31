# api_parser-backend
API to parser a Quaker's 3 log

Autor: Tales Julian Leite
Date: 2019/05/26
Email: talesjulianl@gmail.com

- A api utiliza Java e realiza o parser do arquivo de log do Quake 3 Arena;

- O arquivo de log foi importado para o caminho /src/main/resources/log dentro do diretório do projeto;

- Foi realizada a análise do arquivo e verificado que o log contém as seguintes características:
	- Quando um jogo é iniciado, o log informa a tag "GameInit:";
	- Quando um jogo é encerrado, o log informa a tag "ShutDownGame:";
	- Quando um player conecta ao game, o log informa a tag "ClientConnect:";
	- Quando as informações do player são alteradas ou um player loga no game, é informada a tag "ClientUserinfoChanged:";
	- Quando o player inicia no game, é informada a tag "ClientBegin:";
	- Quando ocorre um kill, o log informa a tag "Kill:";
	- O log de kill gera uma numeração após a tag "Kill:", informando o id do palyer que matou, o id do palyer que morreu e o id do tipo de morte;
	- <world> utiliza o id 1022 no registro de kill;
	- Suicídios não são contabilizados para o player, mas é contabilizada para o game;

- A api realiza a leitura do arquivo de log, realiza o parser de seus dados e retorna a lista
	dos games, os players, a quantidade de kills de cada player e a quantidade total de kills do game;

- Tendo o jdk ou jre 1.8 ou superior configurado na máquina do teste, acesso o diretório da aplicação, 
	abra o cmd e execute o comando 
- Acesse o navegador, de preferência o Google Chrome e acesso http:\\localhost:8081\getGames
- Aguarde o retorno da requisição
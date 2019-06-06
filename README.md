[![Build Status](https://travis-ci.org/TALESJULIAN/api-parser-backend.svg?branch=master)](https://travis-ci.org/TALESJULIAN/api-parser-backend)
# api_parser-backend
Backend api to parser a log file and send a response

Autor: Tales Julian Leite
Date: 2019/05/26
Email: talesjulianl@gmail.com
GitHub: https://github.com/TALESJULIAN/
LinkedIn: https://www.linkedin.com/in/tales-leite-5506a2b5/

- A api utiliza a linguagem Java e realiza o parser do arquivo de log do Quake 3 Arena;

- O arquivo de log foi importado para o caminho "/src/main/resources/log" dentro do diretório do projeto,
caso o usuário deseje realizar o parser de outro log, deverá importar o arquivo para o path informado
dentro do diretório e o arquivo de log deverá estar nomeado como "games.log";

- Foi realizada a análise do arquivo e verificado que o log contém as seguintes características comuns:
	- Quando um jogo é iniciado, o log informa a tag "GameInit:";
	- Quando um jogo é encerrado, o log informa a tag "ShutdownGame:" ou uma linha com traços, exemplo: "-------------";
	- Quando um player conecta ao game, o log informa a tag "ClientConnect:";
	- Quando as informações do player são alteradas ou um player loga no game, é informada a tag "ClientUserinfoChanged:";
	- Se o player altera seu nick, suas kills com o nick anterior não podem ser zeradas;
	- Quando o player inicia no game, é informada a tag "ClientBegin:";
	- Quando ocorre um kill, o log informa a tag "Kill:";
	- O log de kill gera uma numeração após a tag "Kill:", informando o id do player que matou (killer), o id do player que morreu (killed) e o id do tipo de morte (death mode);
	- <world> utiliza o id 1022 no registro de kill;
	- Suicídios não são contabilizados para o player, mas são contabilizados como kill para o game;

- A api realiza a leitura do arquivo de log, realiza o parser de seus dados e retorna a lista
	de cada game com seus respectivos players e kills de cada player no game, a quantidade de kills de cada player e a quantidade total de kills do game;

- A solução realizada implementada foi a seguinte:
	- Inicialmente na request get foi chamado o método para deletar, no caso de várias 
	- Como não foi especificado o modo de importação do arquivo, não foi feito um método para a importação do mesmo, que
	é importado pela api quando uma requisição de reposta do log é realizada;
	- Após a importação é realizada a leitura e iniciado o processo de parser, lendo linha por linha do log;
	- Durante o log são utilizadas listas para armazenar os dados dos games e dos players;
	- Após o término do parser o serviço realiza o preechimento das listas de games e players, 
	realizando a persistência dos dados no banco h2;
	- Com os dados persistidos, basta disparar a requisição para que nosso serviço retorne a listagem dos games;
	- Com a lista das instâncias de games preenchida, é realizado o parser da Entity para Dto, 
	o mesmo retorna apenas os dados necessários;

- Tendo o jdk ou jre 1.8 ou superior e o maven instalado na máquina do teste, acesso o diretório da aplicação na máquina, 
	abra o cmd e execute o comando "mvn spring-boot: run";
- Acesse o navegador, de preferência o Google Chrome e acesse a URL http:\\localhost:8080\all\games
- Aguarde o retorno da requisição com os dados do log.
- Para que a aplicação retorne 
- Para melhor visualizaçãoda do Json retornado, realize a requisição utilizando o Postman.
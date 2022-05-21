<h1> Desafio Zappts: Desenvolvido uma API venda de cartas do jogo Magic The Gathering</h1>


<h2>🛑 Foram implementadas as Entidades:</h2>

<p>

✅ Jogador<br>
✅ Carta<br>

✅ Idioma (Tipo: Enum) <br>
✅ ListaCartas (Interface de Projeção do JPA) <br>

✅ Controller / Service / Repository / Exceções das entidades: Jogador e Carta <br>
</p>


<h2>Descrição do Desenvolvimento</h2>

<p>
<strong>1.</strong> Utilizado Banco de Dados Postgress versão 12 e pgAdmin 5.5 versão Desktop <br>
<strong>2.</strong> IDE IntelliJ 2022.1.1 - Community Edition<br>
<strong>3.</strong> Versão JAVA 11.0.7 LTS <br> 
<strong>4.</strong> Swagger para Documentação, versão 2.9.2<br>
<strong>5.</strong> Postman para envio das requisições, versão 9.19.0<br>
<strong>6.</strong> Swagger para Documentação, versão 2.9.2<br>
</p>

----
Ao executar a API, utilizar o endpoint abaixo para cadastrar um jogador.

*NOTA:* Para o Cadastro de jogador é utilizado apenas o seu nome e CPF.
```
http://localhost:8080/api/v1/jogadores
```

Após o cadastro de um jogador é possível cadastrar uma carta, através do endpoint abaixo:

```
http://localhost:8080/api/v1/cartas
```

*OBS:* Cada carta é vinculada a um jogador, sendo assim só é possível cadastra-lá após ter cadastrado um jogador.

Para lista as cartas cadastradas em ordem alfabética utilizar o endpoint com o final "nome" e para listagem pelos preços das cartas, utilizar o final "valor"
conforme abaixo:

```
http://localhost:8080/api/v1/cartas/nome

http://localhost:8080/api/v1/cartas/valor
```

Por fim, para alterações ou exclusão de uma carta, utilizar o endpoint abaixo: 

```
http://localhost:8080/api/v1/cartas/CPF/id
```

*NOTA:* Substituir o campo "CPF" pelo número do CPF do jogador cadastrado e o campo "ID"
pela id da carta que deseja. Somente o jogador que cadastrou tal carta consegue essas alterações.


----
Para acessar a documentação juntamente com a interface do Swagger digite em seu navegador o endereço abaixo:

*OBS:* Todas as requisições também podem ser feitas através da Interface Gráfica do Swagger

````
http://localhost:8080/swagger-ui.html
````
----


<h3> ✨ Para Comunidade:</h3> 


<p>
Neste projeto é possível visualizar consultas com query personalizada, tratamento de exceções customizadas, utilização de ENUM e sua anotação para o JPA e também validação específica do CPF com o Vaidation do Spring Boot Starter.

Este repositório foi criado para um caso específico de um processo seletivo, porém pode ser de grande utilidade para quem está iniciando seus estudos.<br>

Espero ter contribuido e ajudado de alguma forma, ficarei feliz em saber. Caso queiram utilizar o código fiquem a vontade, e caso tenham dicas de melhorias estou de ouvidos abertos.<br>
E em caso de alguma dúvida, estou a disposição para ajudar.<br>
<br>

------------

Desenvolvido por [Diego Zaratini](https://www.linkedin.com/in/diego-zaratini-constantino/ "Diego Zaratini")
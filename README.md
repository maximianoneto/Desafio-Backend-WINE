# Desafio Backend Wine

Esse projeto é uma solução backend desenvolvida para o desafio proposto pela empresa Wine.
O objetivo principal do projeto é buscar informações de endereço através do CEP.

# Tecnologias utilizadas

Java 1.8

Spring Boot 2.7.5

MySQL Connector Java

Lombok

XMLUnit

# Como rodar o projeto localmente:
É necessário ter o Java 1.8 e o Maven instalados em seu computador.

Clone o repositório e abra o terminal na pasta raiz do projeto.

Execute o seguinte comando para baixar as dependências do projeto:

 mvn clean install
Crie um banco de dados MySQL com o nome "wine" e configure as credenciais de acesso no arquivo "application.properties".

Execute o seguinte comando para rodar o projeto:

 mvn spring-boot:run
Para acessar o serviço, basta fazer uma requisição GET para a URL:

http://localhost:8080/cep/{cep}
Substitua {cep} pelo CEP que deseja buscar informações.

# Estrutura do projeto
O projeto foi desenvolvido em Java com o framework Spring Boot. O arquivo "pom.xml" é responsável por gerenciar as dependências do projeto.

O arquivo "WineApplication.java" é a classe principal da aplicação e contém o método "main" que inicia a execução do projeto.

A classe "CepController.java" é responsável por receber as requisições GET e buscar as informações de endereço no banco de dados.

A classe "CepService.java" é responsável por implementar a lógica de busca das informações de endereço.

O arquivo "application.properties" é responsável por armazenar as configurações da aplicação, como a URL do banco de dados e as credenciais de acesso.

# Considerações finais
Esse projeto foi desenvolvido como uma solução backend para o desafio proposto pela empresa Wine. Através desse projeto, foi possível utilizar tecnologias como Java e Spring Boot para criar um serviço de busca de informações de endereço através do CEP.

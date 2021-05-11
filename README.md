# validator-password

Para executar a aplicação é necessário ter instalado o Apache Maven na versão 3.6.3 e JDK 11.

Os comando para que a aplicação seja executada no terminal são na seguinte ordem:

    mvn install - Instala as dependencias do projeto e executa os testes unitários.
    mvn spring-boot:run - Executa a aplicação expondo na porta 8080.
    mvn test (opcional) - Executa os testes unitários.

As requisições podem ser feitas através do Postman ou aplicação equivalente, ou pelo contexto /swagger-ui.html.

Detalhes de implementação:

Defini o controller onde será recebido as requisições com o body podendo receber o valor vazio para que possa ser validado de acordo com as regras de negocio, portando caso receba um valor vazio retornará false.
A classe ValidatorPasswordService é uma interface onde está definido o contrato de cada metodo que será implementado na classe ValidatorPasswordServiceImpl, e fica aberto para outras implementações de acordo com a regra de negócio.
Criei os testes unitários testando 2 cenários para cada método, validando o retorno quando deve ser true ou false.
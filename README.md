# atividade-final-sd
Atividade Final para Curso de Sistemas Distribuídos, utilizando Java, Spring Boot e ActiveMQ

Projeto criado utilizando JDK 18.0.2, Spring Boot 2.3.4 e ActiveMQ 5.17.3 (Necessário para utilizar o projeto)

Observações:
- A primeira questão 1.a) está em uma pasta separada questa1a;
  - Caso não haja nenhum objeto na fila, rodar a classe produtor primeiro e depois o consumidor ( possibilidade de acontecer erros )
  - Uma vez rodado o consumir ele já insere três objetos na fila
  
- A segunda questão 1.b) pede para ser inserido os objetos da fila dentro de um db a partir do consumidor, fiz isso a partir do consumidor REST.

- A tela para ver os dados na tabela do banco estão na pasta resources/telas

Para rodar: 
- Iniciar ActiveMQ através do CMD entrando na /bin e digitando o comando 'activemq start'
- Iniciar o projeto Spring Boot
- Através de alguma ferramenta que faz requisições:
  - POST Para o caminho http://localhost:8080/veiculo/enviarVeiculo
  - Passando no Body um Json: {
	"nomeCliente": "Daniel Fonseca",
  "marcaModeloVeiculo": "Chevrolet Cruze",
  "anoModelo": 2017,
	"valorVenda": 50000.00
}

  - GET Para o caminho http://localhost:8080/veiculo
  - Para ver a lista dos veículos produzidos
  
- Lembrando que o projeto utiliza um banco H2 em memória, então os dados persistem somente enquanto o está no ar.

# Pragma Brewery - Controle de temperatura

## Pré-requisitos:
- JDK 11;
- Maven 3;

## Execução:
Para rodar a aplicação de back-end basta seguir os seguintes passos:
```
$ mvn clean install
$ java -jar target/temperature-controll-1.0-SNAPSHOT.jar
```

A aplicação estará disponível no endereço: http://localhost:8080

OBS: Para rodar a aplicação de front-end, acesse o link a seguir e siga as instruções:
https://github.com/andreiAndrade/temperature-controll-web

## Orientações sobre uso:
O único recurso disponível na aplicação é o ``/beer-container``, que expõe uma lista de objetos na seguinte 
estrutura:
```
{
    "beerStyle": "PILSNER | IPA | LAGER | STOUT | WHEAT_BEER | PALE_ALE",
    "maxTemperature": "number",
    "minTemperature": "number",
    "outsideCorrectRange": "boolean",
    "temperature": "number"
}
```

A partir deste objeto o cliente da aplicação terá informações como: temperatura do container, temperatura máxima e
mínima tolerada pelo estilo de cerveja que está sendo carregado no mesmo, estilo da cerveja e um booleano informando
se a temperatura atual do container está dentro do tolerado pelo estilo.

Os containers com os 6 estilos de cerveja são carregados no início da aplicação e salvos em memória. A temperatura do
container é atualizada por um scheduler que roda a cada 10 segundos. Para fins de testes a temperatura é gerada de
forma aleatória com variação de 0.5 na temperatura máxima e mínima tolerada pelo estilo, para que haja a possibilidade
de gerar uma temperatura fora do range tolerado.

A notificação para o usuário fica a cargo da aplicação web, que possui um sistema de cores para identificar 
facilmente quando o container está com uma temperatura fora do esperado. Este sistema realiza requisições periodicas 
para o servidor a fim de atualizar as informações do container e notificar de forma visual o usuário. Mais 
informações no link: https://github.com/andreiAndrade/temperature-controll-web

## "What are the highlights of your logic/code writing style?"
- Uso de recursos nativos da linguagem para registro de log e agendamento de tarefas;

- Código simples e legível para a necessidade apresentada;

- Em vista da necessidade de não utilizar frameworks, como spring, o uso de de singletons foi interessante para 
otimização de memória.

## "What could have been done in a better way? What would you do in version 2.0?"
- Faria uso do framework Spring, a fim de promover maior escalabilidade, performance e redução de código;

- Se necessário, utilizar sistema de filas e mensagerias para flexibilizar o conceito de notificação e assim permitir
que seja feita de forma assíncrona e reativa.

## "What were the questions you would ask and your own answers/assumptions?"
- Não ficou claro de que forma seria feito o monitoramento da temperatura, algum sistema externo iria notificar o 
servidor sobre uma variação na temperatura? Desta forma, criei um monitoramento 
que ignora a fonte da informação e leva em conta apenas a temperatura obtida do container em questão;

- Não ficou claro qual era o tipo de notificação esperado, seria este por e-mail? sonoro? o servidor deveria realizar
esta notificação? Para sanar esta dúvida assumi que o servidor iria fazer apenas o monitoramento da temperatura e 
salvar a informação, assim, a notificação ficaria a cargo de aplicações externas que acessariam estas informações via
API.

## "Any other notes you feel relevant for the evaluation of your solution."
Espero ter tido um entendimento pleno do problema apresentado e que tenha resolvido de forma satisfatória. Qualquer 
dúvida estou a disposição.
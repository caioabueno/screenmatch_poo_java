# Screenmatch
*Este é um projeto do curso da plataforma de ensino **[Alura](https://www.alura.com.br/)***

---
## Sobre o projeto
O screenmatch é um sistema para plataforma de filmes onde é possível pesquisar um filme e receber suas especificações via [API Omdb](https://www.omdbapi.com).

O programa basicamente faz a requisição de API e recebe um json contendo as informações de um N filme, esse json é convertido em objeto java, é resserializado com os atributos configurados
no objeto e então os dados são persistidos em um arquivo json.

<p align="center">
<img src= "git-assets/presenting.gif">
</p>

---

## Dependências
Para esse rodar essa aplicação você irá precisar do [JDK 17.0.10](https://www.oracle.com/br/java/technologies/downloads/#java17) e da biblioteca [Gson 2.10.1](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1) (essa dependência está inclusa no repositório, mas se você experienciar problemas com os imports pode ser viável adicionar o jar manualmente).

---
## Funcionalidades Abordadas

### Conceitos de Programação Orientada a Objetos (POO)
* Herança
* Encapsulamento
* Polimorfismo
* Modificadores de Acesso

### Estrutura do Código
* Pacotes
* Utilização e Criação de Interfaces

### Manipulação de Dados

* Listas e Coleções
* Variáveis de Referência
* Sobrescrita de Métodos
* Construtores

### Integração com APIs
* Consumo de API Externa
* Conversão JSON com a biblioteca Gson
* Uso de DTO via Record para manipulação de dados

### Tratamento de Exceções
* Implementação de tratamento de exceções
* Criação de exceção personalizada

### Persistência de Dados
* Persistência de Dados com FileWriter

---
[**Anotações detalhadas**](https://judicious-visitor-abd.notion.site/Forma-o-Aprenda-a-programar-em-Java-com-Orienta-o-a-Objetos-51471855783b4c2ba4ffed29f03d67c3)

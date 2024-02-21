## Projeto CRUD com JSF e Primefaces para teste web da SINERJI

Este projeto apresenta um CRUD simples para gerenciar pessoas e seus endereços, integrado com um banco de dados relacional PostgreSQL. A interface web foi desenvolvida utilizando as tecnologias JSF e Primefaces, com uma abordagem mínima para demonstrar o funcionamento da implementação. Além disso, o projeto utiliza recursos avançados do Primefaces, como AJAX.

## Tecnologias Utilizadas
- **JSF 2.2:** Framework de componentes para construção de interfaces web em Java.
- **Primefaces 5.0:** Biblioteca de componentes rica para JSF, facilitando o desenvolvimento de interfaces web.
- **Apache Tomcat 9:** Servidor web e servlet container para executar aplicações web Java.
- **Hibernate 5.4:** Framework de mapeamento objeto-relacional (ORM) para Java, que simplifica a interação com bancos de dados.
- **PostgreSQL 42.2.19:** Sistema de gerenciamento de banco de dados relacional.
- **Maven:** Gerenciador de dependências e automação de compilação para projetos Java.

## Execução no Netbeans
1. Clone o projeto:

<code>git clone "url repo"</code>

2. Abra o projeto no Netbeans (versão 8 ou superior).

3. Certifique-se de que o Apache NetBeans esteja configurado corretamente com o Apache Tomcat 9 e a conexão com o banco de dados esteja configurada adequadamente.

4. Confirme a criação do banco de dados no pgAdmin com o nome de sua escolha.

5. Após a criação do banco de dados, referencie-o na classe "ConnectionFactory" encontrada no pacote "DAO" da aplicação.

6. Execute o script do banco de dados para criar as tabelas das entidades Person (Pessoa) e Address (Endereço). O arquivo SQL pode ser encontrado no pacote "sql" com o nome "generateEntitesSQL".

7. Revise o arquivo "index.jsp" para verificar o código da interface, onde será exibido o formulário para inserção de uma pessoa juntamente com seu endereço, a visualização das pessoas inseridas e a parte onde é possível selecionar e remover uma pessoa (obs: Ao remover uma pessoa, os endereços relacionados também serão apagados).

8. Por fim, para iniciar o sistema, pressione a tecla F6 ou clique no ícone de execução.


Este projeto serve como um exemplo prático de como desenvolver uma aplicação web utilizando tecnologias Java, e pode ser expandido e customizado conforme necessário.

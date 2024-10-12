![img.png](img.png)

## Tecnologias Abordadas
### 1. Swing (Interface Gráfica)
*	O que é: O Swing é uma biblioteca de componentes gráficos (GUI) que faz parte da plataforma Java. Ele fornece elementos de interface, como botões, caixas de texto, tabelas e janelas, permitindo que você crie interfaces gráficas desktop completas.
*	Como Usaremos: Utilizaremos o Swing para criar uma interface gráfica para gerenciar clientes. A interface permitirá que o usuário insira dados do cliente (como nome e email) e visualize os clientes cadastrados em uma tabela.
### 2. Hibernate (Persistência de Dados)
*	O que é: O Hibernate é uma ferramenta ORM (Object-Relational Mapping), que facilita a comunicação entre classes Java e bancos de dados relacionais. Com o Hibernate, você pode persistir objetos Java diretamente no banco de dados, sem precisar escrever consultas SQL manualmente.
*	Como Usaremos: O Hibernate será usado para gerenciar as operações de banco de dados no MySQL. Vamos criar uma classe ClienteDAO para salvar, listar, alterar e excluir clientes. O Hibernate mapeará a classe Cliente para uma tabela no banco de dados, automatizando as operações CRUD.
### 3. MySQL (Banco de Dados Relacional)
*	O que é: O MySQL é um sistema de gerenciamento de banco de dados relacional popular, utilizado para armazenar dados de forma estruturada.
*	Como Usaremos: Utilizaremos o MySQL para armazenar os dados dos clientes. O Hibernate se conectará ao banco de dados MySQL para realizar operações de inserção, atualização, exclusão e leitura de dados.
### 4. Maven (Gerenciamento de Dependências)
*	O que é: O Maven é uma ferramenta de automação de build e gerenciamento de dependências para projetos Java. Ele facilita a configuração de bibliotecas e frameworks no projeto e garante que todas as dependências necessárias sejam gerenciadas e baixadas automaticamente.
*	Como Usaremos: Utilizaremos o Maven para gerenciar as dependências do Hibernate, MySQL e outras bibliotecas necessárias. Isso tornará o projeto mais fácil de configurar e manter.

## Funcionalidades da Aplicação
O aplicativo será uma aplicação desktop simples para gerenciar clientes com as seguintes funcionalidades:
1.	Adicionar Clientes:
	O usuário poderá adicionar um novo cliente inserindo o nome e o email nos campos de texto e clicando no botão "Salvar". O cliente será salvo no banco de dados MySQL.
2.	Listar Clientes:
	Todos os clientes cadastrados serão exibidos em uma tabela na interface gráfica. A tabela será atualizada sempre que um novo cliente for adicionado ou uma operação de alteração ou exclusão for realizada.
3.	Alterar Clientes:
	O usuário poderá selecionar um cliente existente na tabela. Os dados do cliente serão carregados nos campos de texto, permitindo que o usuário faça alterações. Após modificar as informações, o usuário poderá clicar no botão "Alterar" para atualizar os dados no banco de dados.
4.	Excluir Clientes:
	O usuário poderá excluir um cliente selecionando-o na tabela e clicando no botão "Excluir". O cliente será removido do banco de dados e a tabela será atualizada.
                   
## Estrutura dos Pacotes
1. Pacote model
    Este pacote contém a classe Cliente, que é a entidade do projeto. A classe Cliente representa um cliente no sistema e será mapeada para uma tabela no banco de dados MySQL usando o Hibernate.
	Cada instância de Cliente terá um id, nome, e email. O id será gerado automaticamente pelo banco de dados.
2. Pacote persistence
	Este pacote contém as classes responsáveis pela persistência de dados no banco de dados.
	A classe HibernateUtil fornecerá a configuração necessária para o Hibernate se conectar ao banco de dados e criar uma sessão para realizar as operações de banco.
	A classe ClienteDAO (Data Access Object) gerenciará as operações de inserção, leitura, atualização e exclusão (CRUD) dos clientes no banco de dados.
3. Pacote view
    Este pacote contém a interface gráfica, onde os usuários interagem com a aplicação.
	A classe ClienteView será a janela da aplicação, com campos de texto para digitar o nome e o email do cliente, além de botões para as operações CRUD (Salvar, Alterar, Excluir).
	Também terá uma JTable para exibir a lista de clientes cadastrados no banco.
4. Classe GerenciarClientes
    A classe GerenciarClientes ficará fora dos pacotes e será responsável por iniciar o aplicativo. Ela conterá o método main, que executará a janela ClienteView.

## Fluxo do Aplicativo
1.	Início: A aplicação é iniciada pela classe GerenciarClientes, que abre a janela ClienteView.
2.	Interação: O usuário poderá:
	Inserir o nome e o email de um cliente e clicar em "Salvar" para adicioná-lo à tabela e ao banco de dados.
	Selecionar um cliente na tabela para editar seus dados ou removê-lo do sistema.
3.	Persistência: O Hibernate é responsável por conectar o aplicativo ao banco de dados MySQL e realizar todas as operações de CRUD (inserir, listar, atualizar e excluir).
4.	Exibição de Dados: A JTable na interface gráfica é constantemente atualizada para refletir o estado atual do banco de dados.
                    

 
 

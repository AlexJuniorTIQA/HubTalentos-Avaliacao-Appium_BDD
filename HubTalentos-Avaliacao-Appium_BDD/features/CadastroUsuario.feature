#language: pt
Funcionalidade: Cadastro de Usuario
Contexto:
Dado que estou na homepage do aplicativo 
Quando clico no icone de login e em criar nova conta

@CadastroDeUsuarioComSucesso
Cenario: Cadastro de Usuario Com Sucesso
E preencho todos os dados
E clico no botao registrar
Entao consigo criar o meu usuario

@CadastroDeUsuarioComFalha
Cenario: Cadastro de Usuario Com Falha

E preencho os campos de detalhe da Conta
Mas insiro uma senha sem letra maiuscula
Entao recebo uma mensagem de requisicao


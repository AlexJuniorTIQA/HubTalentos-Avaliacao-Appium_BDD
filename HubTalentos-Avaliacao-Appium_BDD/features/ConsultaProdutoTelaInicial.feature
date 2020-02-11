#language: pt
Funcionalidade: Consultar Produto pela Tela Inicial

Contexto:
Dado que estou na pagina inicial do site

@ConsultaNaTelaInicialComSucesso
Cenario: Consulta na tela inicial com sucesso
Quando clico em uma das classes de produtos
E clico em um dos produtos 
Entao acesso a pagina do produto selecionado


@ConsultaNaTelaInicialComFalha
Cenario: Consulta na tela inicial com falha
Quando clico na classe Laptops
E clico no produto HP PAVILION TOUCH LAPTOP
E seleciono a cor amarela
Entao recebo uma mensagem de imagem nao encontrada
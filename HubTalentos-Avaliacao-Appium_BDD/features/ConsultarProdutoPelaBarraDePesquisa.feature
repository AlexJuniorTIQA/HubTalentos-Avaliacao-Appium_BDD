#language: pt

Funcionalidade: Consultar produto pela barra de pesquisa

Contexto:
Dado que estou na HomePage do aplicativo
E clico na barra de pesquisa

@ConsultaNaBarraDePesquisaComSucesso
Cenario: Consulta na barra de pesquisa com sucesso
Quando pesquiso um produto valido no site
E clico no produto pesquisado
Entao o site me retorna a pagina do produto 

@ConsultaNaBarraDePesquisaComFalha
Cenario: Consulta na barra de pesquisa com falha
Quando pesquiso um produto invalido no site
Entao o site me retorna que o produto nao foi encontrado
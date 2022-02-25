# CONTROL-API
 Sistema de Controle geral
 
# Começando
Para executar o projeto, será necessário instalar os seguintes programas:
* Open-JDK 11
* Eclipse Spring Tools Suites 4 (STS 4)
* Banco de dados MySql 8 ou PostgreSQL 14

# Retornos da aplicação
    Categorias
    * /categorias -GET- Retorna paginação das categorias
    * /categorias -POST- Recebe Json com dados da categoria
    * /categorias/{id} -GET- Retorna uma categoria
    * /categorias/{id} -PUT- Altera uma categoria
    * /categorias/{id} -DELETE- Exclui uma categoria
    Contas
    * /contas -GET- Retorna paginação das Contas
    * /contas -POST- Recebe Json com dados da Conta
    * /contas/{id} -GET- Retorna uma Conta
    * /contas/{id} -PUT- Altera uma Conta
    * /contas/{id} -DELETE- Exclui uma Conta
    * /contas/lista -GET- Retorna lista das Contas
    * /contas/total-saldos -GET- Retorno o saldo das contas
    Lançamentos
    * /lancamentos -GET- Retorna paginação dos lancamentos
    * /lancamentos -POST- Recebe Json com dados do lancamento
    * /lancamentos/{id} -GET- Retorna um lancamento
    * /lancamentos/{id} -PUT- Altera um lancamento
    * /lancamentos/{id} -DELETE- Exclui um lancamento
    * /lancamentos/estatisticas/por-categoria?dataInicio&dataFim -GET- Retorna lançamentos por categoria
    * /lancamentos/estatisticas/por-tipo?dataInicio&dataFim -GET- Retorna lançamentos por tipo do lançamento
    * /lancamentos/total-receitas?dataInicio&dataFim -GET- Retorna total dos lançamentos das receitas
    * /lancamentos/total-despesas?dataInicio&dataFim -GET- Retorna total dos lançamentos das despesas
    Plantas
    * /plantas -GET- Retorna paginação das plantas
    * /plantas -POST- Recebe Json com dados da planta
    * /plantas/{id} -GET- Retorna uma planta
    * /plantas/{id} -PUT- Altera uma planta
    * /plantas/{id} -DELETE- Exclui uma planta
# 


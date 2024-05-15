# language: pt

Funcionalidade: Cadastro

    Contexto: 
        Dado Que eu esteja na página de cadastro do Alura Esporte

    @cadastro
    Cenário: Cadastro de um usuário com as credenciais corretas
        Quando Eu insiro os dados corretos para cadastro 
        Então Eu sou redirecionado para a página de login

    @cadastro
    Cenário: Não cadastrar um usuário com senhas que não coincidem
        Quando Eu tentar me cadastrar com senhas que não coincidem 
        Então Uma mensagem de erro deve aparecer 
    
    @login
    Cenário: Login com usuário e senha válido
        Quando Eu tentar fazer login com usuário e senhas válido 
        Então Devo ser redirecionado para a página inicial do app

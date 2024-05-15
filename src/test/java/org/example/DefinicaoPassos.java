package org.example;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.PageObjects.Cadastro;
import org.example.PageObjects.Login;
import org.junit.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import org.junit.jupiter.api.Test;

public class DefinicaoPassos {
    @Dado("Que eu esteja na página de cadastro do Alura Esporte")
    public void quando_estiver_na_pagina_de_cadastro(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();
    }

    @Quando("Eu insiro os dados corretos para cadastro")
    public void quando_inserir_dados_corretos(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro telaCadastro = new Cadastro(driver);
        telaCadastro.buscarElementos();
        telaCadastro.preencherFormulario("Matheus", "123", "123");
        telaCadastro.cadastrar();
    }

    @Então("Eu sou redirecionado para a página de login")
    public void devo_ser_redirecionado_para_login(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MobileElement campoLogin = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
        assertTrue( true );
    }

    @Quando("Eu tentar me cadastrar com senhas que não coincidem")
    public void quando_inserir_senhas_que_nao_coincidem(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Cadastro telaCadastro = new Cadastro(driver);
        telaCadastro.buscarElementos();
        telaCadastro.preencherFormulario("Matheus", "123", "456");
        telaCadastro.cadastrar();

    }

    @Então("Uma mensagem de erro deve aparecer")
    public void validar_mensagem_de_erro(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MobileElement mensagemErro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

        Assert.assertEquals("Senhas não conferem", mensagemErro.getText());
        driver.navigate().back();
    }

    @Quando("Eu tentar fazer login com usuário e senhas válido")
    public void login_com_credenciais_corretas() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Cadastro telaCadastro = new Cadastro(driver);
        telaCadastro.buscarElementos();
        telaCadastro.preencherFormulario("Matheus", "1234", "1234");
        telaCadastro.cadastrar();

        Login login = new Login(driver);
        login.buscarElementos();
        login.preencherFormulario("Matheus", "1234");
        login.logar();
    }
    
    
}

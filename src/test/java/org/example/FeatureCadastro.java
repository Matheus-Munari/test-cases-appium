package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.TestCase;
import org.example.PageObjects.Cadastro;
import org.example.PageObjects.Compra;
import org.example.PageObjects.Login;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

/**
 * Unit test for simple App.
 */
public class FeatureCadastro
    extends TestCase
{
    
    @Test
    public void nao_cadastrar_usuarios_com_senhas_diferentes_teste(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        Cadastro telaCadastro = new Cadastro(driver);
        telaCadastro.buscarElementos();
        telaCadastro.preencherFormulario("Matheus", "123", "456");
        telaCadastro.cadastrar();

        MobileElement mensagemErro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

        Assert.assertEquals("Senhas não conferem", mensagemErro.getText());
        driver.navigate().back();
        assertTrue( true );

    }

    @Test
    public void cadastrar_usuario_com_informacoes_validas() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        Cadastro telaCadastro = new Cadastro(driver);
        telaCadastro.buscarElementos();
        telaCadastro.preencherFormulario("Matheus", "1234", "1234");
        telaCadastro.cadastrar();

        MobileElement campoLogin = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
        assertTrue( true );

    }

    @Test
    public void login_com_credenciais_corretas() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherFormulario("Matheus", "1234", "1234");
        cadastro.cadastrar();
        Thread.sleep(1000);
        Login login = new Login(driver);
        login.buscarElementos();
        login.preencherFormulario("Matheus", "1234");
        login.logar();

        assertTrue( true );

    }

    @Test
    public void login_com_usuario_incorreto() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherFormulario("Matheus", "1234", "1234");
        cadastro.cadastrar();
        Thread.sleep(1000);
        Login login = new Login(driver);
        login.buscarElementos();
        login.preencherFormulario("Mateus", "1234");
        login.logar();
        MobileElement mensagemErro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/mensagem_erro_login");
        Assert.assertEquals("Usuário ou senha inválidos", mensagemErro.getText());
        assertTrue( true );

    }

    @Test
    public void compra_com_numero_de_cartao_abaixo_do_esperado_corretos() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();
        Thread.sleep(1000);
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherFormulario("Matheus", "1234", "1234");
        cadastro.cadastrar();
        Thread.sleep(1000);
        Login login = new Login(driver);
        login.buscarElementos();
        login.preencherFormulario("Matheus", "1234");
        login.logar();
        Thread.sleep(1000);

        Compra compra = new Compra(driver);
        compra.buscarProduto();
        compra.clicaProduto();
        compra.buscarBotaoComprar();
        compra.clicaBotaoComprar();
        compra.buscarCamposPagamento();
        compra.preencherFormulario("1234", "30/12/2023", "123");
        compra.confirmarCompra();

        MobileElement mensagemErro = (MobileElement) driver.findElement(By.xpath("//*[contains(@text, 'Falha ao criar o pagamento')]"));
        Assert.assertEquals("Falha ao criar o pagamento", mensagemErro.getText());
    }
    @Test
    public void compra_com_dados_de_pagamento_corretos() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();
        Thread.sleep(1000);
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherFormulario("Matheus", "1234", "1234");
        cadastro.cadastrar();
        Thread.sleep(1000);
        Login login = new Login(driver);
        login.buscarElementos();
        login.preencherFormulario("Matheus", "1234");
        login.logar();
        Thread.sleep(1000);

        Compra compra = new Compra(driver);
        compra.buscarProduto();
        compra.clicaProduto();
        compra.buscarBotaoComprar();
        compra.clicaBotaoComprar();
        compra.buscarCamposPagamento();
        compra.preencherFormulario("1234123412341234", "30/12/2023", "123");
        compra.confirmarCompra();
        compra.buscarBotaoPagamentos();
        compra.clicarBotaoPagamentos();
        Thread.sleep(1000);
        MobileElement itemCompra = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/item_pagamento_id");
    }

}

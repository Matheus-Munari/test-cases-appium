package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Cadastro {

    private AppiumDriver driver;
    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;

    public Cadastro(AppiumDriver driver){
        this.driver = driver;
    }

    public void buscarElementos(){
        campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    public void preencherFormulario(String usuario, String senha, String confirmacao){
        campoNome.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        campoConfirmarSenha.sendKeys(confirmacao);
    }

    public void cadastrar(){
        botaoCadastrar.click();
    }
}

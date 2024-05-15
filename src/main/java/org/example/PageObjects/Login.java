package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Login {
    private AppiumDriver driver;
    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement botaoLogin;

    public Login(AppiumDriver driver){
        this.driver = driver;
    }

    public void buscarElementos(){
        campoUsuario = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
        campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        botaoLogin = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
    }

    public void preencherFormulario(String usuario, String senha){
        campoUsuario.sendKeys(usuario);
        campoSenha.sendKeys(senha);
    }

    public void logar(){
        botaoLogin.click();
    }

}

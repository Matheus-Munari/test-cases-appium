package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class Compra {
    private MobileElement produto;
    private MobileElement botaoComprar;
    private MobileElement numeroCartao;
    private MobileElement validadeCartao;
    private MobileElement codigoCartao;
    private AppiumDriver driver;
    private MobileElement botaoConfirmarPagamento;
    private MobileElement botaoPagamentos;

    public Compra(AppiumDriver driver){
        this.driver = driver;
    }

    public void buscarProduto(){
        produto = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/item_produto_nome");
    }

    public void buscarBotaoComprar(){
        botaoComprar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/detalhes_produto_botao_comprar");
    }

    public void buscarCamposPagamento(){
        numeroCartao = (MobileElement) driver.findElement(By.xpath("//*[@text='Número cartão']"));
        validadeCartao = (MobileElement) driver.findElement(By.xpath("//*[@text='Data de validade']"));
        codigoCartao = (MobileElement) driver.findElement(By.xpath("//*[@text='CVC']"));
        botaoConfirmarPagamento = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/pagamento_botao_confirma_pagamento");
    }

    public void buscarBotaoPagamentos(){
        botaoPagamentos = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/smallLabel");
    }

    public void preencherFormulario(String numCartao, String dtValidade, String cdCartao){
        numeroCartao.sendKeys(numCartao);
        validadeCartao.sendKeys(dtValidade);
        codigoCartao.sendKeys(cdCartao);
    }

    public void confirmarCompra(){
        botaoConfirmarPagamento.click();
    }

    public void clicaProduto(){
        produto.click();
    }

    public void clicaBotaoComprar(){
        botaoComprar.click();
    }

    public void clicarBotaoPagamentos(){
        botaoPagamentos.click();
    }

}

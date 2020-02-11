package br.com.rsinet.appium.stepdefinitions;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.appium.screens.ProductScreen;
import br.com.rsinet.appium.utils.Constant;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import br.com.rsinet.appium.utils.ExtentReport;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class ConsultarProdutoTelaInicial_Step {
	private AndroidDriver<WebElement> driver;

	private ProductScreen productScreen;
	private String teste;
	private ExtentTest report;
	static ExtentReports test;
	
	@After
	public void Finaliza() {

		driver.quit();
	}

	@Dado("^que estou na pagina inicial do site$")
	public void que_estou_na_pagina_inicial_do_site() throws Exception {
		driver = DriverFactory.getDriver();

		productScreen = PageFactory.initElements(driver, ProductScreen.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Mice");
	}

	@Quando("^clico em uma das classes de produtos$")
	public void clico_em_uma_das_classes_de_produtos() {
		report = ExtentReport.createTest("ConsultaProdutoTelaInicialComSucesso");

		DriverFactory.findVisibleText("Mice");
	}

	@E("^clico em um dos produtos$")
	public void clico_em_um_dos_produtos() throws Exception {
		DriverFactory.findVisibleText(ExcelUtils.getCellData(6, 1));

	}

	@Entao("^acesso a pagina do produto selecionado$")
	public void acesso_a_pagina_do_produto_selecionado() throws Exception {
		Assert.assertEquals(ExcelUtils.getCellData(6, 1).toUpperCase(), productScreen.getTextProduct());

		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteProdutoTelaInicialComSucesso";
	}

	@Quando("^clico na classe Laptops$")
	public void clico_na_classe_Laptops() throws Throwable {
		report = ExtentReport.createTest("ConsultaProdutoTelaInicialComFalha");

		DriverFactory.findVisibleText("Laptops");

	}

	@E("^clico no produto HP PAVILION TOUCH LAPTOP$")
	public void clico_no_produto_HP_PAVILION_TOUCH_LAPTOP() {
		DriverFactory.findVisibleText("HP PAVILION 15Z TOUCH LAPTOP");
	}

	@E("^seleciono a cor amarela$")
	public void seleciono_a_cor_amarela() throws Throwable {
		productScreen.clickSelectColor();
		productScreen.clickIconColorYellow();
	}

	@Entao("^recebo uma mensagem de imagem nao encontrada$")
	public void recebo_uma_mensagem_de_imagem_nao_encontrada() throws Throwable {
		Assert.assertEquals("HP PAVILION 15Z TOUCH LAPTOP", productScreen.getTextProduct());

		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteProdutoTelaInicialComFalha";
	}

}

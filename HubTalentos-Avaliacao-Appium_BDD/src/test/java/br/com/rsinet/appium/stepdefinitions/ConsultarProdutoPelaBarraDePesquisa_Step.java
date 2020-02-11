package br.com.rsinet.appium.stepdefinitions;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.appium.screens.HomeScreen;
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

public class ConsultarProdutoPelaBarraDePesquisa_Step {
	private AndroidDriver<WebElement> driver;
	private HomeScreen homeScreen;
	private ProductScreen productScreen;
	private String teste;
	private ExtentTest report;
	static ExtentReports test;

	@After
	public void Finaliza() {
		driver.quit();
	}

	@Dado("^que estou na HomePage do aplicativo$")
	public void que_estou_na_HomePage_do_aplicativo() throws Throwable {
		driver = DriverFactory.getDriver();

		homeScreen = PageFactory.initElements(driver, HomeScreen.class);
		productScreen = PageFactory.initElements(driver, ProductScreen.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Headphone");
	}

	@E("^clico na barra de pesquisa$")
	public void clico_na_barra_de_pesquisa() {
		homeScreen.clickIconSearch();
	}

	@Quando("^pesquiso um produto valido no site$")
	public void pesquiso_um_produto_v_lido_no_site() throws Exception {
		report = ExtentReport.createTest("TesteProdutoBarraDePesquisaComSucesso");
		homeScreen.setSearch(ExcelUtils.getCellData(1, 1));
		homeScreen.clickIconSearch();
	}

	@E("^clico no produto pesquisado$")
	public void clico_no_produto_pesquisado(){
		DriverFactory.pageRollUp();
		productScreen.clickProduct();
	  
	}
	@Entao("^o site me retorna a pagina do produto$")
	public void o_site_me_retorna_a_pagina_do_produto() throws Exception {
		Assert.assertEquals(ExcelUtils.getCellData(1, 1).toUpperCase(), productScreen.getTextProduct());

		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteProdutoBarraDePesquisaComSucesso";
	}

	@Quando("^pesquiso um produto invalido no site$")
	public void pesquiso_um_produto_inv_lido_no_site() throws Exception {
		report = ExtentReport.createTest("TesteProdutoBarraDePesquisaComFalha");
		
		homeScreen.setSearch(ExcelUtils.getCellData(6, 1));
		homeScreen.clickIconSearch();
	}

	@Entao("^o site me retorna que o produto nao foi encontrado$")
	public void o_site_me_retorna_que_o_produto_n_o_foi_encontrado() throws Exception {
		Assert.assertEquals("- No results for \"" + ExcelUtils.getCellData(6, 1) + "\" -", productScreen.getNotFoundProduct());

		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteProdutoBarraDePesquisaComFalha";
	}

}

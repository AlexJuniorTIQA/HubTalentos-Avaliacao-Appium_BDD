package br.com.rsinet.appium.stepdefinitions;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.appium.screens.HomeScreen;
import br.com.rsinet.appium.screens.LoginScreen;
import br.com.rsinet.appium.screens.RegisterScreen;
import br.com.rsinet.appium.utils.AutoCompleteRegisterUser;
import br.com.rsinet.appium.utils.Constant;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import br.com.rsinet.appium.utils.ExtentReport;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Mas;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class CadastroUsuario_Step {
	private AndroidDriver<WebElement> driver;
	private RegisterScreen registerScreen;
	private HomeScreen homeScreen;
	private LoginScreen loginScreen;
	private AutoCompleteRegisterUser autoCompleteRegisterUser;
	private String teste;
	private ExtentTest report;
	static ExtentReports test;



	@After
	public void Finaliza() {

		driver.quit();
	}

	@Dado("^que estou na homepage do aplicativo$")
	public void que_estou_na_homepage_do_aplicativo() throws Exception {
		driver = DriverFactory.getDriver();
		registerScreen = PageFactory.initElements(driver, RegisterScreen.class);
		loginScreen = PageFactory.initElements(driver, LoginScreen.class);
		homeScreen = PageFactory.initElements(driver, HomeScreen.class);
		autoCompleteRegisterUser = new AutoCompleteRegisterUser(driver);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");

	}

	@Quando("^clico no icone de login e em criar nova conta$")
	public void clico_no_icone_de_login_e_em_criar_nova_conta() {
		report = ExtentReport.createTest("CadastroNovoUsuarioComSucesso");

		homeScreen.clickMenu();
		homeScreen.clickIconUser();
		loginScreen.clickCreatNewAccount();
	}

	@E("^preencho todos os dados$")
	public void preencho_todos_os_dados() throws Exception {
		autoCompleteRegisterUser.setUserRegister(driver, 1);
	}

	@E("^clico no botao registrar$")
	public void clico_no_botao_registrar() {
		registerScreen.clickButtonRegister();
	}

	@Entao("^consigo criar o meu usuario$")
	public void consigo_criar_o_meu_usuario() throws IOException {
		DriverFactory.pageRollUp();
		homeScreen.clickMenu();

		Assert.assertNotEquals("LOGIN", homeScreen.getIconUser());

		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteCadastroNovoUsuarioComSucesso";

	}

	@E("^preencho os campos de detalhe da Conta$")
	public void preencho_os_campos_de_detalhe_da_Conta() throws Throwable {
		registerScreen.setUserName(autoCompleteRegisterUser.getUserName(7));
		registerScreen.setEmail(ExcelUtils.getCellData(4, 2));

	}

	@Mas("^insiro uma senha sem letra maiuscula$")
	public void insiro_uma_senha_sem_letra_maiuscula() throws Throwable {
		registerScreen.setPassword(ExcelUtils.getCellData(4, 3));
		registerScreen.setConfirmPassword(ExcelUtils.getCellData(4, 3));
	}

	@Entao("^recebo uma mensagem de requisicao$")
	public void recebo_uma_mensagem_de_requisicao() throws Throwable {
		Assert.assertEquals("1 upper letter required", registerScreen.getIconPassword());

		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteCadastroNovoUsuarioComFalha";
	}

}
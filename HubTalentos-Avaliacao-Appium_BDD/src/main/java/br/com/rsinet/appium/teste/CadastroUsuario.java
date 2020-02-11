package br.com.rsinet.appium.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
import io.appium.java_client.android.AndroidDriver;

public class CadastroUsuario {

	private AndroidDriver<WebElement> driver;
	private RegisterScreen registerScreen;
	private HomeScreen homeScreen;
	private LoginScreen loginScreen;
	private AutoCompleteRegisterUser autoCompleteRegisterUser;
	private String teste;
	private ExtentTest report;
    static ExtentReports test;
	
	
   
	@Before
	public void Inicializa() throws Exception {

	
		driver = DriverFactory.getDriver();
		registerScreen = PageFactory.initElements(driver, RegisterScreen.class);
		loginScreen = PageFactory.initElements(driver, LoginScreen.class);
		homeScreen = PageFactory.initElements(driver, HomeScreen.class);
		autoCompleteRegisterUser= new AutoCompleteRegisterUser(driver);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");
	}
	@After
	public void Finaliza() {
		
		driver.quit();
	}


	@Test
	public void CadastroNovoUsuarioComSucesso() throws Exception {
		report = ExtentReport.createTest("CadastroNovoUsuarioComSucesso");
		
		homeScreen.clickMenu();
		homeScreen.clickIconUser();
		loginScreen.clickCreatNewAccount();

		autoCompleteRegisterUser.setUserRegister(driver, 1);

		registerScreen.clickButtonRegister();
		
		
		DriverFactory.pageRollUp();
		homeScreen.clickMenu();
		
		Assert.assertNotEquals("LOGIN", homeScreen.getIconUser()); 
		
		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteCadastroNovoUsuarioComSucesso";
	}
	@Test
	public void CadastroNovoUsuarioComFalha() throws Exception {
		report = ExtentReport.createTest("CadastroNovoUsuarioComFalha");
		
		homeScreen.clickMenu();
		homeScreen.clickIconUser();
		loginScreen.clickCreatNewAccount();


		registerScreen.setUserName(autoCompleteRegisterUser.getUserName(7));
		registerScreen.setEmail(ExcelUtils.getCellData(4, 2));
		registerScreen.setPassword(ExcelUtils.getCellData(4, 3));
		registerScreen.setConfirmPassword(ExcelUtils.getCellData(4, 3));
		
		Assert.assertEquals("1 upper letter required", registerScreen.getIconPassword());
		
		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteCadastroNovoUsuarioComFalha";
	}
}

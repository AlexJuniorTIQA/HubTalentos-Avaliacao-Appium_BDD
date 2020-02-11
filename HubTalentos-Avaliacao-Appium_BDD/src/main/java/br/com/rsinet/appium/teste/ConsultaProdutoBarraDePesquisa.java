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
import br.com.rsinet.appium.screens.ProductScreen;
import br.com.rsinet.appium.utils.Constant;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import br.com.rsinet.appium.utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class ConsultaProdutoBarraDePesquisa {

	private AndroidDriver<WebElement> driver;
	private HomeScreen homeScreen;
	private ProductScreen productScreen;
	private String teste;
	private ExtentTest report;
	static ExtentReports test;

	@BeforeClass
	public static void test() {
		test = ExtentReport.setExtent("Consulta Produto Barra de Pesquisa");
	}

	@Before
	public void Inicializa() throws Exception {
		driver = DriverFactory.getDriver();

		homeScreen = PageFactory.initElements(driver, HomeScreen.class);
		productScreen = PageFactory.initElements(driver, ProductScreen.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Headphone");
	}

	@After
	public void Finaliza() {
		ExtentReport.quitExtent(test);
		driver.quit();
	}

	@Test
	public void ConsultaProdutoBarraDePesquisaComSucesso() throws Exception {
		report = ExtentReport.createTest("TesteProdutoBarraDePesquisaComSucesso");
		
		homeScreen.clickIconSearch();
		homeScreen.setSearch(ExcelUtils.getCellData(1, 1));
		homeScreen.clickIconSearch();

		DriverFactory.pageRollUp();
		productScreen.clickProduct();

		Assert.assertEquals(ExcelUtils.getCellData(1, 1).toUpperCase(), productScreen.getTextProduct());

		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteProdutoBarraDePesquisaComSucesso";
	}

	@Test
	public void ConsultaProdutoBarraDePesquisaComFalha() throws Exception {
		report = ExtentReport.createTest("TesteProdutoBarraDePesquisaComFalha");
		
		homeScreen.clickIconSearch();

		String product = ExcelUtils.getCellData(6, 1);
		homeScreen.setSearch(product);

		homeScreen.clickIconSearch();

		Assert.assertEquals("- No results for \"" + product + "\" -", productScreen.getNotFoundProduct());
		
		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteProdutoBarraDePesquisaComFalha";
	}
}

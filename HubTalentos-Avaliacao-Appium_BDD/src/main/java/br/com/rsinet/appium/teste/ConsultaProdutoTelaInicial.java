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

import br.com.rsinet.appium.screens.ProductScreen;
import br.com.rsinet.appium.utils.Constant;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import br.com.rsinet.appium.utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class ConsultaProdutoTelaInicial {
	private AndroidDriver<WebElement> driver;

	private ProductScreen productScreen;
	private String teste;
	private ExtentTest report;
    static ExtentReports test;
	
    @BeforeClass
    public static void test() {
        test = ExtentReport.setExtent("Consulta Produto Tela Inicial");
    }
    
	@Before
	public void Inicializa() throws Exception {
		driver = DriverFactory.getDriver();
	
		productScreen = PageFactory.initElements(driver, ProductScreen.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Mice");
	}
	@After 
	public void Finaliza() {
		ExtentReport.quitExtent(test);
		driver.quit();
	}

	@Test
	public void ConsultaProdutoTelaInicialComSucesso() throws Exception {
		report = ExtentReport.createTest("ConsultaProdutoTelaInicialComSucesso");
		
		DriverFactory.findVisibleText("Mice");
		DriverFactory.findVisibleText(ExcelUtils.getCellData(6, 1));
		
		Assert.assertEquals(ExcelUtils.getCellData(6, 1).toUpperCase(), productScreen.getTextProduct());
	
		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteProdutoTelaInicialComSucesso";
		
	}
	@Test
	public void ConsultaProdutoTelaInicialComFalha() throws Exception {
		report = ExtentReport.createTest("ConsultaProdutoTelaInicialComFalha");
		
		DriverFactory.findVisibleText("Laptops");
		
		DriverFactory.findVisibleText("HP PAVILION 15Z TOUCH LAPTOP");
		
		productScreen.clickSelectColor();
		productScreen.clickIconColorYellow();
		
		Assert.assertEquals("HP PAVILION 15Z TOUCH LAPTOP", productScreen.getTextProduct());
		
		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteProdutoTelaInicialComFalha";
	}
}

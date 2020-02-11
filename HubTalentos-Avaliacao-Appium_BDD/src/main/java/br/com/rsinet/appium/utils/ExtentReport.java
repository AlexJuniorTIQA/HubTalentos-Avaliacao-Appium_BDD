package br.com.rsinet.appium.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**Classe da parametrização do ExtentReport**/
public class ExtentReport {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports setExtent(String nomeReport) {
		String dateName = new SimpleDateFormat("dd_MM_yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
		htmlReporter = new ExtentHtmlReporter("./target/"+ nomeReport+"  " + dateName+ ".html");

		htmlReporter.config().setDocumentTitle("Report de Testes");
		htmlReporter.config().setReportName("Report TDD");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Teste", "Alex Soares");
		extent.setSystemInfo("Browser", "Chrome");
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	public static void statusReported

	(ExtentTest test, WebDriver driver, String testName) throws IOException {

		String caminhoScreen = Screenshot.getScreenshot(driver, testName);

		test.addScreenCaptureFromPath(caminhoScreen);
	}

	public static void quitExtent(ExtentReports extent) {
		extent.flush();
	}
}

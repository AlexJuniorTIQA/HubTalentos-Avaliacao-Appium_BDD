package br.com.rsinet.appium.teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;

import br.com.rsinet.appium.utils.ExtentReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
glue = "br.com.rsinet.appium.stepdefinitions")

public class RunnerTest {
    static ExtentReports test;
	 @BeforeClass
	    public static void test() {
	        test = ExtentReport.setExtent("Pilha de Teste, APP: Advantage Online");
	    }

	 @AfterClass
	 public static void testFinaliza() {
		 ExtentReport.quitExtent(test);
	 }
}

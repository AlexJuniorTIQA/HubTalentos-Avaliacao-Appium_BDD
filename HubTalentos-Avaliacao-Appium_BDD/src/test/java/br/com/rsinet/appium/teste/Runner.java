package br.com.rsinet.appium.teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.aventstack.extentreports.ExtentReports;

import br.com.rsinet.appium.utils.ExtentReport;

@RunWith(Suite.class)
@SuiteClasses({CadastroUsuario.class,ConsultaProdutoTelaInicial.class,ConsultaProdutoBarraDePesquisa.class})

public class Runner {
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

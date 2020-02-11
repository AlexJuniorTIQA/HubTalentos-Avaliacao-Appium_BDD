package br.com.rsinet.appium.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe de mapeamento de elementos: HomePage do app AdvantageOnlineShopping
 **/
public class HomeScreen {

	
	final WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement elementMenu;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement elementIconUser;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement elementIconSearch;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement elementSearch;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewDontHaveAnAccount")
	private WebElement elementCreatNewAccount;

	


	public HomeScreen(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}
	/** Retorna um sendKeys ao elemento Search**/
	public void setSearch(String text) {
		elementSearch.sendKeys(text);
	}
	/** Retorna um click ao Icon Search **/
	public void clickIconSearch() {
		elementIconSearch.click();
	}
	
	/** Retorna um click ao Icone Menu do app **/
	public void clickMenu() {
		
		elementMenu.click();
	}
	/** Retorna um click ao Icone de Usuário **/
	public void clickIconUser() {
		elementIconUser.click();
	}

	/** Retorna um click ao Icone de Criar Nova Conta **/
	public void clickCreatNewAccount() {
		elementCreatNewAccount.click();;
	}
	/** Retorna um getText ao Icone de Criar Nova Conta **/
	public  String getIconUser() {
		return elementIconUser.getText();
		
	}
}

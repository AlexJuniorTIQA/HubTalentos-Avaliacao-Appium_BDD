package br.com.rsinet.appium.screens;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

/**
 * Classe de mapeamento de elementos: Da página de registro do app
 * AdvantageOnlineShopping
 **/

public class RegisterScreen {

	private WebDriver driver;
	private WebDriverWait wait;
	//private RegisterPage pageRegister;
	///////////// Elements: Account Details////////////////
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement elementUserName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement elementEmail;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement elementPassword;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement elementConfirmPassword;

	///////////// Elements: Personal Details////////////////
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement elementFirstName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement elementLastName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement elementPhoneNumber;
/////////////Elements: Adress////////////////
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewCountries")
	private WebElement elementCountry;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]\\r\\n")
	private WebElement elementListCountry;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement elementState;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement elementAdress;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement elementCity;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement elementPostalCode;

/////////////Elements: Check Box////////////////

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.CheckBox[1]")
	private WebElement elementCheckReceiveOffersByEmail;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.CheckBox[2]")
	private WebElement elementCheckConditionsOfUse;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
	private WebElement elementButtonRegister;

	//////////////////////Elements: TextView//////////////////////////////////
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView")
	private WebElement elementPasswordTextView;
	
	
	public RegisterScreen(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "User
	 * Name"
	 **/
	public void setUserName(String username) {
		WebElement element;
		element = elementUserName;
		element.click();
		element.sendKeys(username);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "E-Mail"
	 **/
	public void setEmail(String email) {
		WebElement element;
		element = elementEmail;
		element.click();
		element.sendKeys(email);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de
	 * "Password"
	 **/
	public void setPassword(String password) {
		WebElement element;
		element = elementPassword;
		element.click();
		element.sendKeys(password);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "
	 * Confirm Password"
	 **/
	public void setConfirmPassword(String password) {
		WebElement element;
		element = elementConfirmPassword;
		element.click();
		element.sendKeys(password);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "First
	 * Name"
	 **/
	public void setFirstName(String fistName) {
		WebElement element;
		element = elementFirstName;
		element.click();
		element.sendKeys(fistName);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "Last
	 * Name"
	 **/
	public void setLastName(String lastName) {
		WebElement element;
		element = elementLastName;
		element.click();
		element.sendKeys(lastName);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "Phone
	 * Number"
	 **/
	public void setPhoneNumber(String phoneNumber) {
		WebElement element;
		element = elementPhoneNumber;
		element.click();
		element.sendKeys(phoneNumber);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via SelectByVisibleText ao campo
	 * de "Contry"
	 **/
	public void selectCountry(AndroidDriver<WebElement> driver, String visibleText) {

		WebElement element = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]\r\n"
						+ ""));
		element.click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();

	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "City"
	 **/
	public void setCity(String city) {
		WebElement element;
		element = elementCity;
		element.click();
		element.sendKeys(city);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "Adress"
	 **/
	public void setAdress(String adress) {
		WebElement element;
		element = elementAdress;
		element.click();
		element.sendKeys(adress);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "State"
	 **/
	public void setState(String state) {
		WebElement element;
		element = elementState;
		element.click();
		element.sendKeys(state);
	}

	/**
	 * Recebe um objeto do tipo String e o retorna via sendkeys ao campo de "Postal
	 * Code"
	 **/
	public void setPostalCode(String postalCode) {
		WebElement element;
		element = elementPostalCode;
		element.click();
		element.sendKeys(postalCode);
	}

	/** Retorna um click ao "Check Conditions Of Use" **/
	public void clickCheckConditionsOfUse() {
		elementCheckConditionsOfUse.click();
	}

	/** Retorna um click ao botão "Register" **/
	public void clickButtonRegister() {
		elementButtonRegister.click();
	}

	/**
	 * Retorna cinco clicks ao botão "Register" para ser possivel o AssertEquals
	 **/
	public void clickButtonRegisterFail() {
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
		elementButtonRegister.click();
	}

	/**
	 * Não recebe nenhum parâmetro, efetuada á comparação da mensagem de "User name
	 * already exists" com o "warning" do botão register via getText
	 **/

	/** Retorna um getText ao campo de Password **/
	public  String getIconPassword() {
		return elementPasswordTextView.getText();
		
	}
}

package br.com.rsinet.appium.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Classe de mapeamento de elementos: Pagina de Produtos do site
 * AdvantageOnlineShopping
 **/
public class ProductScreen {

	final WebDriver driver;

	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewProductName")
	private WebElement elementProductName;
	

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewNoProductsToShow")
	private WebElement elementNotFound;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewFilter")
	private WebElement elementFilter;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/frameLayoutProductColor")
	private WebElement elementSelectColor;
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]")
	private WebElement elementIconColorYellow;
	
	public ProductScreen(WebDriver driver) {

		this.driver = driver;
	}
	/**Retorna um click ao nome do Produto**/
	public void clickProduct() {
		elementProductName.click();
	}
	/**Retorna um getText ao nome do Produto**/
	public String getTextProduct() {
		return elementProductName.getText();
	}
	/**Retorna um getText ao elemento Not Found **/
	public String getNotFoundProduct() {
		return elementNotFound.getText();
	}
	/**Retorna um click ao icone de Filtro **/
	public void clickFilter() {
		elementFilter.click();
	}
	/**Retorna um click ao icone de selecionar Cor **/
	public void clickSelectColor() {
		elementSelectColor.click();
	}
	/**Retorna um click ao icone de CorAmarela **/
	public void clickIconColorYellow() {
		elementIconColorYellow.click();
	}
}

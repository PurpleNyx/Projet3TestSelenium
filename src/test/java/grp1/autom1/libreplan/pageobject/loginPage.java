package grp1.autom1.libreplan.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class loginPage {
	
	//methode fixe
	@FindBy(id = "textfield")
	WebElement loginField;
	
	
	@FindBy(id="textfield2")
	WebElement passwordField;
	
	@FindBy(id="button")
	WebElement connectButton;
	
protected final WebDriver driver;
	
	public loginPage(WebDriver driver) {
		super();
		this.driver = driver;

}

public   homePage connexion(String login, String password) throws InterruptedException {
	
	//this.loginField.wait();
	loginField.clear();
	passwordField.clear();
	
	this.loginField.click();
	this.loginField.sendKeys(login);
	this.passwordField.click();
	this.passwordField.sendKeys(password);
	this.connectButton.click();
	
	
	return PageFactory.initElements(driver, homePage.class);
}


}

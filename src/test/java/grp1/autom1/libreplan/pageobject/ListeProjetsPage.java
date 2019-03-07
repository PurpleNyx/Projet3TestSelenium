package grp1.autom1.libreplan.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListeProjetsPage {

	@FindBy(xpath="//span[@class='perspective-active  orders z-button']/descendant::td[contains(text(), 'Liste des projets')]")
	public WebElement menuVerticalDetailProjetAffiche;
	
	@FindBy(xpath="//span[contains(text(), 'PROJET_TEST1')]")
	public WebElement projetTestCree;
	
	
	

	protected final WebDriver driver;

	public ListeProjetsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
}

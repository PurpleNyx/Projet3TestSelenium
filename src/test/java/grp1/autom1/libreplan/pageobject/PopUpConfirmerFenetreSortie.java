package grp1.autom1.libreplan.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpConfirmerFenetreSortie {

	@FindBy(xpath="//div[@class='z-window-modal z-window-modal-shadow']/descendant::div[contains(text(),'Confirmer la fenêtre de sortie')]")
	public WebElement fenetrePopUp;

	@FindBy(xpath="//div[@class='z-window-modal z-window-modal-shadow']/descendant::td[@class='z-button-cm'][contains(text(),'OK')]")
	public WebElement boutonOkPopUp;

	@FindBy(xpath="//div[@class='z-window-modal z-window-modal-shadow']/descendant::td[@class='z-button-cm'][contains(text(),'Annuler')]")
	public WebElement boutonAnnulerPopUp;



	protected final WebDriver driver;

	public PopUpConfirmerFenetreSortie(WebDriver driver){
		super();
		this.driver = driver;
	}

	public ProjectDetails annulerPopUp() {
		boutonAnnulerPopUp.click();
		return PageFactory.initElements(this.driver, ProjectDetails.class);
	}
	
	
	public homePage validerPopUp() {
		boutonOkPopUp.click();
		return PageFactory.initElements(this.driver, homePage.class);
		
	}

}

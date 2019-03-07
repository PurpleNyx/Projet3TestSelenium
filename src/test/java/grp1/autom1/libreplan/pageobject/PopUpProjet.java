package grp1.autom1.libreplan.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpProjet {

	@FindBy(xpath="//div[@id='_z_8-c']")
	public WebElement close1;
	
	
	@FindBy(xpath="//div[contains(text(),'Créer un nouveau projet')]")
	public	WebElement headPopUp;
	
//	- Nom : Champ de saisie non renseigné
	@FindBy(xpath="//span[contains(text(),'Nom')]")
	public	WebElement nom;
	
	@FindBy(xpath="//span[contains(text(),'Nom')]/following::input[@type='text'][1]")
	public WebElement nomField;
//-----------------------------

	
//	- Modèle : Liste déroulante non renseignée
	@FindBy(xpath="//span[contains(text(),'Modèle')]")
	public	WebElement modele;
	
	@FindBy(xpath="//span[contains(text(),'Modèle')]/following::input[@type='text'][1]")
	public	WebElement modeleField;
//-------------------------------------
	
	
//	- Code : Champ de saisie renseigné avec une valeur par défaut non modifiable et grisé. La case "Générer le code" associée à ce champ est cochée par défaut
	@FindBy(xpath="//span[contains(text(),'Code')]")
	public	WebElement code;
	
	@FindBy(xpath="//span[contains(text(),'Code')]/following::input[@type='text'][1]")
	public	WebElement codeField;
	
	@FindBy(xpath="//span[contains(text(),'Code')]/ancestor::tr/descendant::input[@type ='checkbox'][1]")
	public WebElement caseCode;
	
	@FindBy(xpath="//label[contains(text(), 'Générer le code')]")
	public WebElement caseCodeText;
//-------------------------------------
	
	
//	- Date de début : champ de saisie de date associé à un calendrier. Par défaut, la date affichée est la date du jour. Le format de la date correspond à l'exemple suivant : "25 janv. 2017"
	@FindBy(xpath="//span[contains(text(),'Date de début')]")
	public	WebElement dateDebut;
	
	@FindBy(xpath="//span[contains(text(),'Date de début')]/following::input[@type='text'][1]")
	public WebElement dateDebutField;
	
	@FindBy(xpath="//table[@id ='_z_4-mid']")
	public WebElement calendrierDateDebut;
//-----------------------------------
	
	
//	- Echéance : champ de saisie de date associé à un calendrier. Par défaut, le champ n'est pas renseigné.
	@FindBy(xpath="//span[contains(text(),'Echéance')]")
	public	WebElement echeanche;
	
	@FindBy(xpath="//span[contains(text(),'Echéance')]/following::input[@type='text'][1]")
	public	WebElement echeancheField;
	
	
	@FindBy(xpath="//table[@id ='_z_6-mid']")
	public WebElement calendrierEcheance;
//------------------------------------
	
	
//	- Client : Champ de saisie non renseigné
	@FindBy(xpath="//span[contains(text(),'Client')]")
	public	WebElement client;
	
	@FindBy(xpath="//span[contains(text(),'Client')]/following::input[@type='text'][1]")
	public	WebElement clientField;
//---------------------------------
	
	
//	- Calendrier : Liste déroulante avec pour valeur par défaut "Default"
	@FindBy(xpath="//div/span[contains(text(),'Calendrier')]")
	public	WebElement calendrier;
	
	@FindBy(xpath="//div/span[contains(text(),'Calendrier')]/following::input[@type='text'][1]")
	public	WebElement calendrierField;
//---------------------------------
	
	
//	- Boutons [Accepter] 
	@FindBy(xpath="//td[contains(text(),'Accepter')]")
	public	WebElement boutonAccepter;
//------------------------------------
	
	
//  - [Annuler]
	@FindBy(xpath="//td[contains(text(),'Annuler')]")
	public	WebElement boutonAnnuler;
//-----------------------------------
	
	
	@FindBy(xpath="//table[@id='_z_4-mid']/descendant::td[@class='z-calendar-wkday z-calendar-seld']")
	public WebElement dateDuJourCalendrierDateDebut;	
	
	@FindBy(xpath="//table[@id='_z_6-mid']/descendant::td[@class='z-calendar-wkday z-calendar-seld']")
	public WebElement dateDuJourCalendrieEcheance;	
	
	
	
	//Calendrier Echeance
	@FindBy(xpath="//div[@id='_z_4-ry']")
	WebElement boutonMoisSuivant;
	
	@FindBy(xpath="//table[@id='_z_4-mid']/descendant::td[@class='z-calendar-wkday z-calendar-seld']")
	WebElement dateDuJour;

	
	
protected final WebDriver driver;
	
	public PopUpProjet(WebDriver driver){
		super();
		this.driver = driver;
	}
		
		
	
	
	public void fermerAvertissement() {
		close1.click();
	}
	
	
	public void remplirLesChamps(String nom, String modele, String code, String dateDeDebut, String echeance, String client, String calendrier) {
		nomField.sendKeys(nom);
		modeleField.sendKeys(modele);
		codeField.sendKeys(code);
		dateDebutField.sendKeys(dateDeDebut);
		echeancheField.sendKeys(echeance);
		clientField.sendKeys(client);
		calendrierField.sendKeys(calendrier);
	}
	
	public ProjectDetails validerProjet() {
		boutonAccepter.click();
		return PageFactory.initElements(driver, ProjectDetails.class);
	}
	
	public void annulerProjet() {
		boutonAnnuler.click();
	}
	
	public String ajouterNJour(int jourPlus) {
		String dateFinale = "";
		int nbLignes = this.driver.findElements(By.xpath("//table[@id='_z_4-mid']/tbody/tr")).size();
		int nbColonnes = driver.findElements(By.xpath("//table[@id='_z_4-mid']/tbody/tr/td")).size();
		
		
		return dateFinale;
	}
}

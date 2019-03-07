package grp1.autom1.libreplan.pageobject;

//import org.apache.poi.hpsf.Constants;
//import org.apache.poi.poifs.common.POIFSConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
	//Methode Fixe
	@FindBy(xpath ="//button[contains(text(), 'Ressources')] ")
	public WebElement ressourcesMenu;
	//Methode dynamique
	/*String id2 = "r-b";
	@FindBy(xpath = "//img[1]/ancestor::div[1]")
	public WebElement image;
	String sDnmcPart = image.getAttribute("id");
	int s1 =  sDnmcPart.length();
	String id1 = sDnmcPart.substring(0, s1-1);
	String idt = "//button[@id ='"+id1+id2+"')]";
	@FindBy(xpath = idt)
	WebElement ressourcesMenuDynamic;*/
	

	@FindBy(xpath = "//a[@href = '/libreplan/calendars/calendars.zul']")
	public WebElement calendrierLabel;
	
//	@FindBy(xpath = "//div[@id='ganttpanel']")
//	WebElement homePanel;
	
	@FindBy(xpath ="//span[@title='Créer un nouveau projet']")
	public WebElement creerProjetlien;

	@FindBy(xpath="//span[@class='perspective-active  company-scheduling z-button']/descendant::td[contains(text(),'Planification des projets')]")
	public WebElement pagePlanificationProjetActive;

	
	
	//onglets horizontaux ne doit pas etre affiché
	@FindBy(xpath="//li[@class='z-tab']/descendant::span[contains(text(),'Données générales')]")
	public WebElement ongletDonneesGenerales;
	
	
	
	@FindBy(xpath="//button[@class = 'z-menu-btn'][contains(text(), 'Calendrier')]")
	public WebElement boutonCalendrier;
	
	
	
	@FindBy(xpath="//a[@href='/libreplan/planner/index.zul;orders_list']")
	public WebElement boutonProjetsLabel;
	
	
	
	
	
	protected final WebDriver driver;

	public homePage(WebDriver driver) {
		super();
		this.driver = driver;

		
	}

	public calendarListPage accesAlaPageCalendrier(){
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement homePanel = wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//div[@id='ganttpanel']")));
		homePanel.isDisplayed();

	
		ressourcesMenu.click();
		ressourcesMenu.click();
		
		
		//driver.switchTo().frame(0);
		
//		WebElement calendrierLabel = wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("//a[@href = '/libreplan/calendars/calendars.zul']")));
		
		//WebElement calendrierLabel = driver.findElement(By.xpath("a[@href = '/libreplan/calendars/calendars.zul']"));
		
		calendrierLabel.click();
		
		
		
		return PageFactory.initElements(driver, calendarListPage.class);
	}
	
	public PopUpProjet accesPopUpCreerNouveauProjet() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement homePanel = wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//div[@id='ganttpanel']")));
		homePanel.isDisplayed();
		
		creerProjetlien.click();
		
		//driver.switchTo().defaultContent();
		
		return PageFactory.initElements(driver, PopUpProjet.class);
		
	}
	
	
	
	public ListeProjetsPage accesPageListeProjets() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement homePanel = wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//div[@id='ganttpanel']")));
		homePanel.isEnabled();
		
		boutonCalendrier.click();
		boutonCalendrier.click();
		boutonProjetsLabel.click();
		return PageFactory.initElements(this.driver, ListeProjetsPage.class);
	}


}

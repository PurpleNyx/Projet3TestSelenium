package grp1.autom1.libreplan.junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import grp1.autom1.libreplan.pageobject.ListeProjetsPage;
import grp1.autom1.libreplan.pageobject.PlanificationProjetPage;
import grp1.autom1.libreplan.pageobject.PopUpConfirmerFenetreSortie;
import grp1.autom1.libreplan.pageobject.PopUpProjet;
import grp1.autom1.libreplan.pageobject.ProjectDetails;
import grp1.autom1.libreplan.pageobject.homePage;
import grp1.autom1.libreplan.pageobject.loginPage;

public class ProjectAndTaskTest {


	WebDriver driver;


	@Before
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
		driver = new ChromeDriver();
		
		 driver.get("http://127.0.0.1:8080/libreplan");	
	}

	@After
	public void closeBrowser() {

		driver.quit();

	}

	@Test
	public void CreerUnProjet() throws InterruptedException {

		loginPage l = PageFactory.initElements(driver, loginPage.class);

		homePage h = l.connexion("admin", "admin");

		PopUpProjet pp = h.accesPopUpCreerNouveauProjet();

		driver.manage().timeouts().implicitlyWait(900, TimeUnit.MILLISECONDS);

		//pp.fermerAvertissement();

		//pr�sence de la popup
		assertTrue("La POP-UP n'est pas pr�sente", pp.headPopUp.isDisplayed());

		//pr�sence des elemenets de la pop-up et champs vides
		assertTrue("L'�l�ment nom n'est pas pr�sent", pp.nom.isDisplayed());
		assertTrue("Le champ Nom n'est pas pr�sent", pp.nomField.isDisplayed());
		Assert.assertEquals("Le champ Nom est vide","", pp.nomField.getText());


		assertTrue("L'�l�ment modele n'est pas pr�sent", pp.modele.isDisplayed());
		assertTrue("Le champ Nom n'est pas pr�sent", pp.modeleField.isDisplayed());
		Assert.assertEquals("Le champ Nom est vide","", pp.modeleField.getText());


		assertTrue("L'�l�ment code n'est pas pr�sent", pp.code.isDisplayed());
		assertTrue("Le champ Nom n'est pas pr�sent", pp.codeField.isDisplayed());
		assertFalse("Le champ Nom n'est pas modifiable", pp.codeField.isEnabled());
		//Valeur par d�faut � d�finir
		//Assert.assertEquals("Le champ Nom est vide","ORDER0070", pp.codeField.getAttribute("value"));


		assertTrue("L'�l�ment dateDebut n'est pas pr�sent", pp.dateDebut.isDisplayed());
		assertTrue("Le champ dateDebut n'est pas pr�sent", pp.dateDebutField.isDisplayed());


		assertTrue("L'�l�ment echeanche n'est pas pr�sent", pp.echeanche.isDisplayed());
		assertTrue("Le champ echeanche n'est pas pr�sent", pp.echeancheField.isDisplayed());


		assertTrue("L'�l�ment client n'est pas pr�sent", pp.client.isDisplayed());
		assertTrue("Le champ client n'est pas pr�sent", pp.clientField.isDisplayed());


		assertTrue("L'�l�ment calendrier n'est pas pr�sent", pp.calendrier.isDisplayed());
		assertTrue("Le champ calendrier n'est pas pr�sent", pp.calendrierField.isDisplayed());
		Assert.assertEquals("La valeur par defaut n'est pas 'Default'", "Default", pp.calendrierField.getAttribute("value"));


		assertTrue("Le bouton [Accepter] n'est pas pr�sent", pp.boutonAccepter.isDisplayed());


		assertTrue("Le bouton [Annuler] n'est pas pr�sent", pp.boutonAnnuler.isDisplayed());



		//D�cocher la case "generer le code"
		pp.caseCode.click();


		//Renseignement des champs pour la creation d'un projet
		String nom = "PROJET_TEST1";
		String modele = "";
		String code = "PRJTEST001";
		String client = "";
		String calendrier = pp.calendrier.getText();

		//Entrees manuelle des dates
		String dateDeDebut = "28 juil. 2018";
		String echeance = "7 ao�t 2018";
		//------------------------------

		pp.dateDebutField.clear();
		pp.echeancheField.clear();

		pp.remplirLesChamps(nom, modele, code, dateDeDebut, echeance, client, calendrier);


		ProjectDetails pageDetail = pp.validerProjet();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		assertTrue("Le menu affich� n'est pas 'D�tail du projet'", pageDetail.menuVerticalDetailProjetAffiche.isDisplayed());
		assertTrue("L'onglet affich� n'est pas 'WBS (t�ches)'", pageDetail.ongletHorizontalWbsAffiche.isDisplayed());

		//Pr�sence des elements du menu vertival
		assertTrue("L'icone 'Planification des projets' n'est pas pr�sent dans le menu Vertical", pageDetail.menuVerticalPlanificationprojetsPresent.isDisplayed());
		//assertTrue("L'icone 'Chargement des Ressources' n'est pas pr�sent dans le menu Vertical", pageDetail.menuVerticalChargementRessourcesPresent.isDisplayed());
		//assertTrue("L'icone 'Calendrier des Ressources En File' n'est pas pr�sent dans le menu Vertical", pageDetail.menuVerticalCalendrierRessourcesEnFilePresent.isDisplayed());

		//Pr�sence des elements des onglets horizontaux
		assertTrue("l'onglet  'Donnees Generales' n'est pas pr�sent", pageDetail.ongletDonneesGenerales.isDisplayed());


		//Pr�sence eds bouton d'�dition du projet
		assertTrue("le bouton enregistrer n'est pas pr�sent", pageDetail.boutonEnregistrerProjet.isDisplayed());
		assertTrue("le bouton annuler l'edition n'est pas pr�sent", pageDetail.boutonAnnulerEdition.isDisplayed());


		//annuler l'edition (1/4)
		PopUpConfirmerFenetreSortie popUp = pageDetail.annulerEdition();
		assertTrue("La Pop Up n'est pas pr�sente", popUp.fenetrePopUp.isDisplayed());
		assertTrue("Le bouton 'Annuler' n'est pas pr�sent", popUp.boutonAnnulerPopUp.isDisplayed());
		assertTrue("Le bouton 'OK' n'est pas pr�sent", popUp.boutonOkPopUp.isDisplayed());


		//annuler l'edition (2/4)
		ProjectDetails pageDetail2 = popUp.annulerPopUp();

		assertTrue("Le menu affich� n'est pas 'D�tail du projet'", pageDetail2.menuVerticalDetailProjetAffiche.isDisplayed());
		assertTrue("L'onglet affich� n'est pas 'WBS (t�ches)'", pageDetail2.ongletHorizontalWbsAffiche.isDisplayed());


		//annuler l'edition (3/4)
		PopUpConfirmerFenetreSortie popUp2 = pageDetail2.annulerEdition();	
		assertTrue("La Pop Up n'est pas pr�sente", popUp2.fenetrePopUp.isDisplayed());
		assertTrue("Le bouton 'Annuler' n'est pas pr�sent", popUp2.boutonAnnulerPopUp.isDisplayed());
		assertTrue("Le bouton 'OK' n'est pas pr�sent", popUp2.boutonOkPopUp.isDisplayed());


		//annuler l'edition (4/4)
		homePage pageDetail3 = popUp2.validerPopUp();

		assertTrue("Le menu affich� n'est pas 'D�tail du projet'", pageDetail3.pagePlanificationProjetActive.isDisplayed());
		
		//revoir la non pr�sence de l'�l�ment
		//assertFalse("L'onglet horizontal 'WBS (t�ches) est affich�'", pageDetail3.ongletDonneesGenerales.isEnabled());
		
		
		
		//V�rification de la cr�ation du projet
		
		
		ListeProjetsPage lpp = pageDetail3.accesPageListeProjets();
		
		assertTrue("", lpp.menuVerticalDetailProjetAffiche.isDisplayed());
		assertTrue("", lpp.projetTestCree.isDisplayed());


	}

}

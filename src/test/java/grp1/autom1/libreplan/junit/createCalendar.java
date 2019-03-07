package grp1.autom1.libreplan.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import grp1.autom1.libreplan.pageobject.calendarListPage;
import grp1.autom1.libreplan.pageobject.homePage;
import grp1.autom1.libreplan.pageobject.loginPage;

public class createCalendar {
	

	WebDriver driver;
	
	
	@Before
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
		driver = new ChromeDriver();
		
		 driver.get("http://127.0.0.1:8080/libreplan");	
	}
	@Ignore
	@After
public void closeBrowser() {
	
	driver.quit();
	
	}

	@Test
	public void Navigation() throws InterruptedException {
	
		loginPage l = PageFactory.initElements(driver, loginPage.class);
		homePage h = l.connexion("admin", "admin");
	
		calendarListPage c = h.accesAlaPageCalendrier();
		c.creerUnCalendrier();

		
		assertTrue("la colonne Date n'est pas visible", c.colonneDate.isDisplayed());
		
	}

}

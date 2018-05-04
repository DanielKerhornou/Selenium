package orgm2idolibarr;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testdolibarr {
	
	//Définir driver
	ChromeDriver driver = new ChromeDriver();
	
	@Before	
	public void setup(){
	//On instancie le driver
			driver.get("http://demo.testlogiciel.pro/dolibarr");
			
			//user name
			driver.findElement(By.id("username")).sendKeys("jsmith");
			
			//password
			driver.findElement(By.id("password")).sendKeys("hp");
			
			//connection
			driver.findElement(By.className("button")).click();
	}	
	
	@After
	public void teardown() {
			//deconnection
			driver.findElement(By.cssSelector("img.login")).click();
			
			//close browser
			driver.close();	
	
	}
	
	@Test
	public void testConnexion() {
		
			//check element titre		
			Assert.assertEquals("Espace accueil",driver.findElementByClassName("titre").getText());
		
		
	}
	
	@Test
	public void testSaisie() {
				
			//Click on tiers
			driver.findElement(By.cssSelector("div.mainmenu.companies")).click();
				
			//Click on nouveau tiers
			driver.findElement(By.cssSelector("a.vsmenu")).click();
				
			//user name
			driver.findElement(By.name("nom")).sendKeys("toto");
				
			//password
			driver.findElement(By.name("firstname")).sendKeys("titi");
					
			//civilité
			new Select(driver.findElement(By.name("civilite_id"))).selectByVisibleText("Monsieur");
				
			//client
			new Select(driver.findElement(By.name("client"))).selectByVisibleText("Client");
				
			//fournisseur
			new Select(driver.findElement(By.id("fournisseur"))).selectByVisibleText("Non");
				
			//status
			new Select(driver.findElement(By.id("status"))).selectByVisibleText("Clos");
				
			//Enregistrement
			driver.findElement(By.xpath("//input[@value='Créer tiers']")).click();
						
	}
}

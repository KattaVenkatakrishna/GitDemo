package tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.homepage;
import utilities.generalutilities;

public class searchbox_test extends Baseclass {
	homepage hp;
	generalutilities gu;
	
	@Test(priority=1,description = "validate the search box")
	public void senddatasrchbox() throws IOException {
		driver.get("https://www.google.com");
		hp = new homepage(driver);
		WebElement ele = hp.searchbox();
		ele.sendKeys("krishna");
		gu = new generalutilities(driver);
		gu.capturescreenshot("POM");
	}

}

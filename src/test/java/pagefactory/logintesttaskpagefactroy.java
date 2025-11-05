package pagefactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

public class logintesttaskpagefactroy {
	WebDriver driver= new ChromeDriver();
	Logintoapplicationusingpagefactory lp;
	@BeforeClass
	public void setUp() {
		driver.manage().window().maximize();
		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp = new Logintoapplicationusingpagefactory(driver);
	}
	@Test(dataProvider = "data",dataProviderClass = Datasupply.class)
	public void Login_Test(String username, String pwd) throws IOException {
		lp.login(username,pwd);
		if (username.equals("Admin")) {
	        // Verify successful login
	       String products = driver.getTitle();
	        SoftAssert soft = new SoftAssert();
	        soft.assertEquals(products, "OrangeHRM", "Login successful for valid user");
	    } else {
	        // Verify error message for invalid users
	        WebElement msg = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
	        String errormsg = msg.getText();
	        SoftAssert soft = new SoftAssert();
	        soft.assertEquals(errormsg, "Invalid credentials");
	        
	        // Take screenshot
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        File dest = new File("F:\\eclipse-workspace\\POM_Practice\\Screenshot\\error1.png");
	        Files.copy(src, dest);
	    }
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

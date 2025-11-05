package sendingDatatobrowser;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class senddata_to_browser {
	WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dataProvider = "LoginData")
	public void logintest(String user, String pwd, String Exp) throws InterruptedException {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(user);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pwd);
		driver.findElement(By.id("submit")).click();
		
		String exp_title = "Logged In Successfully | Practice Test Automati";
		String act_title=driver.getTitle();
		Thread.sleep(2000);
		
		if(Exp.equals("valid")) {
			if(exp_title.equals(act_title)) {
				Thread.sleep(2000);
				driver.findElement(By.linkText("Log out")).click();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else if(Exp.equals("invalid")) {
			if(exp_title.equals(act_title)) {
				driver.findElement(By.linkText("Log out")).click();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}	
	}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException, InterruptedException {
		String path="F:\\eclipse-workspace\\POM_Practice\\target\\test data\\LoginData.xlsx";
		Excelutility exutility = new Excelutility(path);
		int totalrows = exutility.getRowCount("sheet1");
		int totalcols = exutility.getCellCount("sheet1",1);
		String logindata[][] = new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				logindata[i-1][j]=exutility.getCellData("sheet1", i, j);
				Thread.sleep(2000);
			}
		}
		return logindata;
				
		}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

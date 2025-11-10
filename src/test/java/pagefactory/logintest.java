package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
		
		loginpage lp = new loginpage(driver);
		/*lp.setusername("standard_user");
		lp.setpassword("secret_sauce");
		lp.clicklogin();*/
		lp.login("standard_user", "secret_sauce");

	}

}

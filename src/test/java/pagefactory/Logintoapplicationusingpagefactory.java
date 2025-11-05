package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Logintoapplicationusingpagefactory {
	public static WebDriver driver;
	@FindBy(name="username")
	static WebElement username;
	@FindBy(name="password")
	static WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	static WebElement loginbtn;
	
	public Logintoapplicationusingpagefactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
	}

}

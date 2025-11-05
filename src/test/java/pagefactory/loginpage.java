package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	public static WebDriver driver;
	@FindBy(id="user-name") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login-button") WebElement loginbtn;
	
	public loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setusername(String uname) {
		username.sendKeys(uname);
	}
	public void setpassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clicklogin() {
		loginbtn.click();
	}
}
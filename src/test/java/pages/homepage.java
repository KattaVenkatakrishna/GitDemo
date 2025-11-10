package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Baseclass;

public class homepage extends Baseclass {
	 public homepage(WebDriver driver) {
		 this.driver=driver;
	 }
	 //By using by class
	 
	 By srchboxlocator = By.xpath("//textarea[@name='q']");
	 public WebElement searchbox() {
		 System.out.println("Home page is getting loaded");
			WebElement element = driver.findElement(srchboxlocator);
			System.out.println("Home page is has loaded completly");
			System.out.println("merge the code in the git repository");
			System.out.println("stagging the code into git repsoitory");
			System.out.println("commiting the code into git repository");
			System.out.println("pushing the code into git repository");
			return element;
		
		
	 }

}

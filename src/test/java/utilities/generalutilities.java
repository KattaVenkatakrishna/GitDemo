package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import base.Baseclass;

public class generalutilities extends Baseclass {
public generalutilities(WebDriver driver) {
	this.driver=driver;
}

public void capturescreenshot(String name) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Users\\91832\\eclipse-workspace\\POM_Practice\\Screenshot\\"+name+".png");
	Files.copy(src, dest);
}
}

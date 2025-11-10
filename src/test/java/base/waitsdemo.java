package base;

import java.time.Duration;

import org.testng.annotations.Test;

public class waitsdemo extends Baseclass1 {
	@Test
	public void sleep() throws InterruptedException {
		Thread.sleep(2000);
	}
	@Test
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void explicitwait() {
		System.out.println("wait for some time!");
	}

}

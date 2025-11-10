package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;

public class URL_Launch extends Baseclass {

	@Test
	public void tc1() {
		driver.get("https://www.google.com");
		String expected = "Google";
		String actual = driver.getTitle();
		System.out.println("The actual title is :"+actual);
		Assert.assertEquals(expected, actual, "Failed");
	}
}

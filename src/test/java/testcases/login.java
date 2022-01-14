package testcases;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Landingpage;
import POM.Login;
import resources.Base;

public class login extends Base {
	
	

	@Test
	public void test1() throws Exception
	{
		WebDriver d=initialmethd();
		Properties prop= getProperties();
	String url = prop.getProperty("swiggyurl");
	d.get(url);
	Landingpage lp= new Landingpage(d);
	lp.getLoginLink().click();
	Login l =new Login(d);
	l.getPhoneNumber().sendKeys("111222333");
	l.getLogin().click();
	String msg = l.getErrormsg().getText().toLowerCase();
	Assert.assertTrue(msg.contains("number"));
	}
}

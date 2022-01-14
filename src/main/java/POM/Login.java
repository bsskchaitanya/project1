package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login { 
	 WebDriver d; 
	private By PhoneNumber = By.id("mobile");
	private By Login = By.cssSelector(".a-ayg");
	private By errormsg = By.cssSelector("label._1Cvlf._2tL9P.A7Y41");
	public Login(WebDriver d){
		this.d=d;
	}
	public WebElement getPhoneNumber() {
		return d.findElement(PhoneNumber);
	}
	public WebElement getLogin() {
		return d.findElement(Login);
	}
	public WebElement getErrormsg() {
		return d.findElement(errormsg);
	}
}

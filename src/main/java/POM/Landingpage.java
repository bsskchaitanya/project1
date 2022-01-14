package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	private WebDriver d;
	private By LoginLink = By.cssSelector(".x4bK8");
	private By SignUpLink = By.className("r2iyh");
	public Landingpage(WebDriver d){
		this.d=d;
	}
	public WebElement getLoginLink() {
		return d.findElement(LoginLink);
	}
	
	public WebElement getSignUpLink() {
		return d.findElement(SignUpLink);
	}
	
	
	
}

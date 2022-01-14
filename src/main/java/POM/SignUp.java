package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp {
	private WebDriver d;
	private By mobile = By.id("mobile");
	private By name = By.id("name");
	private By email = By.id("email");
	private By password = By.id("password");
	private By submit = By.className("a-ayg");
	private By referralCode = By.className("_3GOZo");
	private By otp = By.id("otp");
	private By VERIFY_OTP = By.linkText("VERIFY OTP");
	private By error = By.className("_3--N8");
	public SignUp(WebDriver d){
		this.d=d;
	}
	public WebElement getMobile() {
		return d.findElement(mobile);
	}
	public WebElement getName() {
		return d.findElement(name);
	}
	public WebElement getEmail() {
		return d.findElement(email);
	}
	public WebElement getPassword() {
		return d.findElement(password);
	}
	public WebElement getSubmit() {
		return d.findElement(submit);
	}
	public WebElement getReferralCode() {
		return d.findElement(referralCode);
	}
	public WebElement getotp() {
		return d.findElement(otp);
	}
	public WebElement getVERIFY_OTP() {
		return d.findElement(VERIFY_OTP);
	}
	public WebElement getError() {
		return d.findElement(error);
	}
}

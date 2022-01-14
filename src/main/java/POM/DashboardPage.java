package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	WebDriver d;

	private By AccountName = By.cssSelector("a[title='View Account']");
	private By FIND_FOOD = By.cssSelector("a[class='_3iFC5'] span");

	public DashboardPage(WebDriver d) {
		this.d = d;
	}

	public WebElement getAccountName() {
		return d.findElement(AccountName);
	}

	public WebElement getFIND_FOOD() {
		return d.findElement(FIND_FOOD);
	}
}

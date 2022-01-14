package testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Landingpage;
import POM.Login;
import POM.SignUp;
import resources.Base;

public class createaccount extends Base{
@Test
public void createaccount() throws IOException
{
	WebDriver d=initialmethd();
	Properties prop= getProperties();
String url = prop.getProperty("swiggyurl");
d.get(url);
Landingpage lp= new Landingpage(d);
lp.getSignUpLink().click();
SignUp s= new SignUp(d);
s.getMobile().sendKeys("9999912345");
s.getName().sendKeys("rebel");
s.getEmail().sendKeys("rebel@gmail.com");
s.getPassword().sendKeys("Rebel@123");
s.getSubmit().click();
s.getotp().sendKeys("1234");
s.getVERIFY_OTP().click();
System.out.println(s.getError().getText());
}
}

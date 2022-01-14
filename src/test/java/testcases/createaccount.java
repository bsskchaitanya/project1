package testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.DashboardPage;
import POM.Landingpage;
import POM.Login;
import POM.SignUp;
import resources.Base;

public class createaccount extends Base {
	@Test
	public void createaccount() throws IOException {
		ArrayList<ArrayList<String>> al = getDimensionalData("Account Creation");
		System.out.println(al.size());
		for(int i=0;i<al.size();i++){
			WebDriver d = initialmethd();
			Properties prop = getProperties();
			String url = prop.getProperty("swiggyurl");
			d.get(url);
			Landingpage lp = new Landingpage(d);
			lp.getSignUpLink().click();
			SignUp s = new SignUp(d);
			s.getMobile().sendKeys(al.get(i).get(0));
			s.getName().sendKeys(al.get(i).get(1));
			s.getEmail().sendKeys(al.get(i).get(2));
			s.getPassword().sendKeys(al.get(i).get(3));
			s.getSubmit().click();
			/*s.getotp().sendKeys("1234");
			s.getVERIFY_OTP().click();
			System.out.println(s.getError().getText());*/
			d.quit();
		}
		
		
	}
}

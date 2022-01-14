package testcases;

import java.io.FileInputStream;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.DashboardPage;
import POM.Landingpage;
import POM.Login;
import resources.Base;

public class login extends Base {

	@Test
	public void test1() throws Exception {
		ArrayList<String> al = getData("Login");
		for (int i = 0; i < al.size(); i++) {
			WebDriver d = initialmethd();
			Properties prop = getProperties();
			String url = prop.getProperty("swiggyurl");
			d.get(url);
			Landingpage lp = new Landingpage(d);
			lp.getLoginLink().click();
			Login l = new Login(d);
			l.getPhoneNumber().sendKeys(al.get(i));
			System.out.print(al.get(i));
			l.getLogin().click();
			if (al.get(i).length() < 10) {
				String msg = l.getErrormsg().getText().toLowerCase();
				Assert.assertTrue(msg.contains("number"));
			} else {				
				/*DashboardPage dp= new DashboardPage(d);
				System.out.println(dp.getAccountName().getText());*/
				System.out.println("success");
			}

			d.quit();
		}

	}
}

package script;
import org.testng.annotations.Test;
import generic.Baseclass;
import generic.excel;
import page.EnterPage;
import page.LoginPage;

public class CheckValidLogin extends Baseclass {
	@Test(priority=1,groups= {"login","smoke"})
	public void testValidLogin() {
		String un=excel.getValue(XL_PATH,"ValidLogin",1,0);
		String pw=excel.getValue(XL_PATH, "ValidLogin",1,1);
		String eTitle=excel.getValue(XL_PATH,"ValidLogin",1,2);
		LoginPage l=new LoginPage(driver);
		//Enter Valid UN
		l.setUserName(un);
		//Enter Valid pw
		l.setPassword(pw);
		//Click login
		l.clickLogin();
		//verify home page....
		EnterPage e=new EnterPage(driver);
		e.verifyHomePageIsDisplayed(driver, eTitle);
	}
}



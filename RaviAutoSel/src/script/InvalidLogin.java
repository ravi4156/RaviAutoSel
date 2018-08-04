package script;

import generic.Baseclass;
import org.testng.annotations.Test;
import generic.excel;
import page.LoginPage;

public class InvalidLogin extends Baseclass {
	@Test(priority=2,groups= {"login"})
	public void testbInvalidLogin() throws InterruptedException {
		int rc=excel.getRowCount(XL_PATH, "InvalidLogin");
		for(int i=1;i<=rc;i++) {
		String un=excel.getValue(XL_PATH,"InvalidLogin",i,0);
		String pw=excel.getValue(XL_PATH,"InvalidLogin",i,1);
		String expectedMSG=excel.getValue(XL_PATH,"InvalidLogin",i,2);
		LoginPage l=new LoginPage(driver);
		//Enter invalid user name
		l.setUserName(un);
		//Enter invalid password
		l.setPassword(pw);
		//Click login
		l.clickLogin();
		Thread.sleep(1000);
		//Verify err msg
		l.verifyErrMsg(expectedMSG);
		Thread.sleep(2000);
		}
	}

}


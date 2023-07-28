package Test;

import org.testng.annotations.Test;

import Base.BaseClass_TA;
import PageObjectModel.AnonymousAccount;
import PageObjectModel.LoginPage;
import PageObjectModel.SigninWithGoogleOption;


public class TestClass2 extends BaseClass_TA{
	
	//@Test 
	public void LoginwithAnonymousAccOption() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.PrivacyPolicyDes("I ACCEPT THE TREMS");
		AnonymousAccount anonymousAcc = new AnonymousAccount(driver);
		anonymousAcc.ClickOnanonymousButton();
		anonymousAcc.ClickOnCountryName();
		Thread.sleep(5000);
	}
	
    @Test 
	public void SigninwithGoogleOption() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.PrivacyPolicyDes("I ACCEPT THE TREMS");
		SigninWithGoogleOption signinwithgoogleoption = new SigninWithGoogleOption(driver);
		signinwithgoogleoption.SignUpWithGoogleOption("pratikm755@gmail.com", "86557387");
	}


}

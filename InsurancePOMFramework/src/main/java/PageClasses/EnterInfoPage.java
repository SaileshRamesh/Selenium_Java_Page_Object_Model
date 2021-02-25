package PageClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class EnterInfoPage extends PageBaseClass {
	
	public EnterInfoPage(WebDriver driver, ExtentTest logger){
		super(driver, logger);
	}
	private static Logger logg = LogManager.getLogger(EnterInfoPage.class);
	
	@FindBy(xpath="//*[@id='firstName-insured-0']/span[2]/input")
	public WebElement FirstNameBtn;
	
	@FindBy(xpath="//*[@id='lastName-insured-0']/span[2]/input")
	public WebElement LastNameBtn;
	
	@FindBy(xpath="//*[@id='emailAddress-insured-0']/span[2]/input")
	public WebElement EmailTB;
	
	@FindBy(xpath="//*[@id='streetAddress-insuredLocation-0']/span[2]/input")
	public WebElement streetAdressTB;
	
	@FindBy(xpath="//*[@id='additionalStreetAddress-insuredLocation-0']/span[2]/input")
	public WebElement aptNoTB;
	
	@FindBy(xpath="//*[@id='customerLivesHere-insured-0']/div[2]/div/div[3]/label/span")
	public WebElement howLongCB;
	
	@FindBy(xpath="//*[@id='unitsInBuilding-insuredLocation-0_selectNode']")
	public WebElement typeBuildingDP;
	
	@FindBy(xpath="//*[@id='dateOfBirth-insured-0']/div/label[1]/select")
	public WebElement DOBMMDP;
	
	@FindBy(xpath="//*[@id='dateOfBirth-insured-0']/div/label[2]/input")
	public WebElement dateTB;
	
	@FindBy(xpath="//*[@id='dateOfBirth-insured-0']/div/label[3]/input")
	public WebElement yearTB;
	
	@FindBy(xpath="//*[@id='phoneNumber-insured-0']/span[2]/div/div/input")
	public WebElement phoneTB;
	
	@FindBy(xpath="//*[@id='autoPolicyWithLibertyIndicator-insuranceHistory-0']/div[2]/div/div[2]/label")
	public WebElement currentlyCB;
	
	@FindBy(xpath="//*[@id='coverageC-insured-0_selectNode']")
	public WebElement stuffDP;
	
	@FindBy(xpath="//*[@id='nextButton-0']")
	public WebElement GetYourQuoteBtn;
	
	public void assertTitle(String expected){
    	try{
    		logger.log(Status.PASS, "Successfully verified the pageTitle of Landing page " + expected);
			logg.info("Successfully verified the pageTitle of Landing page " + expected);
    	    String actual = driver.getTitle();
    	    Assert.assertEquals(actual, expected);
    	}catch(Exception e){
    		reportFail(e.getMessage());
    		logg.debug("Error while verifying the page title "+expected);
    	}
    	
    }
	
	public void enterFirstName(String FirstName){
		try{
			logg.info("The string successfully entered in FirstName " + FirstName);
		    FirstNameBtn.sendKeys(FirstName);
		    logger.log(Status.PASS, "FirstName entered successfully " + FirstName);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering the first name" + e.getMessage());
		}
	}
	
	public void enterLastName(String LastName){
		try{
			logg.info("The string successfully entered in Lastname " + LastName);
			LastNameBtn.sendKeys(LastName);
		    logger.log(Status.PASS, "LastName entered successfully " + LastName);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering LastName" +e.getMessage());
		}
	}
	
	public void enterEmail(String Email){
		try{
			logg.info("The string successfully entered in Email " + Email);
			EmailTB.sendKeys(Email);
		    logger.log(Status.PASS, "Email entered successfully " + Email);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering Email" +e.getMessage());
		}
	}
	
	public void enterStreet(String Street){
		try{
			logg.info("The string successfully entered in Street " + Street);
			streetAdressTB.sendKeys(Street);
		    logger.log(Status.PASS, "Street Adress entered successfully " + Street);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering Street" +e.getMessage());
		}
	}
	
	public void enterAptNo(String AptNo){
		try{
			logg.info("The string successfully entered in AptNo " + AptNo);
			aptNoTB.sendKeys(AptNo);
		    logger.log(Status.PASS, "Apartment Number Adress entered successfully " + AptNo);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering Apartment Number" +e.getMessage());
		}
	}
	
	public void enterHowLongCB(){
		try{
			logg.info("The How long you've lived entered successfully");
		    howLongCB.click();
		    logger.log(Status.PASS, "Check Box How Long You've lived checked successfully");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while clicking How long you've lived");
		}
	}
	
	public void selectTypeBuilding(String text){
		try{
			logg.info("The Building type selected successfully " + text );
		    Select select = new Select(typeBuildingDP);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "The Building type has been selected successfully " + text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while selecting Building type " + e.getMessage());
		}
	}
	
	public void selectDOBMM(String text){
		try{
			logg.info("Month of Date of Birth entered successfully " +text);
		    Select select = new Select(DOBMMDP);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "The Month of the Date of Birth is been successfully selected " + text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering the month of the Date of birth " + e.getMessage());
		}
	}
	
	public void enterdate(String date){
		try{
			logg.info("Date of Date of Birth entered successfully "+date);
		    dateTB.sendKeys(date);
		    logger.log(Status.PASS, "The date is successfully entered "+date );
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering the Date of the Date of birth " + e.getMessage());
		}
	}
	
	public void enterYear(String year){
		try{
			logg.info("Year of Date of Birth entered successfully" + year);
		yearTB.sendKeys(year);
		logger.log(Status.PASS, "The year has been entered successfully "+year);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering the Year of the Date of birth " + e.getMessage());
		}
	}
	
	public void enterPhone(String phone){
		try{
			logg.info("Phone entered successfully" + phone);
		   phoneTB.sendKeys(phone);
		   logger.log(Status.PASS, "Phone number entered successfully "+phone);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering phone " + e.getMessage());
		}
	}
	
	public void clickCurrently(){
		try{
			logg.info("The currently checkbox checked successfully");
		    currentlyCB.click();
		    logger.log(Status.PASS, "Currently policy checkBox clicked successfully ");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while checking the checkbox" + e.getMessage());
		}
	}
	
	public void selectStuff(String text){
		try{
			logg.info("The stuff worth selected successfully "+text);
		    Select select = new Select(stuffDP);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "The stuff worth dropdown been selected successfully "+text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while selecting the stuff worth" + e.getMessage());
		}
	}
	
	/*****************Verify Error Messages for Null***********/
	
	@FindBy(xpath="//*[@id='emailAddress-insured-0']/span[2]/span")
	public WebElement errorMail;
	
	@FindBy(xpath="//*[@id='streetAddressCombined-0']/div/span")
	public WebElement errorStreetMail;
	
	@FindBy(xpath="//*[@id='customerLivesHere-insured-0']/div[2]/span")
	public WebElement errorHowLong;
	
	@FindBy(xpath="//*[@id='unitsInBuilding-insuredLocation-0']/span[2]/span")
	public WebElement errorType;
	
	@FindBy(xpath="//*[@id='dateOfBirth-insured-0']/div/span")
	public WebElement errorDOB;
	
	@FindBy(xpath="//*[@id='phoneNumber-insured-0']/span[2]/span")
	public WebElement errorPhone;

	@FindBy(xpath="//*[@id='autoPolicyWithLibertyIndicator-insuranceHistory-0']/div[2]/span")
    public WebElement errorCurrently;
	
	@FindBy(xpath="//*[@id='coverageC-insured-0']/span[2]/span")
	public WebElement errorRoughly;
	
	public void verifyEmailMessage(String expected){
		try{
		    String actual=errorMail.getText();
		    Assert.assertEquals(actual, expected);
		    logger.log(Status.PASS, "Succesfully verified the errorMessage for Mail error Message");
		    logg.info("Succesfully verified the errorMessage for Mail error Message");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while verifying the errorMessage " + e.getMessage());
		}
	}
	
	public void verifyStreetMail(String expected){
		try{
			logg.info("Succesfully verified the Street Adress error Message");
		    String actual=errorStreetMail.getText();
		    Assert.assertEquals(actual, expected);
		    logger.log(Status.PASS, "Succesfully verified the Street Adress error Message");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while verifying the streetMail " + e.getMessage());
		}
	}
	
	public void verifyHowLong(String expected){
		try{
			logg.info("Succesfully verified the How Long You've lived checkbox error Message");
		    String actual=errorHowLong.getText();
		    Assert.assertEquals(actual, expected);
		    logger.log(Status.PASS, "Succesfully verified the How Long You've lived checkbox error Message");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while veryfying the HowLong"+e.getMessage());
		}
	}
	
	public void verifyType(String expected){
		try{
			logg.info("Succesfully verified the type of Building error Message");
		    String actual=errorType.getText();
		    Assert.assertEquals(actual, expected);
		    logger.log(Status.PASS, "Succesfully verified the type of Building error Message");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while veryfying the verifyType"+e.getMessage());
		}
	}
	
	public void verifyDOB(String expected){
		try{
		    String actual=errorDOB.getText();
		    Assert.assertEquals(actual, expected);
		    logger.log(Status.PASS, "Succesfully verified DOB error Message");
		    logg.info("Succesfully verified DOB error Message");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while verifying DOB error message" + e.getMessage());
		}
	}
	
	public void verifyPhone(String expected){
		try{
		    String actual=errorPhone.getText();
		    Assert.assertEquals(actual, expected);
		    logg.info("Succesfully verified Phone field error Message");
		    logger.log(Status.PASS, "Succesfully verified Phone field error Message");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while verifying phone error Message "+e.getMessage());
		}
	}
	
	public void verifyCurrently(String expected){
		try{
		    String actual=errorCurrently.getText();
		    Assert.assertEquals(actual, expected);
		    logger.log(Status.PASS, "Succesfully verified Currently field error Message");
		    logg.info("Succesfully verified Currently field error Message");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while verifying the Currently field error Message" + e.getMessage());
		}
	}
	
	public void verifyRoughly(String expected){
		try{
		    String actual=errorRoughly.getText();
		    Assert.assertEquals(actual, expected);
		    logger.log(Status.PASS, "Succesfully verified Roughly field error Message");
		    logg.info("Succesfully verified Roughly field error Message");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while verifying Rougly message "+e.getMessage());
		}
	}
	
	/*****************Verify Error Messages for Invalid***********/
	@FindBy(xpath="//*[@id='emailAddress-insured-0']/span[2]/span")
	public WebElement invalidEmail;
	
	@FindBy(xpath="//*[@id='streetAddressCombined-0']/div/span")
	public WebElement invalidAddress;
	
	@FindBy(xpath="//*[@id='dateOfBirth-insured-0']/div/span")
	public WebElement invalidDOB;
	
	@FindBy(xpath="//*[@id='phoneNumber-insured-0']/span[2]/span")
	public WebElement invalidPhone;
	
	public void verifyInvalidEmail(String expected){
		try{
			String actual=invalidEmail.getText();
			Assert.assertEquals(actual, expected);
			logger.log(Status.PASS, "Successfully verified Invalid Email Error Message" + expected);
			logg.info("Successfully verified Invalid Email Error Message" + expected);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while verying message "+ e.getMessage());
		}
	}
	
	public void verifyInvalidAddress(String expected){
		try{
			String actual=invalidAddress.getText();
			Assert.assertEquals(actual, expected);
			logger.log(Status.PASS, "Successfully verified Invalid Address Error Message" + expected);
			logg.info("Successfully verified Invalid Address Error Message" + expected);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.info("Error while verfying Invalid Address "+e.getMessage());
		}
	}
	
	public void verifyInvalidDOB(String expected){
		try{
			String actual=invalidDOB.getText();
			Assert.assertEquals(actual, expected);
			logger.log(Status.PASS, "Successfully verified Invalid DOB Error Message" + expected);
			logg.info("Successfully verified Invalid DOB Error Message" + expected);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while veryfying the error message "+expected);
		}
	}
	
	public void verifyInvalidPhone(String expected){
		try{
			String actual=invalidPhone.getText();
			Assert.assertEquals(actual, expected);
			logger.log(Status.PASS, "Successfully verified Invalid Phone Error Message " + expected);
			logg.info("Successfully verified Invalid Phone Error Message " + expected);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while veryfying error verifyInvalidPhone "+expected);
		}
	}
	
	//All the webElements and operations related to the page
	public GetQuotePage enterDetails(){
		    GetYourQuoteBtn.click();
		    logger.log(Status.PASS, "Successfully entered the GetQuotePage");
		    GetQuotePage getQuotePage=new GetQuotePage(driver , logger);
		    PageFactory.initElements(driver, getQuotePage);
		    return getQuotePage;
	}	

}

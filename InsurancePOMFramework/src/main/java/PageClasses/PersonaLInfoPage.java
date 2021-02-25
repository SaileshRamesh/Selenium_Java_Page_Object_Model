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

public class PersonaLInfoPage extends PageBaseClass {
	
private static Logger logg = LogManager.getLogger(PersonaLInfoPage.class);
	
	public PersonaLInfoPage(WebDriver driver, ExtentTest logger){
		super(driver,logger);
	}
	
	@FindBy(xpath="//*[@id='firstName-insured-0']/span[2]/input")
	public WebElement FnameTB;
	
	@FindBy(xpath="//*[@id='lastName-insured-0']/span[2]/input")
	public WebElement LnameTB;
	
	@FindBy(xpath="//*[@id='dateOfBirth-insured-0']/div/label[1]/select")
	public WebElement DOBMMDP;
	
	@FindBy(xpath="//*[@id='dateOfBirth-insured-0']/div/label[2]/input")
	public WebElement dateTB;
	
	@FindBy(xpath="//*[@id='dateOfBirth-insured-0']/div/label[3]/input")
	public WebElement yearTB;
	
	@FindBy(xpath="//*[@id='phoneNumber-insured-0']/span[2]/div/div/input")
	public WebElement phoneTB;
	
	@FindBy(xpath="//*[@id='emailAddress-insured-0']/span[2]/input")
	public WebElement EmailTB;
	
	@FindBy(xpath="//*[@id='nextButton-1']")
	public WebElement nextBtn;
	
	@FindBy(xpath="//*[@id='pane-header-YI02-0']/h1")
	public WebElement title;
	
	public void assertText(String expected){
		try{
    		logger.log(Status.PASS, "Successfully verified the text of YourInfo page " + expected);
			logg.info("Successfully verified the pageTitle of YourInfo page " + expected);
    	    String actual = title.getText();
    	    Assert.assertEquals(actual, expected);
    	}catch(Exception e){
    		reportFail(e.getMessage());
    		logg.debug("Error while verifying the text of YourInfo page "+expected);
    	}
	}
	
	public void enterFname(String Fname) {
		try {
			FnameTB.sendKeys(Fname);
			logger.log(Status.PASS, "Entered the FirstName Succesfully " + Fname);
			logg.info("Entered the LastName successfully " + Fname);
		} catch (Exception e) {
			reportFail(e.getMessage());
			logg.debug("Error while entering the FirstName " + Fname);
		}
	}
	
	public void enterLname(String Lname) {
		try {
			LnameTB.sendKeys(Lname);
			logger.log(Status.PASS, "Entered the LastName Succesfully " + Lname);
			logg.info("Entered the street LastName successfully " + Lname);
		} catch (Exception e) {
			reportFail(e.getMessage());
			logg.debug("Error while entering the LastName " + Lname);
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
	
	public CurrentInsurancePage saveAndContinue(){
		nextBtn.click();
		logger.log(Status.PASS, "Next Button clicked successfully and proceeded");
		logg.info("Next Button clicked successfully and proceeded");
		CurrentInsurancePage currentInsurancePage = new CurrentInsurancePage(driver, logger);
		PageFactory.initElements(driver, currentInsurancePage);
		return currentInsurancePage;
	}

}

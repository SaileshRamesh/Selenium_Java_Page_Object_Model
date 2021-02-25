package PageClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class YourInfoPage extends PageBaseClass {

	private static Logger logg = LogManager.getLogger(YourInfoPage.class);

	public YourInfoPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath="//*[@id='question-insuredLocation-address-0']/h2")
	public WebElement title;

	@FindBy(xpath = "//*[@id='streetAddress-insuredLocation-0']/span[2]/input")
	public WebElement streetAdd;

	@FindBy(xpath = "//*[@id='additionalStreetAddress-insuredLocation-0']/span[2]/input")
	public WebElement AptUnit;

	@FindBy(xpath = "//*[@id='currentAddressSameAsLocationAddressIndicator-insured-0']/div[2]/div/div[1]/label")
	public WebElement currentlyCheck;

	@FindBy(xpath = "//*[@id='nextButton-0']")
	public WebElement nextBtn;
	
	
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

	public void enterStreetAdd(String stretAdd) {
		try {
			streetAdd.sendKeys(stretAdd);
			logger.log(Status.PASS, "Entered the street Address Succesfully " + stretAdd);
			logg.info("Entered the street Address successfully " + stretAdd);
		} catch (Exception e) {
			reportFail(e.getMessage());
			logg.debug("Error while entering the Address " + stretAdd);
		}
	}

	public void enterAptUnit(String aptUnit) {
		try {
			AptUnit.sendKeys(aptUnit);
			logger.log(Status.PASS, "Entered the AptUnit Succesfully " + aptUnit);
			logg.info("Entered the AptUnit successfully " + aptUnit);
		} catch (Exception e) {
			reportFail(e.getMessage());
			logg.debug("Error while entering the Aptunit " + aptUnit);
		}
	}

	public void currentlyCheck() {
		try {
			currentlyCheck.click();
			logger.log(Status.PASS, "Entered the Currently Live here checkBox checked Succesfully");
			logg.info("Entered the Currently Live here checkBox checked Succesfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
			logg.debug("Error in clicking Currently Live here checkBox");
		}
	}

	public PersonaLInfoPage nextBtnClick() {
			nextBtn.click();
			logger.log(Status.PASS, "Next Button clicked successfully and proceeded");
			logg.info("Next Button clicked successfully and proceeded");
			PersonaLInfoPage personaLInfoPage = new PersonaLInfoPage(driver, logger);
			PageFactory.initElements(driver, personaLInfoPage);
			return personaLInfoPage;
	}
	

}

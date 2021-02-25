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

public class SavingsPage extends PageBaseClass{
	
	private static Logger logg = LogManager.getLogger(SavingsPage.class);

	public SavingsPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath="//*[@id='highestEducationLevel-insured-0_selectNode']")
	public WebElement highestEducation;
	
	@FindBy(xpath="//*[@id='employmentStatus-insured-0_selectNode']")
	public WebElement employmentStatus;
	
	@FindBy(xpath="//*[@id='nextButton-0']")
	public WebElement getQuote;
	
	@FindBy(xpath="//*[@id='pane-header-DM01-0']/h1")
	public WebElement title;
	
	public void assertText(String expected){
		try{
    		logger.log(Status.PASS, "Successfully verified the text of YourInfo page " + expected);
			logg.info("Successfully verified the pageTitle of YourInfo page " + expected);
    	    Assert.assertEquals(title.getText(), expected);
    	}catch(Exception e){
    		reportFail(e.getMessage());
    		logg.debug("Error while verifying the text of YourInfo page "+expected);
    	}
	}
	
	public void selecthighestEducation(String text){
		try{
			logg.info("The highestEducation selected successfully " + text );
		    Select select = new Select(highestEducation);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "The highestEducation has been selected successfully " + text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while selecting highestEducation " + e.getMessage());
		}
	}
	
	public void selectemploymentStatus(String text){
		try{
			logg.info("The employmentStatus selected successfully " + text );
		    Select select = new Select(employmentStatus);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "The employmentStatus has been selected successfully " + text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while selecting employmentStatus " + e.getMessage());
		}
	}
	
	public GetCondoQuote click(){
		getQuote.click();
		logger.log(Status.PASS, "Next Button clicked successfully and proceeded");
		logg.info("Next Button clicked successfully and proceeded");
		GetCondoQuote getCondoQuote = new GetCondoQuote(driver, logger);
		PageFactory.initElements(driver, getCondoQuote);
		return getCondoQuote;
	}
	

}

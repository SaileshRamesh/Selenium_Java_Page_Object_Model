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

public class CurrentInsurancePage extends PageBaseClass {
	
	private static Logger logg = LogManager.getLogger(CurrentInsurancePage.class);
	
	public CurrentInsurancePage(WebDriver driver, ExtentTest logger){
		super(driver,logger);
	}
   
	@FindBy(xpath="//*[@id='propertyCurrentlyInsuredCode-insuranceHistory-0_selectNode']")
	public WebElement DoYou;
	
	@FindBy(xpath="//*[@id='policyCancellationIndicator-insuranceHistory-0']/div[2]/div/div[2]/label")
	public WebElement policyCancellation;
	
	@FindBy(xpath="//*[@id='autoPolicyWithLibertyIndicator-insuranceHistory-0']/div[2]/div/div[2]/label")
	public WebElement autoPolicy;
	
	@FindBy(xpath="//*[@id='claimLossIndicator-insuranceHistory-0']/div[2]/div/div[2]/label")
	public WebElement claimLoss;
	
	@FindBy(xpath="//*[@id='nextButton-0']")
	public WebElement nextBtn;
	
	@FindBy(xpath="//*[@id='pane-header-CI01-0']/h1")
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
	
	public void selectDoYou(String text){
		try{
			logg.info("Month of Date of Birth entered successfully " +text);
		    Select select = new Select(DoYou);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "The Month of the Date of Birth is been successfully selected " + text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering the month of the Date of birth " + e.getMessage());
		}
	}
	
	public void policyCancellation(){
		try{
			logg.info("policyCancellation clicked successfully");
			policyCancellation.click();
		    logger.log(Status.PASS, "policyCancellation clicked successfully");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while clicking policyCancellation");
		}
	}
	
	public void autoPolicy(){
		try{
			logg.info("autoPolicy clicked successfully");
			autoPolicy.click();
		    logger.log(Status.PASS, "autoPolicy clicked successfully");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while clicking autoPolicy");
		}
	}
	
	public void claimLoss(){
		try{
			logg.info("claimLoss clicked successfully");
			claimLoss.click();
		    logger.log(Status.PASS, "claimLoss clicked successfully");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while clicking claimLoss");
		}
	}
	
	public PropertyInfoPage saveAndContinue(){
		nextBtn.click();
		logger.log(Status.PASS, "Next Button clicked successfully and proceeded");
		logg.info("Next Button clicked successfully and proceeded");
		PropertyInfoPage propertyInfoPage = new PropertyInfoPage(driver, logger);
		PageFactory.initElements(driver, propertyInfoPage);
		return propertyInfoPage;
	}
}

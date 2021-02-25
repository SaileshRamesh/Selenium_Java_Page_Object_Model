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

public class LandingPage extends PageBaseClass {
	
	private static Logger logg = LogManager.getLogger(LandingPage.class);
	
	public LandingPage(WebDriver driver, ExtentTest logger){
		super(driver,logger);
	}
	
    @FindBy(xpath="//body/div[@id='__next']/main[1]/div[1]/main[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]")
    public WebElement propertyBtn;
	
    @FindBy(xpath="//*[@id='quoteModuleForm']/div/div/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/button[2]")
    public WebElement RentersBtn;
    
    @FindBy(xpath="//*[@id='alphaNumericInput1-input']")
    public WebElement zipCodeTB;
    
    @FindBy(xpath="//*[@id='quoteModuleForm']/div/div/div[1]/div[3]/div/div/div/div/div/div[3]/button")
    public WebElement GetPriceBtn;
    
    @FindBy(xpath="//*[@id='quoteModuleForm']/div/div/div[1]/div[3]/div/div/div/div/div/div[1]/div/ul/li")
    public WebElement ErrorMsg;
    
    @FindBy(xpath="//*[@id='quoteModuleForm']/div/div/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/button[3]")
    public WebElement CondoBtn;
    
    @FindBy(xpath="//*[@id='__next']/main/div[1]/main/div[2]/div[1]/h1")
    public WebElement LinkText;
    
    public void assertLinkText(String expected){
    	try{
    		logger.log(Status.PASS, "Successfully verified the pageTitle of Landing page " + expected);
			logg.info("Successfully verified the pageTitle of Landing page " + expected);
    	    String actual = LinkText.getText();
    	    Assert.assertEquals(actual, expected);
    	}catch(Exception e){
    		reportFail(e.getMessage());
    		logg.debug("Error while verifying the page title "+expected);
    	}
    	
    }
    
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
    
    public void clickProperty(){
    	logger.log(Status.INFO, "Clicking the property Button");
    	propertyBtn.click();
    	logger.log(Status.PASS, "Clicked the property Button successfully");
    	logg.info("Clicked the property Button successfully");
    }
    
    public void ClickRenters(){
    	logger.log(Status.INFO, "Clicking the Renters Button");
    	RentersBtn.click();
    	logger.log(Status.PASS, "Clicked the Renters Button Successfully");
    	logg.info("Clicked the Renters Button successfully");
    }
    
    public void ClickCondo(){
    	logger.log(Status.INFO, "Clicking the Condo Button");
    	CondoBtn.click();
    	logger.log(Status.PASS, "Clicked the Condo Button Successfully");
    	logg.info("Clicked the Condo Button successfully");
    }
    
    public void enterZip(String zipcode){
    	 logger.log(Status.INFO, "Entering the zipCode");   
    	 zipCodeTB.sendKeys(zipcode);
    	 logger.log(Status.PASS, "Entered the zipCode Succesfully");
    	 logg.info("Entered zipCode successfully");
    }
    
    public EnterInfoPage clickGetMyPrice(){
    	logger.log(Status.INFO, "Clicking the getMyPrice");
    	GetPriceBtn.click();
    	logger.log(Status.PASS, "Cliked getMyPrice Successfully");
    	logg.info("Clicked the getMyPrice");
    	EnterInfoPage enterInfoPage = new EnterInfoPage(driver, logger);
    	PageFactory.initElements(driver, enterInfoPage);
    	return enterInfoPage;
    }
    
    public YourInfoPage clickGetMyPrice1(){
    	logger.log(Status.INFO, "Clicking the getMyPrice");
    	GetPriceBtn.click();
    	logger.log(Status.PASS, "Cliked getMyPrice Successfully");
    	logg.info("Clicked the getMyPrice");
    	YourInfoPage yourInfoPage = new YourInfoPage(driver, logger);
    	PageFactory.initElements(driver, yourInfoPage);
    	return yourInfoPage;
    }
    
    public void AssertError(String expected){
    	try{
    	logger.log(Status.PASS, "Successfully verified the ErrorMsg of LandingPage " + expected);
		logg.info("Successfully verified the ErrorMsg of Landing page " + expected);
	    Assert.assertEquals(ErrorMsg.getText(), expected);
	}catch(Exception e){
		reportFail(e.getMessage());
		logg.debug("Error while verifying the ErrorMsg title "+expected);
	}
    }
    
    public void refresh(){
    	logger.log(Status.PASS, "Refreshed the page successfully");
		logg.info("Refreshed the page successfully");
    	driver.navigate().refresh();
    }

}

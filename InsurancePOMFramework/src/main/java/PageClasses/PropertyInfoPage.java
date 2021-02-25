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

public class PropertyInfoPage extends PageBaseClass{
	
private static Logger logg = LogManager.getLogger(PropertyInfoPage.class);
	
	public PropertyInfoPage(WebDriver driver, ExtentTest logger){
		super(driver,logger);
	}
	
	@FindBy(xpath="//*[@id='pane-header-PI01-0']/h1")
	public WebElement title;
	
	@FindBy(xpath="//*[@id='yearBuilt-insuredLocation-0']/span[2]/input")
	public WebElement yearBuilt;
	
	@FindBy(xpath="//*[@id='unitsInBuilding-insuredLocation-0_selectNode']")
	public WebElement unitsInBuilding;
	
	@FindBy(xpath="//*[@id='homeOccupancy-insuredLocation-0_selectNode']")
	public WebElement homeOccupany;
	
	@FindBy(xpath="//*[@id='homeSharingIndicator-insuredLocation-0']/div[2]/div/div[2]/label")
	public WebElement homeSharing;
	
	@FindBy(xpath="//*[@id='replacementCost-insuredLocation-0']/div[2]/div/div[2]/label")
	public WebElement replacementCost;
	
	@FindBy(xpath="//*[@id='dogIndicator-insuredLocation-0']/div[2]/div/div[2]/label")
	public WebElement dogIndicator;
	
	@FindBy(xpath="//*[@id='milesToFireStation-insuredLocation-0_selectNode']")
	public WebElement milesToFireStation;
	
	@FindBy(xpath="//*[@id='feetToFireHydrant-insuredLocation-0']/div[2]/div/div[1]/label")
	public WebElement feetToFire;
	
	@FindBy(xpath="//*[@id='outsideWallMaterial-insuredLocation-0_selectNode']")
	public WebElement outsideWall;
	
	@FindBy(xpath="//*[@id='nextButton-1']")
	public WebElement nextBtn;
	
	public void assertText(String expected){
		try{
    		logger.log(Status.PASS, "Successfully verified the text of YourInfo page " + expected);
			logg.info("Successfully verified the pageTitle of YourInfo page " + expected);
    	    String actual = title.getText();
    	    Assert.assertEquals(actual, expected);
    	}catch(Exception e){
    		reportFail(e.getMessage());
    		logg.debug("Error while verifying the text of YourInfo page " +e.getMessage());
    	}
	}
	
	public void enteryearBuilt(String year){
		try{
			logg.info("yearBuilt entered successfully "+year);
		    yearBuilt.sendKeys(year);
		    logger.log(Status.PASS, "yearBuilt entered successfully "+year );
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering yearBuilt entered successfully " + e.getMessage());
		}
	}
	
	public void selectUnitsBuilding(String text){
		try{
			logg.info("units of Building selected successfully " +text);
		    Select select = new Select(unitsInBuilding);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "units of Building selected successfully " +text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering the month of the Date of birth " + e.getMessage());
		}
	}
	
	public void selecthomeOccupany(String text){
		try{
			logg.info("Home Occupany selected successfully " +text);
		    Select select = new Select(homeOccupany);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "Home Occupany selected successfully " +text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while entering the Home ocupany " + e.getMessage());
		}
	}
	
	public void clickHomeSharing(){
		try{
			logg.info("The Home sharing Indicator clicked successfully");
			homeSharing.click();
		    logger.log(Status.PASS, "The Home sharing Indicator clicked successfully");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while The Home sharing Indicator click "+ e.getMessage());
		}
	}
	
	public void clickReplacementCost(){
		try{
			logg.info("The Replacement cost clicked successfully");
			replacementCost.click();
		    logger.log(Status.PASS, "The Replacement cost clicked successfully");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while The Replacement cost clicked successfully "+ e.getMessage());
		}
	}
	
	public void clickDogIndicator(){
		try{
			logg.info("The Replacement cost clicked successfully");
			dogIndicator.click();
		    logger.log(Status.PASS, "The Replacement cost clicked successfully");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while The Replacement cost clicked successfully "+ e.getMessage());
		}
	}
	
	public void selectmilesToFireStation(String text){
		try{
			logg.info("milesToFireStation selected successfully " +text);
		    Select select = new Select(milesToFireStation);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "milesToFireStation selected successfully " +text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("milesToFireStation selected Error " + e.getMessage());
		}
	}
	
	public void clickfeetToFire(){
		try{
			logg.info("The feetToFire clicked successfully");
			feetToFire.click();
		    logger.log(Status.PASS, "The feetToFire clicked successfully");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error while feetToFire cost clicked "+ e.getMessage());
		}
	}
	
	public void selectoutsideWall(String text){
		try{
			logg.info("outsideWall selected successfully " +text);
		    Select select = new Select(outsideWall);
		    select.selectByVisibleText(text);
		    logger.log(Status.PASS, "outsideWall selected successfully " +text);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("outsideWall selected Error " + e.getMessage());
		}
	}
	
	public SavingsPage click(){
		nextBtn.click();
		logger.log(Status.PASS, "Next Button clicked successfully and proceeded");
		logg.info("Next Button clicked successfully and proceeded");
		SavingsPage savingsPage = new SavingsPage(driver, logger);
		PageFactory.initElements(driver, savingsPage);
		return savingsPage;
	}

}

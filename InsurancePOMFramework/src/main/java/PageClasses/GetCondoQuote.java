package PageClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class GetCondoQuote extends PageBaseClass {
	
	private static Logger logg = LogManager.getLogger(GetCondoQuote.class);

	public GetCondoQuote(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath="//*[@id='price-area-0']/div[1]/div/span[1]/b")
	public WebElement Quote;
	
	public void ViewQuote(String expected){
		try{
		  System.out.println("Your quote amount is " + Quote.getText()+"/month");
		  logger.log(Status.PASS, "The quote printed successfully on console & Excel");
		  logg.info("The quote printed successfully on console & Excel");
		  //printOutputExcel(Quote.getText());
		  Assert.assertEquals(Quote.getText(), expected);
		  logger.log(Status.PASS, "The quote successfully asserted");
		  logg.info("The quote successfully asserted");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error to print the quote console & Excel " +e.getMessage());
		}
	}

}

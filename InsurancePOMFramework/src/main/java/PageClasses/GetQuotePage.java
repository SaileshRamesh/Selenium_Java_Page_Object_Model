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

public class GetQuotePage extends PageBaseClass {
	
	private static Logger logg = LogManager.getLogger(GetQuotePage.class);
	
	@FindBy(xpath="//*[@id='widget-3']/div[2]/div[1]/div/div/b")
	public WebElement QuoteAmount;
	
	public GetQuotePage(WebDriver driver, ExtentTest logger){
		super(driver,logger);
	}
	
	public void ViewQuote(String expected){
		try{
		  System.out.println("Your quote amount is " + QuoteAmount.getText()+"/month");
		  logger.log(Status.PASS, "The quote printed successfully on console & Excel");
		  logg.info("The quote printed successfully on console & Excel");
		  printOutputExcel(QuoteAmount.getText());
		  Assert.assertEquals(QuoteAmount.getText(), expected);
		  logger.log(Status.PASS, "The quote successfully asserted");
		  logg.info("The quote successfully asserted");
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error to print the quote console & Excel " +e.getMessage());
		}
	}

}

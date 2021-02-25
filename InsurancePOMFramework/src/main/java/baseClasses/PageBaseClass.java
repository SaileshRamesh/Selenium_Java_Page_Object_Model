package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.LandingPage;
import utilities.DateUtil;

public class PageBaseClass extends BaseTestClass{
	
	public ExtentTest logger;
	private static Logger logg = LogManager.getLogger(PageBaseClass.class);
	
	public PageBaseClass(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
	}
	
	 /****************** Open Application ***********************/
	
		public LandingPage OpenApplication(){
			logg.info("Opened the application successfully");
			logger.log(Status.INFO, "Opening the Website");
			driver.get("https://www.libertymutual.com");
			logger.log(Status.PASS, "Successfully opened https:www.libertyinsurance.com");
			LandingPage landingPage = new LandingPage(driver,logger);
			PageFactory.initElements(driver, landingPage);
			return landingPage;
		}
   
	/****************** Get Title ***********************/
	
	public void getTitle(String expectedTitle){
		try{
			logg.info("Asserted application title successfully");
		  Assert.assertEquals(driver.getTitle(), expectedTitle);
		  reportPass("Actual Title : " + driver.getTitle() + "- equals to Expected Title" + expectedTitle);
		}catch(Exception e){
			reportFail(e.getMessage());
			logg.debug("Error to Assert the page title" + e.getMessage());
		}
		
	}
	
	/*********************Verify if Element is displayed************/
	
	public void verifyElementIsDisplayed(WebElement webElement){
		try{
			logg.info("Verified the Element is present successfully");
			if(webElement.isDisplayed()){
				reportPass("Element is displayed");
			}else{
				reportFail("Element is not displayed");
			}
		}catch(Exception e){
			logg.debug("Error to Verify the Element is present");
			reportFail(e.getMessage());
		}
	}
	
	/****************** Reporting Functions ***********************/

	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);

	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);

	}
	
	/****************** Take Screenshots ***********************/

	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/Screenshots" + DateUtil.getTimeStamp() + ".png");
		try {
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/Screenshots" + DateUtil.getTimeStamp() + ".png");
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	FileInputStream fis = null;
	FileOutputStream fos = null;
	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet = null;
	static XSSFRow row = null;
	/****************Print the Output on ExcelSheet*************/
	public void printOutputExcel(String quoteAmount){
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output");
		System.out.println("The Quote is successfully printed on the excel");
		for(int i=0; i<1; i++){
			row = sheet.createRow(i);
			row.createCell(0).setCellValue("The Quote for your Rental is:");
			row.createCell(1).setCellValue(quoteAmount);
			row.createCell(2).setCellValue("per-month");
		}
		sheet.autoSizeColumn(0);
		try{
			logg.info("Written the output successfully to Excel File");
			fos = new FileOutputStream("output.xlsx");
			workbook.write(fos);
			fos.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			logg.debug("Error while printing the output to excel" + e.getMessage());
			e.printStackTrace();
		}
	}

}

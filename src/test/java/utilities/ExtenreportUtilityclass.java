package utilities;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
	import java.io.File;

import testCases.Baseclass;

import java.awt.Desktop;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	public class ExtenreportUtilityclass  implements ITestListener {

	    
	    public ExtentSparkReporter sparkReporter; // UI of the report
	    public ExtentReports extent; // populate common info on the report
	    public ExtentTest test; // creating test case report in  and update status
	    
	    String repName;
	  
	    
	    
	    
	    public void onStart(ITestContext context) {
	    	
	    	String timeStamp = new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
	    	repName = "Test-Report-" + timeStamp + " .html";
	    	
	    	
	    	
	    	
	        // Not implemented
	    	sparkReporter=new ExtentSparkReporter (".\\reports\\" + repName); // specified path for report
	    	sparkReporter.config().setDocumentTitle("Automation reports"); // Title of reports
	    	sparkReporter.config().setReportName("Functional testing");// name of report
	    	sparkReporter.config().setTheme(Theme.DARK);
	    	
	    	extent=new ExtentReports();
	    	extent.attachReporter(sparkReporter);
	    	
	    	
	    	extent.setSystemInfo("EnvironmentName", "QA");
	    	extent.setSystemInfo("Tester", "Pawan");
	    }
	    

	  

	    public void onTestSuccess(ITestResult result) {
	    	
	       test=extent.createTest(result.getTestClass().getName()); // create new entry in the report
	       test.assignCategory(result.getMethod().getGroups()); // to display groups in report
	       test.log(Status.PASS, "Test case Passed is:"+ result.getName());// update test case status
	       
	       
	       
	    }
	    
	    

	    public void onTestFailure(ITestResult result) {
	    	
	    	
	    	  test=extent.createTest(result.getTestClass().getName()); // create new entry in the report
	    	  test.assignCategory(result.getMethod().getGroups()); //
	    	  
	          test.log(Status.FAIL, "Test case FAIL is:"+ result.getName());// update test case status
	          test.log(Status.INFO, "Test case FAIL is:"+ result.getThrowable().getMessage());
	          
	          
	          try {
	        	  
	        	  String imgPath = new Baseclass().captureScreen(result.getName());
	        	  
	        	  test.addScreenCaptureFromPath(imgPath);
	        	  
	          } catch (IOException e1) {
	        	  e1.printStackTrace();
	          }
	       
	    }

	    public void onTestSkipped(ITestResult result) {
	    	test=extent.createTest(result.getTestClass().getName()); // create new entry in the report
	    	 test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.SKIP, "Test case SKIP is:"+ result.getName());// update test case status
	        test.log(Status.INFO, "Test case FAIL is:"+ result.getThrowable().getMessage());
	       
	    }

	  /*  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Not implemented
	    } */

	  

	    public void onFinish(ITestContext context) {
	    	
	        extent.flush();
	        
	        String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
	        File extentReport = new File(pathOfExtentReport);
	        
	        try {
	        	Desktop.getDesktop().browse(extentReport.toURI());
	        } catch (IOException e) {
	        	e.printStackTrace();
	        
	        }
	    }
	}


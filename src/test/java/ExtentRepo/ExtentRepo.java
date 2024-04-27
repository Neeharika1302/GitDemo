package ExtentRepo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentRepo {
    ExtentReports extent;
    @BeforeTest
    public void config(){
        String filePath=System.getProperty("user.dir")+"\\Reports\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(filePath);
        reporter.config().setReportName("Web automation results");
        reporter.config().setDocumentTitle("Test Results");
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Neeha");
    }
    @Test
    public void sampleTest(){
        ExtentTest test=extent.createTest("Sample Test");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/");
        System.out.println(driver.getTitle());
        test.fail("Results do not match");
        driver.close();
        extent.flush();
        System.out.println("Test Success");
    }
    @Test
    public void sampleTest1(){
        ExtentTest test=extent.createTest("Sample Test");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        test.fail("Results do not match");
        driver.close();
        extent.flush();
        System.out.println("Test Success");
    }
    @Test
    public void sampleTest2(){
        ExtentTest test=extent.createTest("Sample Test");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.udemy.com");
        System.out.println(driver.getTitle());
        test.fail("Results do not match");
        driver.close();
        extent.flush();
        System.out.println("Test Success");
    }
}

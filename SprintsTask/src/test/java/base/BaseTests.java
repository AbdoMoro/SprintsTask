package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.time.Duration;

public class BaseTests {
    WebDriver driver;
    public HomePage homePage;
    @BeforeTest
    //@Parameters("browser")
    public void setUp(){
        //System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://egyptlaptop.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

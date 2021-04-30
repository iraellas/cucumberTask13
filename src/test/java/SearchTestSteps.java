import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class SearchTestSteps {
    WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setProperties() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @Given("go to Rozetka")
    public void openRozetka() {
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("^search for \"(.+)\", write in \"(.+)\", click to the \"(.+)\"$")
    public void searchFor(String searchText, String searchInput, String searchButton) {
        driver.findElement(By.xpath(searchInput)).clear();
        driver.findElement(By.xpath(searchInput)).sendKeys(searchText);
        driver.findElement(By.cssSelector(searchButton)).click();
    }

    @Then("^title \"(.+)\",should be contains \"(.+)\"$")
    public void checkTitle(String titleResult, String searchText) {
        driver.findElement(By.cssSelector(titleResult)).isDisplayed();
        Assert.assertTrue(driver.findElement(By.cssSelector(titleResult)).getText().contains(searchText));
    }
}
package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - browser is open");
		System.setProperty("webdriver.chrome.driver","C:/Users/SSS/eclipse-workspace/CucumberLogin/src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("User is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside step - user is on google search page");
		driver.navigate().to("https://google.com");
        driver.findElement(By.id("W0wltc")).sendKeys(Keys.ENTER);
	}

	@When("User enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("Inside step - user enters a text in search box");
		driver.findElement(By.name("q")).sendKeys("github padmavantharam/CucumberTest");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
       
	}

	@When("Hits enter")
	public void hits_enter() {
		System.out.println("Inside step - hits enter");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	}

	@Then("User is navigated to search results")
	public void user_is_navigated_to_search_results() {
        System.out.println("Inside step - user is navigated to search results page");
        driver.getPageSource().contains("padmavantharam");
        driver.close();
        driver.quit();
	}



}

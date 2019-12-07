package devOps.Edith;

import org.junit.Test;

import static org.junit.Assert.fail;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSelenium {
	private WebDriver driver;
	private String baseUrl;
	private String pageTitle;
	private String expectedTitle;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

		ChromeOptions ChromeOptions = new ChromeOptions();
		ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");

		driver = new ChromeDriver(ChromeOptions);
		baseUrl = "http://" + System.getProperty("myUrlTest") + ":8080/edith/";
		pageTitle = "";
		expectedTitle = "EDITH : Redis demonstration";
	}

	@Test
	public void testPageTitle() {
		driver.get(baseUrl);
		pageTitle = driver.getTitle();
		if (pageTitle.equals(expectedTitle)) {
			System.out.println("Home Page Title PASSED ");
		} else {
			System.out.println("Home Page Title FAILED");
			Assert.fail();
		}
	}

	@Test
	public void testLogin() {
		driver.get("http://" + System.getProperty("myUrlTest") + ":8080/edith/signIn");

		WebElement username = driver.findElement(By.name("name"));
		WebElement password = driver.findElement(By.name("pass"));

		WebElement login = driver.findElement(By.xpath("//input[@value='Sign In']"));
		username.sendKeys("toto");
		password.sendKeys("toto");
		login.click();

		String actualUrl = "http://" + System.getProperty("myUrlTest") + ":8080/edith/!test";
		String expectedUrl = driver.getCurrentUrl();

		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Login Test Good PASSED");
		} else {
			System.out.println("Login Test Good FAILED");
			Assert.fail();
		}
	}

	@Test
	public void testLoginWrong() {
		driver.get("http://" + System.getProperty("myUrlTest") + ":8080/edith/signIn");

		WebElement username = driver.findElement(By.name("name"));
		WebElement password = driver.findElement(By.name("pass"));

		WebElement login = driver.findElement(By.xpath("//input[@value='Sign In']"));
		username.sendKeys("test");
		password.sendKeys("toto");
		login.click();

		String actualUrl = "http://" + System.getProperty("myUrlTest") + ":8080/edith/signIn";
		String expectedUrl = driver.getCurrentUrl();

		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Login Test Wrong PASSED");
		} else {
			System.out.println("Login Test Wrong FAILED");
			Assert.fail();
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

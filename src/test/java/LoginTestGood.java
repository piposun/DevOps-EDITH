


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTestGood {

	private WebDriver driver;

	@Before
	public void setUp() {
		ChromeOptions ChromeOptions = new ChromeOptions();
		ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");

		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver(ChromeOptions);
	}

	@Test
	public void testLogin() {
		driver.get("http://" + System.getProperty("myUrlTest") + ":8080/edith/signIn");

		WebElement username = driver.findElement(By.name("name"));
		WebElement password = driver.findElement(By.name("pass"));

		WebElement login = driver.findElement(By.xpath("//input[@value='Sign In']"));
		username.sendKeys("test");
		password.sendKeys("test");
		login.click();

		String actualUrl = "http://" + System.getProperty("myUrlTest") + ":8080/edith/!test";
		String expectedUrl = driver.getCurrentUrl();

		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Login Test Good PASSED");
		} else {
			System.out.println("Login Test Good FAILED");
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
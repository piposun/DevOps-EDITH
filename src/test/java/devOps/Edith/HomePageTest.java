package devOps.Edith;

import org.junit.Test;

import static org.junit.Assert.fail;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePageTest {
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
			Assert.assertTrue(true);
		} else {
			System.out.println("Home Page Title FAILED");
			Assert.fail();
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

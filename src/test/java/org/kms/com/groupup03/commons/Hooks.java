package org.kms.com.groupup03.commons;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.utils.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.kms.com.groupup03.utils.AppConfigs.*;

public class Hooks extends BasePage {
	protected ConfigReader config;
	protected String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
	protected String browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");

	@Before
	public void setupDriver() {
		config = new ConfigReader("src/test/resources/configs/" + env + ".properties");
		System.out.println("Running on '" + env.toUpperCase() + "' environment with '" + browser.toUpperCase() + "' browser.");
		switch (browser){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
				driver = new FirefoxDriver();
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Not support to run tests on" + browser.toUpperCase() + " browser.");
				break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_LARGE));
		driver.get(config.getProperty("base_url"));
	}

	@After(order=0)
	public void quitDriver() {
		driver.quit();
	}

	@After(order = 1)
	public void takeScreenShotOnFailedScenario(Scenario scenario) {
		if ((scenario.isFailed())) {
			System.out.println("Test failed. Capturing screenshot...");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
}

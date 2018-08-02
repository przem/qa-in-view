package com.zalaris.qa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * https://automate.browserstack.com/
 *
 * login:  a5923789@nwytg.net
 * password: z******
 */
public class SimpleTest {

    public static final String USERNAME = "abla2";
    public static final String AUTOMATE_KEY = "nzdxTN23dMpZ4g39axnq";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private WebDriver driver;

    @Before
    public void onBefore() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "68.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    /**
     * Test contains an error, please correct the test
     * Max time: 5min
     */
    @Test
    public void testGoogleSearch() throws Exception {
        try {
            driver.get("https://www.google.com/ncr");
            WebElement element = driver.findElement(By.name("query"));
            element.sendKeys("Zalaris");
            element.submit();
            Thread.sleep(5000);

            Assert.assertEquals("Zalaris - Google Search", driver.getTitle());
        } finally {
            driver.quit();
        }
    }

    /**
     * Please implement test on static page
     * Max time: 15min
     */
    @Test
    public void testSamplePage() throws Exception {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        driver.quit();
    }

    /**
     * Please implement test on dynamic page
     * Max time: 30min
     */
    @Test
    public void testDynamicPage() throws Exception {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.quit();
    }
}

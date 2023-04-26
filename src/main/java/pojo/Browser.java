package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

    static WebDriver driver;
    public static WebDriver launchBrowser(String browser)
    {

        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opt=new ChromeOptions();
            opt.addArguments("--remote-allow-origines=*");
            driver=new ChromeDriver(opt);
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();

        }
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("--remote-allow-origines=*");
        driver=new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        return driver;
    }


}
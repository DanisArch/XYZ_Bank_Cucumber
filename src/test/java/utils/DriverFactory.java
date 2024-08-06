package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver get() {
        String browser = ConfigurationReader.get("browser");
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-search-engine-choice-screen");
                if (ConfigurationReader.get("headless").toLowerCase().contains("true")) {
                    options.addArguments("--no-default-browser-check");
                    options.addArguments("--no-first-run");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-default-apps");
                    options.addArguments("--disable-sync");
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--lang=en-en");
                }
                driver = new ChromeDriver(options);
                if (ConfigurationReader.get("maximize").toLowerCase().contains("true")) {
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
                }
                return driver;
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case "edge" -> {
                if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                    throw new WebDriverException("Ваша операционная система не поддерживает запуск браузера Edge");
                }
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
        }

        throw new WebDriverException("WebDriver не выбран в конфигурационном файле configuration.properties");
    }
}
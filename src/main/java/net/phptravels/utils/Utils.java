package net.phptravels.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Utils extends Constants {

    private static Logger logger = LogManager.getLogger(Utils.class.getName());
    private WebDriver driver = null;
    private String NAVCHROME = "chromedriver.exe";
    private String NAVFIREFOX = "geckodriver.exe";

    String ruta = null;

    public WebDriver getDriver() {
        return driver;
    }

    public Utils setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    public static void main(String[] args) throws Exception {

        Utils util = new Utils();
        util.openApp(CHROME, urlAmbiente);
    }

    public WebDriver openApp(String navegador, String urlAmbiente) throws Exception {
        try {
            driver = obtenerDriver(navegador);
            driver.get(urlAmbiente);
            setDriver(driver);
        } catch (Exception e) {
            String msg = "Error en apertura de la app";
            logger.error(msg);
            throw new Exception(msg + e.getMessage());
        }
        return driver;
    }

    private WebDriver obtenerDriver(String navegador) {

        switch (navegador) {
            case "chrome":

                ruta = RUTABASENAVEGADOR + NAVCHROME;
                System.setProperty("webdriver.chrome.driver", ruta);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                DesiredCapabilities capabilities=DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY,options);
                driver = new ChromeDriver(options);
                options.addArguments("--start-maximized");
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                break;
            case "Firefox":
                ruta = RUTABASENAVEGADOR + NAVFIREFOX;
                System.setProperty("webdriver.gecko.driver", ruta);
                //driver= new FirefoxFilter();
        }
        System.out.println("driver: " + driver);

        return driver;
    }


}

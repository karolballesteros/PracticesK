package net.phptravels.bc;

import com.github.javafaker.Faker;
import net.phptravels.page.HomePage;
import net.phptravels.utils.Constants;
import net.phptravels.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BC {
    private static BC bc;
    private static String url;
    private Utils utils;
    private WebDriver driver;
    HomePage homePage;

    public BC(String url) {
        this.driver=new ChromeDriver();
        driver.get(url);
    }

    public void searchDubaiTours() throws Exception {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setBtnTours();
        homePage.enterLocation(Constants.destino,driver);
        homePage.setBtnSearch();
        Thread.sleep(2000);
        driver.quit();

    }

    public void searchDubaiTours2() throws Exception {
//        homePage = PageFactory.initElements(driver, HomePage.class);
//        //homePage.setTxtSearch(Constants.destino);
//        Thread.sleep(2000);
//        driver.close();
    }
    public void searchDubaiTours3() throws InterruptedException {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setBtnSearch();
        Thread.sleep(2000);
        driver.close();
    }
//
//    public static BC getInstance(String url, String browser){
//        if(bc == null) {
//            bc = new BC(url, browser);
//        }
//        return bc;
//    }
}

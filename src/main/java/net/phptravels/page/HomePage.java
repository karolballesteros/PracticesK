package net.phptravels.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

	@FindBy(xpath = "/html/body/div[4]/section/div[2]/div/div[2]/ul/li[3]/a[@href='#TOURS']")
	WebElement btnTours;

	@FindBy(id = "s2id_autogen11")
	WebElement txtSearch;

	@FindAll({@FindBy (xpath= "/html/body/div[16]/ul/li[2]/ul/li/div[@class='select2-result-label']")})
	List<WebElement> listTours;

	@FindBy(xpath = "//*[@id=\"TOURS\"]/form/div[5]/button")
	WebElement btnSearch;

	public void setBtnTours() {
		btnTours.click();
	}

	public void enterLocation(String location,WebDriver driver) throws Exception{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(txtSearch));
		boolean isLocated = false;

		try {
			txtSearch.sendKeys(location);
			wait.until(ExpectedConditions.visibilityOfAllElements(listTours));
			for (WebElement element : listTours) {
				String locationName = element.getText();
				if(locationName.contains(location)){
					isLocated = true;
					element.click();
					break;
				}
			}
			if(!isLocated) {
				throw new Exception("Could not found the location " + location);
			}
		}catch (Exception e){
			String msg = "Error entering location";
			//logger.error(msg + e.getMessage());
			throw new Exception(msg + e.getMessage());
		}
	}

	public void setBtnSearch() {
			btnSearch.click();
	}



}

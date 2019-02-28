import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ParkingCalculate {
    WebDriver webDriver;
    By chooseALotLocator=By.id("Lot");
    By entryTime=By.id("EntryTime");
    By entryDate=By.id("EntryDate");
    By exitTime=By.id("ExitTime");
    By exitDate=By.id("ExitDate");
    By submit=By.name("Submit");
    By cost=By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[1]/font/b");


    public ParkingCalculate(WebDriver webDriver){
        this.webDriver=webDriver;
    }
    public void chooseALot(){
        Select longTermParking = new Select(webDriver.findElement(chooseALotLocator));
        longTermParking.selectByValue("LTS");
    }
    public void setEntryTime(){
        webDriver.findElement(entryTime).clear();
        webDriver.findElement(entryTime).sendKeys("1:00");


    }
    public void setEntryDate(){
        webDriver.findElement(entryDate).clear();
        webDriver.findElement(entryDate).sendKeys("3/3/2019");
    }
    public void setExitTime(){

        webDriver.findElement(exitTime).clear();
        webDriver.findElement(exitTime).sendKeys("2:00");
    }
    public void setExitDate(){
        webDriver.findElement(exitDate).clear();
        webDriver.findElement(exitDate).sendKeys("3/3/2019");
    }
    public void clickSubmit(){
        webDriver.findElement(submit).click();
    }
    public void checkCost(){
        webDriver.findElement(cost).getText();
        Assert.assertEquals(webDriver.findElement(cost).getText(),"$ 2.00");
    }
    public void closeWindow(){
        webDriver.close();
    }
}

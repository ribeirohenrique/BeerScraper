import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class StartingScrape {

    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        FirefoxDriver driver = new FirefoxDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String website = "https://hygger.com.br/";
        String itemsCount = "/html/body/section[4]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/div[2]/b";
        String classBeerName = "item-name";
        String classBeerType = "beer-style-hideable";
        String classBeerAbv = "abv";
        String classBeerIbu = "ibu";
        String classBeerBreweryName = "brewery";
        String classBeerBreweryLocation = "location";

        //Starting navigation and waiting the class to load
        driver.navigate().to(website);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classBeerName)));

        //Retrieve the number of beer on tap on website
        WebElement count = driver.findElementByXPath(itemsCount);
        int numberOfItems = Integer.parseInt(count.getText().substring(4));

        //Store all in lists
        List<WebElement> beerNameList = driver.findElements(By.className(classBeerName));
        List<WebElement> beerTypeList = driver.findElements(By.className(classBeerType));
        List<WebElement> beerAbvList = driver.findElements(By.className(classBeerAbv));
        List<WebElement> beerIbuList = driver.findElements(By.className(classBeerIbu));
        List<WebElement> beerBreweryNameList = driver.findElements(By.className(classBeerBreweryName));
        List<WebElement> beerBreweryLocationList = driver.findElements(By.className(classBeerBreweryLocation));

        Iterator<WebElement> iteratorBeerName = beerNameList.iterator();
        Iterator<WebElement> iteratorBeerType = beerTypeList.iterator();
        Iterator<WebElement> iteratorBeerAbv = beerAbvList.iterator();
        Iterator<WebElement> iteratorBeerIbu = beerIbuList.iterator();
        Iterator<WebElement> iteratorBeerBreweryName = beerBreweryNameList.iterator();
        Iterator<WebElement> iteratorBeerBreweryLocation = beerBreweryLocationList.iterator();

        for (int i = 0; i < numberOfItems; i++) {

            //Foi necessário criar a variavel em String para facilitar o processo de substring
            String beerType = iteratorBeerType.next().getText();
            String beerName = iteratorBeerName.next().getText().replace(beerType, "").substring(3);
            //String beerName = iteratorBeerName.next().getText().substring(3, beerType.length() - 4);
            System.out.println("Name: " + beerName);
            System.out.println("Type: " + beerType);
            System.out.println("ABV: " + iteratorBeerAbv.next().getText());
            System.out.println("IBU: " + iteratorBeerIbu.next().getText());
            System.out.println("Brewery Name: " + iteratorBeerBreweryName.next().getText());
            System.out.println("Brewery Location: " + iteratorBeerBreweryLocation.next().getText());
            System.out.println();
        }

        driver.close();
    }
}

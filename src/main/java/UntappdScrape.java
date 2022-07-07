import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UntappdScrape {

    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        FirefoxDriver driver = new FirefoxDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String website = "https://business.untappd.com/boards/48516";
        String classBeerName = "name";
        String classBeerType = "style";
        String classBeerAbv = "abv";
        String classBeerBreweryName = "brewery";
        List<Brew> brewList = new ArrayList<>();


        //Starting navigation and waiting the class to load
        driver.navigate().to(website);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classBeerName)));

        //Retrieve the number of beer on tap on website
        List<WebElement> count = driver.findElements(By.className(classBeerName));
        int numberOfItems = count.size();

        for (int i = 0; i < numberOfItems; i++) {

            //Store all in lists
            String beerName = driver.findElements(By.className(classBeerName)).get(i).getText();
            String beerType = driver.findElements(By.className(classBeerType)).get(i).getText();
            String beerAbv = driver.findElements(By.className(classBeerAbv)).get(i).getText();
            String beerBrewery = driver.findElements(By.className(classBeerBreweryName)).get(i).getText();

            //TODO: Adicionar o IBU de alguma maneira
            brewList.add(new Brew(beerName, beerType, beerAbv, beerBrewery));

        }
        brewList.forEach(System.out::println);

        driver.close();
    }
}

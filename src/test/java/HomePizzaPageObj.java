import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


class HomePizzaPageObj {

    private final String URL_HOMEPAGE = "https://express-pizza.by";

    WebDriver driver;

    @FindBy(xpath ="//div/button[@id='edit-submit-42523']")
    WebElement btnOrderPizzaMargarita30;

    @FindBy(xpath = "//a[text()='Напитки']")
    WebElement btnNapitki;

    public HomePizzaPageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public HomePizzaPageObj openPageHome()  {
        driver.get(URL_HOMEPAGE);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div/button[@id='edit-submit-42523']")));
        return this;
    }

    public HomePizzaPageObj clickBtnOrderPizzaMargarita30()  {
        btnOrderPizzaMargarita30.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

     public NapitkiPageObj goToNapitki() {
         btnNapitki.click();
         new WebDriverWait(driver, Duration.ofSeconds(5))
                 .until(ExpectedConditions
                         .presenceOfElementLocated(By.xpath("//button[@id='edit-submit-42495']")));
         return new NapitkiPageObj(driver);
     }
}

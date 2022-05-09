import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NapitkiPageObj {

    WebDriver driver;

    @FindBy(xpath ="//button[@id='edit-submit-42495']")
    WebElement btnOrderCola05;

    @FindBy(xpath = "//a[text()='Корзина']")
    WebElement btnGetCart;

    public NapitkiPageObj (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public NapitkiPageObj clickBtnOrderCola05()  {
        btnOrderCola05.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public CartPageObj goToCart() throws InterruptedException {
        btnGetCart.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//td[@class='desc']/a[text()='Маргарита30']/ancestor::tr//input[@class='form-control form-text required']")));
        return new CartPageObj(driver);
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.Map;

class CartPageObj {

    WebDriver driver;

    static Map<String, String> map = new HashMap<>();

    String actualQuantityPizzaMargaritaInCart = "actualQuantityPizzaMargaritaInCart";
    String actualNamePizzaMargaritaInCart = "actualNamePizzaMargaritaInCart";
    String actualNameCola05InCart = "actualNameCola05InCart";
    String actualQuantityCola05InCart = "actualQuantityCola05InCart";

    @FindBy(xpath = "//td[@class='desc']/a[text()='Маргарита30']/ancestor::tr//input[@class='form-control form-text required']")
    WebElement quantityPizzaMargaritaInCart;

    @FindBy(xpath = "//td[@class='desc']/a[text()='Маргарита30']")
    WebElement namePizzaMargaritaInCart;

    @FindBy(xpath = "//td[@class='desc']/a[text()='Кока - Кола 0.5']")
    WebElement nameCola05InCart;

    @FindBy(xpath = "//input[@class='form-control form-text required']")
    WebElement quantityCola05InCart;

    public CartPageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPageObj ShowNameInCart(WebElement element, String productName) {
        map.put(productName, element.getText());
        return this;
    }

    public CartPageObj ShowQuantityInCart(WebElement element, String quantity) {
        map.put(quantity, element.getAttribute("value"));
        return this;
    }
}


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseAbstractClass {

     WebDriver chromeDriver;

     @BeforeEach
    public  void openChrome() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @AfterEach
    public  void closeDriver() {
        chromeDriver.quit();
    }
}

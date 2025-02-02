package StepDefinitions;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected static WebDriver driver;
    protected Scenario scenario;
    protected  StringBuffer error = new StringBuffer();

    static {
        // WebDriver'ı başlatmak için gerekli ayarları yapıyoruz
        WebDriverManager.chromedriver().clearDriverCache().setup(); // WebDriver'ı yönetmek için WebDriverManager kullanıyoruz
        driver = new ChromeDriver(); // ChromeDriver'ı başlatıyoruz
        driver.manage().window().maximize(); // Pencereyi tam ekran yapıyoruz
    }


    // Test tamamlandığında WebDriver'ı kapatmak için bir yöntem ekleyebiliriz.
    public static void tearDown() {
        if (driver != null) {
            driver.quit(); // Test bittiğinde WebDriver'ı kapatıyoruz
            driver.close();
        }
    }

}


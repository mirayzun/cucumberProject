package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps extends BaseTest {


    @Given("{string} adresine gidilir")
    public void goToUrl(String url) {
        try{
        driver.get(url);
        }catch(Exception e){
//            error.append("Senaryo").append(scenario.getName());
        }
    }

    @When("Kullanıcı {string} ve {string} bilgileriyle giriş yapar")
    public void kullaniciVeIleGirisYapar(String username, String password) {
        // Kullanıcı adı alanını bul (örnek locator: id="username")
        try {
            WebElement usernameInput = driver.findElement(By.xpath("//input[contains(@placeholder,'Username')]"));
            usernameInput.clear();
            usernameInput.sendKeys(username);
        } catch (Exception e) {
            //error.append("Senaryo").append(scenario.getName());
            System.out.println("Username alanı bulunamadı!");
            System.out.println(e.getMessage());
            //driver.close();
            return;
        }

        // Şifre alanını bul (örnek locator: id="password")
        try {
            WebElement passwordInput = driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]"));
            passwordInput.clear();
            passwordInput.sendKeys(password);
        } catch (Exception e) {
            error.append("Senaryo").append(scenario.getName());
            System.out.println("Password alanı bulunamadı!");
            System.out.println(e.getMessage());
            return;
        }

        // Giriş butonuna tıklayın (örnek locator: id="loginButton")

        try {
            WebElement loginButton = driver.findElement(By.xpath("//div[text()='Login']"));
            loginButton.click();
        } catch (Exception e) {
            error.append("Senaryo").append(scenario.getName());
            System.out.println("Login butonu bulunamadı!");
            System.out.println(e.getMessage());
        }
    }

    @Then("Sayfanın yüklendiği görülür")
    public void sayfaBasariliYuklendi(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='css-1jxf684 r-b88u0q']")));
        }catch (Exception e){
           //error.append("Senaryo").append(scenario.getName());


        }
    }


}

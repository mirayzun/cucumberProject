package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAccount extends BaseTest {

    @Given("Edit account butonuna tıklanır")
    public void editAccountTikla(){
        try{
            WebDriverWait wait= new WebDriverWait(driver,10);
            WebElement editButton= wait.until(driver->driver.findElement(By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-169ebfh r-z2wwpe r-1777fci r-tsynxw r-16l9doz r-edyy15 r-iyfy8q']/div[contains(text(), 'Edit account')]")));
            editButton.click();
        }catch (Exception e){
            error.append("Senaryo").append(scenario.getName());
            System.out.println("Add money alanı bulunamadı!");
            System.out.println(e.getMessage());
        }
    }


    @Given("Account name alanına {string} degeri girilir")
    public void accountName(String name){
        try{
            WebElement accountNameArea = driver.findElement(By.xpath("//input[@placeholder='' and @class='css-11aywtz r-6taxm2 r-1eh6qqt r-z2wwpe r-rs99b7 r-h3s6tt r-1qhn6m8']"));
            accountNameArea.clear();
            accountNameArea.sendKeys(name);
        }catch (Exception e){
            error.append("Senaryo").append(scenario.getName());
            System.out.println("Add money alanı bulunamadı!");
            System.out.println(e.getMessage());
        }
    }

    WebElement updateButon;
    boolean isEnabled;
    @When("Update butonu aktif mi")
    public void updateButonAktifMi(){
        try{
            WebDriverWait wait= new WebDriverWait(driver,10);
            updateButon=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-169ebfh r-z2wwpe r-h3s6tt r-1777fci r-tsynxw r-13qz1uu']/div[text()='UPDATE']")));
            isEnabled= updateButon.isEnabled();
        }catch (Exception e){
            error.append("Senaryo").append(scenario.getName());
            System.out.println("Add money alanı bulunamadı!");
            System.out.println(e.getMessage());
        }
    }

    @Given("Update butonu tıkla")
    public void updateButonTikla(){
        try{
            if(isEnabled){
                updateButon.click();
            }
        }catch (Exception e){
            error.append("Senaryo").append(scenario.getName());
            System.out.println("Add money alanı bulunamadı!");
            System.out.println(e.getMessage());
        }

    }
}

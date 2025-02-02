package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;


public class TransferMoneyIslemiSteps extends BaseTest{


    @Given("Open Money Transfer butonuna tıklayın")
    public void openMoneyButonunaTikla(){
        WebDriverWait wait= new WebDriverWait(driver,10);
        WebElement openMoneyButton= wait.until(driver-> driver.findElement(By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']")));
        //WebElement openMoneyButton= driver.findElement(By.xpath("//div[text()='Open Money Transfer']"));
        openMoneyButton.click();
    }

    @Then("My Account sayfasının yüklendiği görülür")
    public void mySayfaBasariliYuklendi(){
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='css-146c3p1 r-1gknse6 r-1b43r93' and text()='My account']")));
    }

    @Given("Transfer Money butonuna tıklayın")
    public void transferMoneyButtonTikla(){
        WebElement transferMoneyButton= driver.findElement(By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-169ebfh r-z2wwpe r-1777fci r-tsynxw r-16l9doz r-edyy15 r-iyfy8q']"));
        transferMoneyButton.click();
    }


    @When("Sender account alanın dolu oldugu kontrol edilir")
    public void senderAccountDolu(){

        //"//div[normalize-space(text())='Sender account']/following-sibling::div//select"
       WebElement senderAccount= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space(text())='Sender account']/following-sibling::div//select")));
       Select dropdown= new Select(senderAccount);

       WebElement selectedOptions= dropdown.getFirstSelectedOption();
       String selectedValue= selectedOptions.getAttribute("value");

       assertFalse("Sender account boş degil", selectedValue.isEmpty());

    }

    @When("Receiver account alanın dolu olugu kontrol edilir")
    public void recevierAccountDolu(){
    //div[normalize-space(text())='Receiver account']/following-sibling::div//select

        WebElement receiverAccount= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space()='Receiver account']/following-sibling::div[contains(@class, 'r-1777fci')]//select")));
        Select dropdown= new Select(receiverAccount);

        WebElement selectedOptions= dropdown.getFirstSelectedOption();
        String selectedValue= selectedOptions.getAttribute("value");

        assertFalse("Reciver account boş degil", selectedValue.isEmpty());
    }

    @Given("Transfer money amount alanına {int} degeri gir")
    public void amonuntDegerGir(int amount){
        WebElement amountField= driver.findElement(By.xpath("//div[normalize-space(text())='Amount']/following-sibling::div//input"));
        amountField.sendKeys(String.valueOf(amount));

    }
    boolean isEnabled;
    WebElement sendButton;
    @When("Transfer money send butonu tıklanabilir mi")
    public void sendAktifMi(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Send']")));
        isEnabled = sendButton.isEnabled();
    }

    @Given("Transfer Send butonu aktif ise tıkla")
    public void sendButonTikla(){
        if (isEnabled){
            sendButton.click();
        }
    }


}

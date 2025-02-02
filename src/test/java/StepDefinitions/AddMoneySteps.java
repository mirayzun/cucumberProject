package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddMoneySteps extends BaseTest {

    @Given("Add money butonuna tıkla")
    public void addMoneyTikla(){
        try {
            WebDriverWait wait= new WebDriverWait(driver,10);
            WebElement addMoneyButton= wait.until(driver-> driver.findElement(By.xpath("//div[contains(text(),'Add money')]")));

            addMoneyButton.click();
        }catch (Exception e){
            error.append("Senaryo").append(scenario.getName());
            System.out.println("Add money alanı bulunamadı!");
            System.out.println(e.getMessage());
        }
    }

    @Given("Card number alanına {string} degeri girilir")
    public void cardNumberGiris(String number){
        try{if(number.length() !=12){
            System.out.println("Hata: 12 hane üzerinde kart numarası olamaz");

        }
        else {
            WebElement cardNumberArea=driver.findElement(By.xpath("//div[contains(text(), 'Card number')]/following-sibling::input"));
            cardNumberArea.sendKeys(number);
        }

        }catch (Exception e){
            error.append("Senaryo").append(scenario.getName());
            System.out.println("Card number hatalı !");
            System.out.println(e.getMessage());
        }

    }
    @Given("Card holder alanına {string} degeri girilir")
    public void cardHolderGiris(String name){
        if(name.length() !=5){
            System.out.println("Hata:En az 5 adet harf değişkeni girilmelidir ");

        }
        else {
            WebElement cardHolderArea= driver.findElement(By.xpath("//div[contains(text(), 'Card holder')]/following-sibling::input"));
            cardHolderArea.sendKeys(name);
        }
    }
    WebElement expirydate;
    @Given("Expiry date alanı ay {string} degeri girilir")
    public void expiryDateGiris(String mount){
        if (mount.length() !=2 || Integer.parseInt(mount) > 12 || Integer.parseInt(mount) < 1){
            System.out.println("Hata: MM şeklinde 2 basamaklı ve 01 ile 12 arasında bir ay değeri girilmelidir. ");
        }
        else {
            expirydate=driver.findElement(By.xpath("//div[contains(text(), 'Expiry date')]/following-sibling::input"));
            expirydate.sendKeys(mount);
        }
    }
    @Given("Expiry date alanın yıl {string} degeri girilir")
    public void expiryDateGiris2(String yil){
        if (yil.length() !=2){
            System.out.println("Hata: YY şeklinde 2 basamaklı değer girilmelidir ");
        }
        else{
            expirydate=driver.findElement(By.xpath("//div[contains(text(), 'Expiry date')]/following-sibling::input"));
            expirydate.sendKeys(yil);
        }
    }
    @Given("CVV alanına {string} degeri girilir")
    public void cvvGiris(String cvv){
        if (cvv.length() !=3){
            System.out.println("Hata: En az 3 basamaklı deger girilmeliri");
        }
        else {
            WebElement cvvArea= driver.findElement(By.xpath("//div[contains(text(), 'CVV')]/following-sibling::input"));
            cvvArea.sendKeys(cvv);
        }
    }

    @Given("Add money amonunt alanına {int} degerini gir")
    public void amountGiris(int amount){
        WebElement amountArea= driver.findElement(By.xpath("//div[contains(text(), 'Amount')]/following-sibling::input"));
        amountArea.sendKeys(String.valueOf(amount));
    }
    //        WebDriverWait wait = new WebDriverWait(driver,10);
    //        sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Send']")));
    //        isEnabled = sendButton.isEnabled();
    WebElement addMoneyButton;
    boolean isEnabled;

    @When("Add butonu aktif mi")
    public void addButtonAktifMi(){
        WebDriverWait wait= new WebDriverWait(driver,10);
        addMoneyButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(text(), 'Add') and @class='css-146c3p1 r-jwli3a r-1b43r93'])[2]")));
        isEnabled= addMoneyButton.isEnabled();
    }

    @Given("Add butonu tıkla")
    public void addButtonTikla(){
        if(isEnabled){
            addMoneyButton.click();
        }
    }

}

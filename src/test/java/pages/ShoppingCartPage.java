package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=order&step=1']")
    WebElement finalCheckOut;

    @FindBy(xpath = "//ul[@id='address_delivery']")
    WebElement delAddress;

    @FindBy(xpath = "//ul[@id='address_invoice']")
    WebElement billAddress;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//button[@type='submit']")
    WebElement finalCheckOut1;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//button[@type='submit']")
    WebElement finalCheckOut2;

    @FindBy(xpath = "//a[@title='Close']")
    WebElement errorMessage;

    @FindBy(xpath = "//input[@id='cgv']")
    WebElement terms;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//button[@type='submit']")
    WebElement finalCheckout3;

    public void clickFinalCheckout() {
        finalCheckOut.click();
    }

    public void getAddress() {
        delAddress.getText().contains(
                "Ievgen Chyrva\n" +
                        "Forte\n" +
                        "1719 Grove St Apt 11\n" +
                        "Glenview, Illinois 60025\n" +
                        "United States\n" +
                        "5152270360\n" +
                        "5152270360");
    }

    public void getBillAddress() {
        billAddress.getText().contains(
                "Ievgen Chyrva\n" +
                        "Forte\n" +
                        "1719 Grove St Apt 11\n" +
                        "Glenview, Illinois 60025\n" +
                        "United States\n" +
                        "5152270360\n" +
                        "5152270360");
    }

    public void clickFinalCheckOut1() {
        finalCheckOut1.click();
    }

    public void clickFinalCheckOut2() {
        finalCheckOut2.click();
    }

    public void clickErrorMessage() {
        errorMessage.click();
    }

    public void clickTerms() throws InterruptedException {
        Thread.sleep(3000);
        terms.click();
    }

    public void clickFinalCheckOut3() {
        finalCheckout3.click();
    }

}

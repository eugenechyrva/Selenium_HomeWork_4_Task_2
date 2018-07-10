package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class PaymentOrderPage {
    WebDriver driver;

    public PaymentOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='cheque']")
    WebElement paymentCheck;

    @FindBy(xpath = "//p[@id='cart_navigation']//button[@type='submit']")
    WebElement confirmOrder;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement subOrd;

    @FindBy(xpath = "//a[@class='button-exclusive btn btn-default']")
    WebElement backOrders;

    @FindBy(xpath = "//td[@class='history_price']")
    WebElement amount;

    @FindBy(xpath = "//a[@class='logout']")
    WebElement logOut;

    public void clickCheck() {
        paymentCheck.click();
    }

    public void clickConfirmOrder() {
        confirmOrder.click();
    }

    public void getOrderText() {
        subOrd.getText();
        Assert.assertEquals(subOrd.getText(), "Your order on My Store is complete.");
    }

    public void clickBackOrders() {
        backOrders.click();
    }

    public void getAmount() {
        Assert.assertEquals(amount.getText(), "$28.00");
    }

    public void clickLogOut() {
        logOut.click();
    }

    public void wait3() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

}

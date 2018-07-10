package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MenuPage {
    WebDriver driver;

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//a[@href='http://automationpractice.com/index.php?id_category=3&controller=category']")
    WebElement womanLink;

    @FindBy(linkText = "Printed Dress")
    WebElement dressLink;

    @FindBy(xpath = "//p[@id='add_to_cart']//button[@type='submit']")
    WebElement addToCart;

    @FindBy(partialLinkText = "Proceed to checkout")
    WebElement checkOut;


    public void clickWomanLink() {
        womanLink.click();
    }

    public void wait1() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void clickDressLink() {
        dressLink.click();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void clickCheckOut() {
        checkOut.click();
    }

}

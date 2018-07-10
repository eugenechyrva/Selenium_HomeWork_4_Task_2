package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    WebDriver driver;
    LogInPage logInPage;
    MenuPage menuPage;
    ShoppingCartPage shoppingCartPage;
    PaymentOrderPage paymentOrderPage;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/Users/ievgenchyrva/Downloads/chromedriver");
        driver = new ChromeDriver();
        logInPage = new LogInPage(driver);
        menuPage = new MenuPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        paymentOrderPage = new PaymentOrderPage(driver);
    }

    @Given("^user navigates to the app url$")
    public void someTestInfo() {
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }

    //LogInPage
    @When("^user clicks on Sign In button$")
    public void userClicksOnSignInButton() {
        logInPage.clickSignIn();
    }

    @When("^user fills email field$")
    public void userFillsMailWithValue() {
        logInPage.setEmail("ievgen_chyrva@ukr.net");
    }

    @When("^user fills password field$")
    public void userFillsPasswordWithValue() {
        logInPage.setPassword("Test2018");
    }

    @When("^user clicks Log In button$")
    public void userClicksLogInButton() {
        logInPage.clickLogIn();
    }

    //MenuPage
    @When("^user clicks Woman link$")
    public void userClicksWomanLink() {
        menuPage.clickWomanLink();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @When("^user selects some dress$")
    public void userSelectsSomeClothDress() {
        menuPage.clickDressLink();
    }

    @When("^user clicks Add to Cart button$")
    public void userClicksAddToCartButton() {
        menuPage.clickAddToCart();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @When("^user clicks Check Out button$")
    public void userClicksCheckOutButton() {
        menuPage.clickCheckOut();
    }

    //ShoppingCartPage
    @When("^user clicks Final CheckOut button$")
    public void userClicksFinalCheckOutButton() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        shoppingCartPage.clickFinalCheckout();
    }

    @When("^user checks delivery address$")
    public void userCheckDeliveryAddress() {
        shoppingCartPage.getAddress();
    }

    @When("^user checks billing address$")
    public void userChecksBillingAddress() {
        shoppingCartPage.getBillAddress();
    }

    @When("^user clicks Next Check Out Button$")
    public void userClicksNextCheckOutButton() {
        shoppingCartPage.clickFinalCheckOut1();
        shoppingCartPage.clickFinalCheckOut2();
    }

    @When("^user closes Error message window$")
    public void userClosesErrorMessageWindow() {
        shoppingCartPage.clickErrorMessage();
    }

    @When("^user mark terms check box$")
    public void userMarkTermsCheckBox() throws InterruptedException {
        Thread.sleep(3000);
        shoppingCartPage.clickTerms();
    }

    @When("^user clicks Last Check Out button$")
    public void userClicksLastCheckOutButton() {
        shoppingCartPage.clickFinalCheckOut3();
    }

    //PaymentOrderPage
    @When("^user clicks on check payment option$")
    public void userClicksOnCheckPaymentOption() {
        paymentOrderPage.clickCheck();
    }

    @When("^user clicks Confirm Order link$")
    public void userClicksConfirmOrderLink() {
        paymentOrderPage.clickConfirmOrder();
    }

    @When("^user verifies if order confirmation text is present$")
    public void userVerifiesIfOrderConfirmationTextIsPresent() {
        paymentOrderPage.getOrderText();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @When("^user clicks on BackOrders button$")
    public void userClicksOnBackOrdersButton() {
        paymentOrderPage.clickBackOrders();
    }

    @Then("^order total amount is right$")
    public void orderTotalAmountIsRight() {
        paymentOrderPage.getAmount();
    }


    @After
    public void close() {
        paymentOrderPage.clickLogOut();
        driver.close();
        driver.quit();
    }

}












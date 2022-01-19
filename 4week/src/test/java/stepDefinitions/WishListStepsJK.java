package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import static org.junit.Assert.assertEquals;

public class WishListStepsJK {
    private WebDriver driver;
    static WishListPageJK wishListPageJK;
    static LoginPage loginPage;
    static GenericHeaderPage genericHeaderPage;
    static CategoriesPage categoriesPage;
    static WishListPage wishListPage;

    public WishListStepsJK() {
        this.driver = Hooks.driver;
        wishListPageJK = PageFactory.initElements(Hooks.driver, WishListPageJK.class);
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        genericHeaderPage = PageFactory.initElements(Hooks.driver, GenericHeaderPage.class);
        categoriesPage = PageFactory.initElements(Hooks.driver, CategoriesPage.class);
        wishListPage = PageFactory.initElements(Hooks.driver, WishListPage.class);


    }

    @Given("^I am on the Wish List page$")
    public void iAmOnTheWishListPage() {
        driver.get(wishListPageJK.getPageUrl());
    }

    @Then("^I click on top menu Wish List$")
    public void iClickOnTopMenuWishList() {
        genericHeaderPage.genClickTopWishlist();

    }

    @Then("^I see message on the Wish List page: \"([^\"]*)\"$")
    public void iSeeMessageOnTheWishListPage(String message) throws Throwable {
        wishListPageJK.msgWishListIsEmpty(message);

    }

    @Then("^I click on the categories menu Phone$")
    public void iClickOnTheCategoriesMenuPhone() {
        genericHeaderPage.genClickMenuPhones();
    }

    @Then("^I click Add to Wish List IPhone$")
    public void iClickAddToWishListIPhone() throws Exception {
        categoriesPage.catAddProductToWishList(2);
    }


    @Then("^I click on IPhone$")
    public void iClickOnIPhone() {
        wishListPageJK.clickOnIPhone();
    }

    @Then("^I click on icon Add to Wish List$")
    public void iClickOnIconAddToWishList() {
        wishListPageJK.clickOnAddToWishListFromProductPage();
    }


    @Given("^I am on main page$")
    public void iAmOnMainPage() {
        driver.get("http://demoshop24.com/");

    }

    @Then("^I click on icon Add to Wish List on the Main Page$")
    public void iClickOnIconAddToWishListOnTheMainPage() {
        wishListPageJK.clickAddToWishListOnMainPage();
    }

    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeErrorMessage(String message) throws Throwable {
        assertEquals("undefined", message);
    }

    @Then("^I see amount of items on the top menu Wish List$")
    public void iSeeAmountOfItemsOnTheTopMenuWishList() throws InterruptedException {
//        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class);
//        wait.until(ExpectedConditions.visibilityOf(genericHeaderPage.genTopWishlist));
        Thread.sleep(3000);
        System.out.println(genericHeaderPage.genWishListCount());
        assertEquals(genericHeaderPage.genWishListCount(), 1);

    }

    @Then("^I click on the WishList menu$")
    public void iClickOnTheWishListMenu() {
        genericHeaderPage.genClickTopWishlist();
    }

    @Then("^I clear Wish List$")
    public void iClearWishList() {
        wishListPage.wlClearWishList();
    }


    @Then("^I click Back button$")
    public void iClickBackButton() {
        driver.navigate().back();
    }

    @Then("^I click Refresh button$")
    public void iClickRefreshButton() {
        driver.navigate().refresh();
    }

    @Then("^I see another amount of items on the top menu Wish List$")
    public void iSeeAnotherAmountOfItemsOnTheTopMenuWishList() {
        System.out.println(genericHeaderPage.genWishListCount());
        assertEquals(genericHeaderPage.genWishListCount(), 0);
    }

    @Then("^I click on Testing Demo Shop$")
    public void iClickOnTestingDemoShop() {
        wishListPageJK.clickOnTestingDemoShop();
    }

}
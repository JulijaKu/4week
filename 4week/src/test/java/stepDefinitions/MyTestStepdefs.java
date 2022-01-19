package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_sample.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyTestStepdefs {
    private WebDriver driver;
    static LoginPage loginPage;
    static GenericHeaderPage genericHeaderPage;
    static WishListPage wishListPage;
    static ProductPage productPage;
    static CategoriesPage categoriesPage;
    static ShoppingCartPage shoppingCartPage;


    public MyTestStepdefs() {
        this.driver = Hooks.driver;
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        genericHeaderPage = PageFactory.initElements(Hooks.driver, GenericHeaderPage.class);
        wishListPage = PageFactory.initElements(Hooks.driver, WishListPage.class);
        productPage = PageFactory.initElements(Hooks.driver, ProductPage.class);
        categoriesPage = PageFactory.initElements(Hooks.driver, CategoriesPage.class);
        shoppingCartPage = PageFactory.initElements(Hooks.driver, ShoppingCartPage.class);
    }


    // @When("^I move to category: "([^"]*)"$")
    //          public void iMoveToCategory(String category) throws Throwable {
    // categoriesPage.clickMenuOnTheLeft(category);
    //  }

    @Given("^I go to login page$")
    public void iAmOnLoginPage() {
        driver.get(loginPage.getPageUrl());
    }

    @And("^pause$")
    public void pause() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Then("^I enter my login \"([^\"]*)\"$")
    public void iEnterMyLogin(String email) throws Throwable {
        loginPage.loginEnterEmail(email);
    }

    @Then("^I enter my password \"([^\"]*)\"$")
    public void iEnterMyPassword(String pass) throws Throwable {
        loginPage.loginEnterPass(pass);
    }

    @Then("^I click login$")
    public void iClickLogin() {
        loginPage.clickLogin();
    }

    @Then("^I go to my account page$")
    public void iAmOnMyAccountPage() {
        String expectedUrl = "http://www.demoshop24.com/index.php?route=account/account";
        driver.get(expectedUrl);
        try {
            assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
    }


    @Then("^I go to wishlist page$")
    public void iGoToWishlistPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul[class='list-inline']>li:nth-of-type(3)"))).click();
        genericHeaderPage.genTopWishlist.click();

    }

    @Then("^I check the wishlist is empty$")
    public void iCheckTheWishlistIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(wishListPage.wlEmptyMessage));
        assertEquals("Your wish list is empty.", wishListPage.wlEmptyList());
    }

    @Then("^I click on add to wishlist button$")
    public void iClickOnAddToWishlistButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")));
        productPage.productPageClickAddToWishlistBtn();
    }

    @Then("^I check the product added is in wishlist$")
    public void iCheckTheProductAddedIsInWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tbody>tr")));
        assertEquals("Sony VAIO", wishListPage.wlGetWlCellValue(1, 2));
    }

    @Then("^I print the name of the first product$")
    public void iPrintTheNameOfTheProduct1() {
        System.out.println(wishListPage.wlGetWlCellValue(1, 2));
    }

    @Then("^I check the second product added is in wishlist$")
    public void iCheckTheProduct2AddedIsInWishlist() {
        assertEquals("HTC Touch HD", wishListPage.wlGetWlCellValue(1, 2));
    }

    @Then("^I print the name of the second product$")
    public void iPrintTheNameOfTheProduct2() {
        System.out.println(wishListPage.wlGetWlCellValue(1, 2));
    }

    @Then("^I go to phones category$")
    public void iGoToPhonesCategory() {
        genericHeaderPage.genClickMenuPhones();
    }

    @Then("^I add the first product to wishlist$")
    public void iAddTheFirstProductToWishlist() throws Exception {
        categoriesPage.catAddProductToWishList(0);
    }

    @Then("^I set sort to default$")
    public void iSetSortToDefault() {
        categoriesPage.setDropDownOptionDefault();
    }

    @Then("^I print the product name$")
    public void iPrintTheProductName() throws Exception {
        System.out.println("the name of the product I want to add to wishlist is " + categoriesPage.catGetProdName(0));
    }

    @Then("^I check the same product is in wishlist$")
    public void iCheckTheSameProductIsInWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(wishListPage.wlTable));
        assertEquals("HTC Touch HD", wishListPage.wlGetWlCellValue(1, 2));
    }

    @Then("^I print the name of the product from the wishlist$")
    public void iPrintTheNameOfTheProductFromTheWishlist() {
        System.out.println("the name of the product I added to wishlist is " + wishListPage.wlGetWlCellValue(1, 2));
    }

    @Then("^I remove two items from wishlist$")
    public void iRemoveItemsFromWishlist() {
        wishListPage.wlRemoveProdFromWl(1);
        wishListPage.wlRemoveProdFromWl(1);
    }

    @Then("^I remove the item from wishlist$")
    public void iRemoveTheItemFromWishlist() {
        wishListPage.wlRemoveProdFromWl(1);
    }

    @Then("^I check there is only one item in wishlist$")
    public void iCheckThereIsOnlyOneItemInWishlist() {
        assertEquals(driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).getText(), "Wish List (1)");
    }


    @Then("^I add the first product to wishlist more than once$")
    public void iAddTheFirstProductToWishlistMoreThanOnce() throws Exception {
        for (int i = 0; i < 5; i++) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[ data-original-title='Add to Wish List']")));
            categoriesPage.catAddProductToWishList(0);

        }
    }

    @When("^I go to product page$")
    public void iGoToProductPage() {
        driver.get("http://www.demoshop24.com/index.php?route=product/product&path=20&product_id=40");
    }

    @Then("^I clear wishlist$")
    public void iClearWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(wishListPage.wlTable));
        wishListPage.wlClearWishList();
    }

    @Then("^I check there one item in the wishlist$")
    public void iCheckThereOneItemInTheWishlist() {
        assertEquals("1", wishListPage.wlNumberOfProductsInTheWl()
        );
    }

    @Then("^I click on add to wishlist button more than once$")
    public void iClickOnAddToWishlistButtonMoreThanOnce() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")));
            productPage.productPageClickAddToWishlistBtn();
        }
    }

    @Then("^I count the quantity of items in wishlist$")
    public void iCountTheQuantityOfItemsInWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody>tr")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tbody>tr")));
        System.out.println(wishListPage.wlNumberOfProductsInTheWl());
        assertEquals(1, wishListPage.wlNumberOfProductsInTheWl());
    }

    @Then("^I click refresh from wishlist page$")
    public void iClickRefreshFromWishlistPage() throws InterruptedException {
        driver.navigate().refresh();
    }

    @Then("^I click logout$")
    public void iClickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"))).click();


    }

    //*[@id="top-links"]/ul/li[2]/a
    @Then("^I click my account login$")
    public void iClickMyAccountLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"))).click();
    }

    @Then("^I go to \"([^\"]*)\" page$")
    public void iGoToPage(String product) throws Throwable {
        driver.get(product);
    }

    @Then("^I check there are two items in the wishlist$")
    public void iCheckThereAre2ItemsInTheWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody>tr")));
        System.out.println(wishListPage.wlNumberOfProductsInTheWl());
        assertEquals(2, wishListPage.wlNumberOfProductsInTheWl());
    }

    @Then("^I click on the product name to get to its page$")
    public void iClickOnTheProductNameToGetToItsPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]/a"))).click();
    }

    @Then("^I check the name of the product$")
    public void iCheckTheNameOfTheProduct() {
        assertEquals("iPhone", productPage.productPageCheckProductName());
    }

    @Then("^I add this product to cart$")
    public void iAddThisProductToCart() {
        wishListPage.wlAddProdToCart(1);
    }

    @Then("^I go to cart to check the added product$")
    public void iGoToCartToCheckTheAddedProduct() {
        genericHeaderPage.genClickTopCart();
    }

    @Then("^I check added product is in cart$")
    public void iCheckAddedProductIsInCart() {
        assertEquals("product 11", shoppingCartPage.scGetSCCellValue(1, 3));
    }

    @Then("^I remove the added product from cart$")
    public void iRemoveTheAddedProductFromCart() {
        shoppingCartPage.scRemoveProdFromSC(1);
    }

    @Then("^I go to the out-of-stock item page$")
    public void iGoToTheOutOfStockItemPage() {
        driver.get("http://www.demoshop24.com/index.php?route=product/product&path=57&product_id=49");
    }

    @Then("^I add out-of-stock item to wishlist$")
    public void iAddOutOfStockItemToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]"))).click();
    }

    @Then("^I check out-of-stock item is in wishlist$")
    public void iCheckOutOfStockItemIsInWishlist() {
        assertEquals("Samsung Galaxy Tab 10.1", wishListPage.wlGetWlCellValue(1, 2));
    }

    @Then("^I check out-of-stock item is in cart$")
    public void iCheckOutOfStockItemIsInCart() {
        assertEquals("SAM1", shoppingCartPage.scGetSCCellValue(1, 3));
    }

    @Then("^I check there is alert message$")
    public void iCheckThereIsAlertMessage() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")).isDisplayed());
    }
}

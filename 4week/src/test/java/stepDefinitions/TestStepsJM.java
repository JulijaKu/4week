package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_sample.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStepsJM {
    private final WebDriver driver;
    static GenericHeaderPage header;
    static CategoriesPage cats;
    static ComparisonPage comp;
    static WishListPage wl;
    static ShoppingCartPage cart;
    public String tempString;


    public TestStepsJM() {
        this.driver = Hooks.driver;
        header = PageFactory.initElements(Hooks.driver, GenericHeaderPage.class);
        cats = PageFactory.initElements(Hooks.driver, CategoriesPage.class);
        comp = PageFactory.initElements(Hooks.driver, ComparisonPage.class);
        wl = PageFactory.initElements(Hooks.driver, WishListPage.class);
        cart = PageFactory.initElements(Hooks.driver, ShoppingCartPage.class);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Given("^I am on Cameras page$")
    public void iAmOnCameraPage() throws Throwable {
        driver.get("http://www.demoshop24.com/index.php?route=product/category&path=33");
    }

    //  MOVING ON TOP MENU
    @Then("^I click top menu wishlist$")
    public void iClickTopMenuWishlist() {
        header.genClickTopWishlist();
    }

    @Then("^I click top menu cart$")
    public void iClickCartOnTop() {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(header.genTopCart));
        header.genClickTopCart();
    }

    // MOVING ON TOP CATEGORIES
    @When("^I move to top category: Cameras$")
    public void iMoveToTopCategoryCameras() {
        header.genClickMenuCameras();
    }

    // MOVING ON LEFT MENU
    @When("^I move to category: \"([^\"]*)\"$")
    public void iMoveToCategory(String category) throws Throwable {
        cats.clickMenuOnTheLeft(category);
    }

    // CHECKS
    @And("^check if left side menu is visible$")
    public void checkIfLeftSideMenuIsVisible() {
        System.out.println(cats.ifLeftMenuIsShown());
        assertTrue(cats.ifLeftMenuIsShown());
    }

    @And("^I check number of products on Cameras page$")
    public void iCheckNumberOfProductsOnCamerasPage() throws Exception {
        System.out.println("Cameras should be 2, are " + cats.getNumbOfElements());
        assertEquals(cats.getNumbOfElements(), 2);
    }

    @And("^I check number of products on Laptops page$")
    public void iCheckNumberOfProductsOnLaptopsPage() throws Exception {
        System.out.println("Laptops should be 5, are " + cats.getNumbOfElements());
        assertEquals(cats.getNumbOfElements(), 5);
    }

    @And("^I check number of products on Macs page$")
    public void iCheckNumberOfProductsOnMacsPage() throws Exception {
        System.out.println("Macs should be 3 (error on site), are " + cats.getNumbOfElements());
        assertEquals(cats.getNumbOfElements(), 3);
    }

    @And("^check that number of products in category and its name is equal$")
    public void checkThatNumberOfProductsInCategoryAndItsNameIsEqual() throws Exception {
        System.out.println("Number of products are " + cats.getNumbOfElements());
        String cat = cats.catGetCategoryName();
        System.out.println(cats.catGetCategoryCount(cat));
        assertEquals(cats.getNumbOfElements(), cats.catGetCategoryCount(cat));
    }

    @And("^check that number of products in names of subcategories is equal to number of product in name of category$")
    public void checkThatNumberOfProductsInNamesOfSubcategoriesIsEqualToNumberOfProductInNameOfCategory() {
        assertEquals(cats.catGetCategoryCount("Components"), cats.getCompTotalFromNamesOfSubcategories());
    }

    @And("^I click on a first product$")
    public void iClickOnAFirstProduct() throws Exception {
        cats.catClickOnTheProduct(1);
    }

    @And("^I click back$")
    public void iClickBack() {
        driver.navigate().back();
    }

    @Then("^Sort is still by field to Name \\(Z-A\\)$")
    public void sortIsStillByFieldToNameZA() {
        assertEquals(cats.getDropDownOption(), "Name (Z - A)");
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(cats.catSortDropdown));
    }

    @And("^I press on Compare icon on second product$")
    public void iPressOnCompareIconOnSecondProduct() throws Exception {
        cats.catAddProductToCompare(2);
        System.out.println(cats.catGetProdName(2));
        tempString = cats.catGetProdName(2);
    }

    @And("^I press on Product comparison link in success message$")
    public void iPressOnProductComparisonLinkInSuccessMessage() throws InterruptedException {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(cats.compSuccessMessage));
        cats.catCompSuccessMessageClick();
    }

    @Then("^Comparison page is opened$")
    public void comparisonPageIsOpened() {
        assertEquals(comp.compGetPageName(), "Product Comparison");
    }

    @And("^product is in comparison table$")
    public void productIsInComparisonTable() {
        System.out.println(comp.compGetCellValue(1, 1));
        assertEquals(comp.compGetCellValue(1, 1), tempString);
    }

    @And("^I press on Add to Cart icon on second product$")
    public void iPressOnAddToCartIconOnSecondProduct() throws Exception {
        cats.catAddProductToCart(2);
        tempString = cats.catGetProdName(2);
    }

    @And("^product is in the cart$")
    public void productIsInTheCart() {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content']/h1")));
        assertEquals(cart.scGetSCCellValue(1, 2), tempString);
    }

    @And("^I choose Grid view$")
    public void iChooseGridView() {
        cats.clickGridView();
    }

    @And("^I choose List view$")
    public void iChooseListView() {
        cats.clickListView();
    }

    @When("^I set Sort by field to: Name \\(A - Z\\)$")
    public void iSetSortByFieldToNameAZ() {
        cats.setDropDownOption("Name (A - Z)");
    }

    @When("^I set Sort by field to: Name \\(Z - A\\)$")
    public void iSetSortByFieldToNameZA() {
        cats.setDropDownOption("Name (Z - A)");
    }

    @When("^I set Sort by field Price \\(Low > High\\)$")
    public void iSetSortByFieldPriceLowHigh() {
        cats.setDropDownOption("Price (Low > High)");
    }

    @When("^I set Sort by field Price \\(High > Low\\)$")
    public void iSetSortByFieldPriceHighLow() {
        cats.setDropDownOption("Price (High > Low)");
    }

    @When("^I set Sort by field Rating \\(Highest\\)$")
    public void iSetSortByFieldRatingHighest() {
        cats.setDropDownOption("Rating (Highest)");
    }

    @When("^I set Sort by field Rating \\(Lowest\\)$")
    public void iSetSortByFieldRatingLowest() {
        cats.setDropDownOption("Rating (Lowest)");
    }

    @Then("^products are sorted alphabetically$")
    public void productsAreSortedAlphabetically() throws Exception {
        assertEquals(cats.checkIfProductsAreAlphabetical(), true);
    }

    @Then("^products are sorted in reverse alphabet order$")
    public void productsAreSortedInReverseAlphabetOrder() throws Exception {
        assertEquals(cats.checkIfProductsAreReverseAlphabetical(), true);
    }

    @Then("^products are sorted by increasing price$")
    public void productsAreSortedByIncreasingPrice() throws Exception {
        assertEquals(cats.checkIfProductsAreWithIncreasingPrice(), true);
    }

    @Then("^products are sorted by decreasing price$")
    public void productsAreSortedByDecreasingPrice() throws Exception {
        assertEquals(cats.checkIfProductsAreWithDecreasingPrice(), true);
    }

    @Then("^products are sorted by increasing rating$")
    public void productsAreSortedByIncreasingRating() throws Exception {
        cats.checkIfProductsAreWithHighRatingFirst();
    }

    @Then("^products are sorted by decreasing rating$")
    public void productsAreSortedByDecreasingRating() {
    }


}

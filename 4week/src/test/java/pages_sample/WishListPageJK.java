package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class WishListPageJK {

    @FindBy(how = How.CSS, using = "table[class=\"table table-bordered table-hover\"]>tbody>tr>td:nth-of-type(6)>button")
    private WebElement wishListClickAddToCardButton;

    @FindBy(how = How.CLASS_NAME, using = "btn-danger")
    private WebElement wishListClickRemoveButton;

    @FindBy(how = How.CSS, using = "table[class = 'table table-bordered table-hover']>tbody>tr>td:nth-of-type(2)>a")
    private WebElement wishListClickProductNameItem;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Continue')]")
    private WebElement wishListClickContinueButton;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Your wish list is empty')]")
    private WebElement msgWishListIsEmpty;

    @FindBy(how = How.CSS, using = "#content>div.row>div:nth-child(1)>div>div.button-group > button:nth-child(2)")
    private WebElement clickAddToWishListOnMainPage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[1]/h4/a")
    private WebElement clickOnIPhone;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")
    private WebElement clickOnAddToWishListFromProductPage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"logo\"]/h1/a")
    private WebElement clickOnTestingDemoShop;


    public String getPageUrl() {

        return "http://www.demoshop24.com/index.php?route=account/wishlist";
    }

    public void wishListClickAddToCardButton() {

        wishListClickAddToCardButton.click();
    }

    public void wishListClickRemoveButton() {
        wishListClickRemoveButton.click();
    }

    public void wishListClickContinueButton() {
        wishListClickContinueButton.click();
    }

    public void wishListClickProductNameItem() {
        wishListClickProductNameItem.click();
    }

    public void msgWishListIsEmpty(String message) {
        assertEquals("Your wish list is empty.", message);
    }

    public void clickAddToWishListOnMainPage() {
        clickAddToWishListOnMainPage.click();
    }

    public void clickOnIPhone() {
        clickOnIPhone.click();
    }

    public void clickOnAddToWishListFromProductPage() {
        clickOnAddToWishListFromProductPage.click();
    }

    public void clickOnTestingDemoShop() {
        clickOnTestingDemoShop.click();
    }

}

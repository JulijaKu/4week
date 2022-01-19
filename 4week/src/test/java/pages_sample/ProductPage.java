package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class ProductPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/h1")
    private WebElement productPageProductName;

    @FindBy(how = How.XPATH, using = " //*[@id=\"content\"]/div[1]/div[2]/ul[1]/li[2]")
    private WebElement productPageProductCode;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")
    private WebElement productPageAddToWishlistBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[2]")
    private WebElement productPageCompareProductBtn;

    @FindBy(how = How.ID, using = "button-cart")
    private WebElement productPageAddToCartBtn;

    public String getPageUrl() {
        return "http://www.demoshop24.com/index.php?route=product/product&path=24&product_id=40";
    }

    public String productPageCheckProductName() {
        String productName;
        return (productName = productPageProductName.getText());
    }

    public void productPageClickAddToWishlistBtn() {
        productPageAddToWishlistBtn.click();
    }

    public String productPageCheckProductCode() {
        String productCode;
        return (productCode = productPageProductCode.getText());
    }

    public void productPageClickCompareProductBtn() {
        productPageCompareProductBtn.click();
    }

    public void productPageClickAddToCartBtn() {
        productPageAddToCartBtn.click();
    }
}
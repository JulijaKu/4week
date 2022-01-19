package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ShoppingCartPage {


    @FindBy(how = How.XPATH, using = "//div[@id='content']/form/div/table")
    public WebElement scTable;
    @FindBy(how = How.XPATH, using = "//div[@id='content']/p")
    public WebElement scEmptyMessage;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/p,'There are no products to list in this category')]")
    public WebElement msgCategoryIsEmpty;
    @FindBy(how = How.XPATH, using = "//nav[@id='menu']/div[2]")
    public WebElement topMenu;
    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(3)>div>a")
    public WebElement genMenuComponentsShowAll;

    public void genClickCompShowAll() {
        genMenuComponentsShowAll.click();
    }

    public boolean ifTopMenuIsShown() {
        return topMenu.isDisplayed();
    }

    public String scEmptyMessage() {
        return scEmptyMessage.getText();
    }

    public int scTableLength() {
        int length = scTable.findElements(By.cssSelector("tbody>tr")).size();
        return length;
    }

    public int scTableWidth() {
        int width = scTable.findElements(By.cssSelector("tbody>tr:nth-of-type(1)>td")).size();
        return width;
    }

    public String scGetSCCellValue(int i, int j) {
        i--;
        j--;
        List<WebElement> rowVals = scTable.findElements(By.cssSelector("tbody>tr"));
        List<WebElement> colVals = rowVals.get(i).findElements((By.tagName("td")));
        return colVals.get(j).getText();
    }

    public void scRemoveProdFromSC(int i) {
        WebElement scRemoveButton = scTable.findElement(By.xpath("tbody/tr[" + i + "]/td[4]/div/span/button[2]"));
        scRemoveButton.click();
    }


    public int scNumberOfProductsInTheSC() {
        return (scTableLength());
    }

    public void scClearCart() throws InterruptedException {
        int count = scNumberOfProductsInTheSC();
        for (int j = 1; j <= count; j++) {
            scRemoveProdFromSC(1);
            Thread.sleep(1000);
        }

    }

    public void msgCategoryIsEmpty(String message) throws Throwable {
        assertEquals("There are no products to list in this category", message);

    }
}
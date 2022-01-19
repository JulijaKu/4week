package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class WishListPage {
    @FindBy(how = How.XPATH, using = "//div[@id='content']/div[1]/table")
    public WebElement wlTable;

    @FindBy(how = How.XPATH, using = "//div[@id='content']/p")
    public WebElement wlEmptyMessage;


    public String wlEmptyList() {
        return wlEmptyMessage.getText();
    }

    public int wlTableLength() {
        int length = wlTable.findElements(By.cssSelector("tbody>tr")).size();
        return length;
    }

    public int wlTableWidth() {
        int width = wlTable.findElements(By.cssSelector("tbody>tr:nth-of-type(1)>td")).size();
        return width;
    }

    public String wlGetWlCellValue(int i, int j) {
        i--;
        j--;
        List<WebElement> rowVals = wlTable.findElements(By.cssSelector("tbody>tr"));
        List<WebElement> colVals = rowVals.get(i).findElements((By.tagName("td")));
        return colVals.get(j).getText();
    }

    public void wlRemoveProdFromWl(int i) {
        WebElement wlRemoveButton = wlTable.findElement(By.xpath("tbody/tr[" + i + "]/td[6]/a"));
        wlRemoveButton.click();
    }

    public void wlAddProdToCart(int i) {
        WebElement wlAddButton = wlTable.findElement(By.xpath("tbody/tr[" + i + "]/td[6]/button"));
        wlAddButton.click();
    }

    public int wlNumberOfProductsInTheWl() {
        return (wlTableLength());
    }

    public void wlClearWishList() {
        int count = wlNumberOfProductsInTheWl();
        for (int j = 1; j <= count; j++) {
            wlRemoveProdFromWl(1);
        }
    }


}
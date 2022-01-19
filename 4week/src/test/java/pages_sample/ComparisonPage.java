package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ComparisonPage {
    @FindBy(how = How.XPATH, using = "//div[@id='content']/table")
    public WebElement compTable;

    @FindBy(how = How.CSS, using = "div[id='content']>p")
    public WebElement compEmptyListMessage;

    @FindBy(how = How.XPATH, using = "//div[@id='content']/h1")
    public WebElement compHeader;

    public String compGetPageName() {
        return compHeader.getText();
    }

    public String compEmptyList() {
        return compEmptyListMessage.getText();
    }

    public int compTableLength() {
        int length = compTable.findElements(By.cssSelector("tbody:nth-of-type(1)>tr")).size();
        return length;
    }

    public int compTableWidth() {
        int width = compTable.findElements(By.cssSelector("tbody:nth-of-type(1)>tr:nth-of-type(1)>td")).size();
        return width;
    }

    public void compTablePrint() {
        List<WebElement> rowVals = compTable.findElements(By.cssSelector("tbody:nth-of-type(1)>tr"));
        for (int i = 0; i < compTableLength(); i++) {
            List<WebElement> colVals = rowVals.get(i).findElements((By.tagName("td")));
            for (int j = 1; j < compTableWidth(); j++) {
                System.out.println(colVals.get(j).getText());
            }

        }
    }

    public String compGetCellValue(int i, int j) {
        i--;
        List<WebElement> rowVals = compTable.findElements(By.cssSelector("tbody:nth-of-type(1)>tr"));
        List<WebElement> colVals = rowVals.get(i).findElements((By.tagName("td")));
        return colVals.get(j).getText();
    }

    public int compGetNumberOfProducts() {
        return compTableWidth() - 1;
    }

}

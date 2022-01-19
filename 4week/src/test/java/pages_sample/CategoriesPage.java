package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class CategoriesPage {
    // LEFT MENU

    @FindBy(how = How.CSS, using = "aside>div.list-group")
    public WebElement catLeftMenu;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'Desktops (')]")
    public WebElement catMenuDesktops;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- PC (')]")
    public WebElement catMenuDesktopsPC;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- Mac (')]")
    public WebElement catMenuDesktopsMac;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'Laptops & Notebooks (')]")
    public WebElement catMenuLaptops;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- Macs (')]")
    public WebElement catMenuLaptopsMacs;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- Windows (')]")
    public WebElement catMenuLaptopsWindows;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'Components (')]")
    public WebElement catMenuComponents;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- Mice and Trackballs (')]")
    public WebElement catMenuCompMice;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- Monitors (')]")
    public WebElement catMenuCompMonitors;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- Printers (')]")
    public WebElement catMenuPrinters;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- Scanners (')]")
    public WebElement catMenuScanners;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'- Web Cameras (')]")
    public WebElement catMenuWebCams;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'Tablets (')]")
    public WebElement catMenuTablets;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'Software (')]")
    public WebElement catMenuSoftware;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'Phones & PDAs (')]")
    public WebElement catMenuPhones;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'Cameras (')]")
    public WebElement catMenuCameras;

    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[contains(text(),'MP3 Players (')]")
    public WebElement catMenuMp3Players;


    // Service elements
    @FindBy(how = How.TAG_NAME, using = "h2")
    public WebElement catHeader;

    @FindBy(how = How.CSS, using = "button#list-view")
    public WebElement catListButton;

    @FindBy(how = How.CSS, using = "button#grid-view")
    public WebElement catGridButton;

    @FindBy(how = How.CSS, using = "select#input-sort")
    public WebElement catSortDropdown;

    @FindBy(how = How.CSS, using = "div#content>div.row:nth-of-type(2)")
    public WebElement catProducts;

    @FindBy(how = How.XPATH, using = "//div[@id='content']/div[2]/div")
    public List<WebElement> allProdVar1;

    @FindBy(how = How.XPATH, using = "//div[@id='content']/div[3]/div")
    public List<WebElement> allProdVar2;

    @FindBy(how = How.XPATH, using = "//div[@id='content']/div[4]/div")
    public List<WebElement> allProdVar3;

    @FindBy(how = How.XPATH, using = "//div[@id='content']")
    public WebElement catContent;


    @FindBy(how = How.XPATH, using = "//div[@id='product-category']/div[1]")
    public WebElement compSuccessMessage;

    @FindBy(how = How.XPATH, using = "//div[@id='product-category']/div[1]/a[2]")
    public WebElement compSuccessMessageLink;

    @FindBy(how = How.XPATH, using = "//*[@id='content']/p")
    public WebElement catEmptyMessage;

// METHODS

    //returns category name
    public String catGetCategoryName() {
        return catHeader.getText();
    }

    // returns true if Menu on the left side is displayed
    public boolean ifLeftMenuIsShown() {
        return catLeftMenu.isDisplayed();
    }

    //uses String with the name of the menu, without numbers, e.g. "Mac", clicks on the menu
    public void clickMenuOnTheLeft(String s) {
        chooseMenuElement(s).click();
    }

    //uses String with the name of the menu, without numbers, e.g. "Mac", returns the number of products in the category
    public int catGetCategoryCount(String s) {
        WebElement el = chooseMenuElement(s);
        return catGetCount(el);
    }

    //Returns the message, that the product has been added to the Comparison list
    public String catCompSuccessMessage() throws InterruptedException {
        return compSuccessMessage.getText();
    }

    //Clicks on the link from the message, that the product has been added to the comparison list
    public void catCompSuccessMessageClick() throws InterruptedException {
        compSuccessMessageLink.click();
    }

    //2 methods for choosing List or Grid view
    public void clickListView() {
        catListButton.click();
    }

    public void clickGridView() {
        catGridButton.click();
    }

    // returns number of products shown on the page
    public int getNumbOfElements() throws Exception {
        List<WebElement> allProd = findTableOnAPage();
        int length = 0;
        if (allProd != null) {
            length = allProd.size();
        }
        return length;
    }

    // takes place number of the product on the page, returns product name
    public String catGetProdName(int i) throws Exception {
        List<WebElement> allProd = findTableOnAPage();
        if (allProd != null) {
            return (getProdName(allProd.get(i)));
        } else return null;
    }

    // takes place number of the product on the page, returns product price
    public String catGetProdPrice(int i) throws Exception {
        List<WebElement> allProd = findTableOnAPage();
        if (allProd != null) {
            return (getProdPrice(allProd.get(i)));
        } else return null;
    }

    // takes place number of the product on the page, returns product rating
    public int catGetProductRating(int i) throws Exception {
        List<WebElement> allProd = findTableOnAPage();
        if (allProd != null) {
            return (getProdRating(allProd.get(i)));
        } else {
            return 0;
        }

    }

    //takes place number of the product on the page, clicks on the product name
    public void catClickOnTheProduct(int i) throws Exception {
        List<WebElement> allProd = findTableOnAPage();
        if (allProd != null) {
            getProdLink(allProd.get(i)).click();
        }
    }

    // takes place number of the product on the page, adds product to the cart
    public void catAddProductToCart(int i) throws Exception {
        List<WebElement> allProd = findTableOnAPage();
        if (allProd != null) {
            addProdToCart(allProd.get(i));
        }
    }

    // takes place number of the product on the page, adds product to the wishlist
    public void catAddProductToWishList(int i) throws Exception {
        List<WebElement> allProd = findTableOnAPage();
        if (allProd != null) {
            addProdToWishlist(allProd.get(i));
        }
    }

    // takes place number of the product on the page, adds product to the Comparison list
    public void catAddProductToCompare(int i) throws Exception {
        List<WebElement> allProd = findTableOnAPage();
        if (allProd != null) {
            addProdToCompare(allProd.get(i));
        }
    }

    //selects view from dropdown by index
    public void setDropDownOption(int i) {
        Select DdList = new Select(catSortDropdown);
        DdList.selectByIndex(i);
    }

    //selects view from dropdown by name
    public void setDropDownOption(String s) {
        Select DdList = new Select(catSortDropdown);
        DdList.selectByVisibleText(s);
    }

    //returns view from dropdown to default
    public void setDropDownOptionDefault() {
        Select DdList = new Select(catSortDropdown);
        DdList.selectByVisibleText("Default");
    }

    //method for a test - counts the total of products from subcategories of "Components", numbers are taken from names
    public int getCompTotalFromNamesOfSubcategories() {
        int results = catGetCategoryCount("Mice and Trackballs") + catGetCategoryCount("Monitors") +
                catGetCategoryCount("Printers") + catGetCategoryCount("Scanners") + catGetCategoryCount("Web Cameras");
        return results;
    }

    //returns currently shown dropdown option
    public String getDropDownOption() {
        Select DdList = new Select(catSortDropdown);
        WebElement option = DdList.getFirstSelectedOption();
        String curOption = option.getText();
        return curOption;
    }

// CHECKS

    public boolean checkIfProductsAreAlphabetical() throws Exception {
        int count = getNumbOfElements();
        ArrayList<String> arrlist = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            String s = catGetProdName(i);
            arrlist.add(i, s);
        }
        List copy = new ArrayList(arrlist);
        Collections.sort(copy);
        return copy.equals(arrlist);
    }

    public boolean checkIfProductsAreReverseAlphabetical() throws Exception {
        int count = getNumbOfElements();
        ArrayList<String> arrlist = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            arrlist.add(i, catGetProdName(i));
        }
        List copy = new ArrayList(arrlist);
        Collections.sort(copy, Collections.reverseOrder());
        return copy.equals(arrlist);
    }

    public boolean checkIfProductsAreWithIncreasingPrice() throws Exception {
        int count = getNumbOfElements();
        ArrayList<Integer> arrlist = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            String s = catGetProdPrice(i).trim();
            String newStr = s.substring(0, s.length() - 3);
            s = newStr.replace(",", "");
            int j = Integer.valueOf(s);
            arrlist.add(i, j);
        }
        List copy = new ArrayList(arrlist);
        Collections.sort(copy);
        return copy.equals(arrlist);
    }

    public boolean checkIfProductsAreWithDecreasingPrice() throws Exception {
        int count = getNumbOfElements();
        ArrayList<Integer> arrlist = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            String s = catGetProdPrice(i).trim();
            String newStr = s.substring(0, s.length() - 3);
            s = newStr.replace(",", "");
            int j = Integer.valueOf(s);
            arrlist.add(i, j);
        }
        List copy = new ArrayList(arrlist);
        Collections.sort(copy, Collections.reverseOrder());
        return copy.equals(arrlist);
    }

    public void checkIfProductsAreWithHighRatingFirst() throws Exception {
        int count = getNumbOfElements();
        ArrayList<Integer> arrlist = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            int rating = catGetProductRating(i);
            System.out.println("product number " + i + " rating is " + rating);


        }
    }


// SERVICE METHODS

    public List<WebElement> findTableOnAPage() throws Exception {
        List<WebElement> allProd = null;
        if (!catCategoryEmpty()) {
            int i1 = catContent.findElements(By.xpath("./div[1]/*")).size();
            int i2 = catContent.findElements(By.xpath("./div[2]/*")).size();
            int i3 = catContent.findElements(By.xpath("./div[3]/*")).size();

            if (i1 == 4) {
                allProd = allProdVar1;
            } else if (i2 == 4) {
                allProd = allProdVar2;
            } else if (i3 == 4) {
                allProd = allProdVar3;
            } else allProd = null;
        }

        return allProd;
    }

    public WebElement chooseMenuElement(String s) {
        WebElement el;
        switch (s) {
            case "Desktops":
                el = catMenuDesktops;
                break;
            case "PC":
                el = catMenuDesktopsPC;
                break;
            case "Mac":
                el = catMenuDesktopsMac;
                break;
            case "Laptops & Notebooks":
                el = catMenuLaptops;
                break;
            case "Macs":
                el = catMenuLaptopsMacs;
                break;
            case "Windows":
                el = catMenuLaptopsWindows;
                break;
            case "Components":
                el = catMenuComponents;
                break;
            case "Mice and Trackballs":
                el = catMenuCompMice;
                break;
            case "Monitors":
                el = catMenuCompMonitors;
                break;
            case "Printers":
                el = catMenuPrinters;
                break;
            case "Scanners":
                el = catMenuScanners;
                break;
            case "Web Cameras":
                el = catMenuWebCams;
                break;
            case "Tablets":
                el = catMenuTablets;
                break;
            case "Software":
                el = catMenuSoftware;
                break;
            case "Phones & PDAs":
                el = catMenuPhones;
                break;
            case "Cameras":
                el = catMenuCameras;
                break;
            case "MP3 Players":
                el = catMenuMp3Players;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
        return el;
    }

    public boolean catCategoryEmpty() throws Exception {
        try {
            catContent.findElement(By.xpath("//p"));
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }


    public int catGetCount(WebElement el) {
        String string = el.getText();
        int i = string.length();
        int j = string.indexOf("(");
        String newStr = string.substring(j + 1, i - 1);
        int count = Integer.valueOf(newStr);
        return count;
    }

    public String getProdName(WebElement el) {
        WebElement name = el.findElement(By.cssSelector("div[class='caption']>h4>a"));
        return (name.getText());
    }

    public String getProdPrice(WebElement el) {
        WebElement pr = el.findElement(By.cssSelector("p[class='price']"));
        String price = pr.getText();
        int i = price.indexOf("Ex Tax:");
        String newPrice = price.substring(1, i);
        return (newPrice);
    }

    public int getProdRating(WebElement el) throws Exception {
        WebElement newEl = el;
        if (!catRatingEmpty(newEl)) {
            WebElement rating = el.findElement(By.xpath("//div[@class='rating']"));
//                    (By.xpath("//div/div[2]/div[1]/div[@class='rating']"));
            int stars = 0;

            int i1 = rating.findElements(By.xpath("./span[1]/*")).size();
            int i2 = rating.findElements(By.xpath("./span[2]/*")).size();
            int i3 = rating.findElements(By.xpath("./span[3]/*")).size();
            int i4 = rating.findElements(By.xpath("./span[4]/*")).size();
            int i5 = rating.findElements(By.xpath("./span[5]/*")).size();
            System.out.println(getProdName(el));
            System.out.println(i1 + "," + i2 + "," + i3 + "," + i4 + "," + i5);
            if (i1 == 2) {
                stars = 1;
            }
            if (i2 == 2) {
                stars = 2;
            }
            if (i3 == 2) {
                stars = 3;
            }
            if (i4 == 2) {
                stars = 4;
            }
            if (i5 == 2) {
                stars = 5;
            }

//            if (i1 == 4) {
//                allProd = allProdVar1;
//            } else if (i2 == 4) {
//                allProd = allProdVar2;
//            } else if (i3 == 4) {
//                allProd = allProdVar3;
//            } else allProd = null;
//        }


            return stars;
        } else return 0;
    }

    public boolean catRatingEmpty(WebElement el) throws Exception {
        try {
            el.findElement(By.xpath("//div[@class='rating']"));
//               el.findElement(By.xpath("//div/div[2]/div[1]/div[@class='rating']"));
//                    "div[class='caption']>div[class='rating']"));
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    public WebElement getProdLink(WebElement el) {
        WebElement link = el.findElement(By.cssSelector("div[class='caption']>h4>a"));
        return link;
    }

    public void addProdToCart(WebElement el) {
        WebElement addToCartIcon = el.findElement(By.cssSelector("div[class='button-group']>button:nth-of-type(1)"));
        addToCartIcon.click();
    }

    public void addProdToWishlist(WebElement el) {
        WebElement addToWlIcon = el.findElement(By.cssSelector("button[ data-original-title='Add to Wish List']"));
        addToWlIcon.click();
    }

    public void addProdToCompare(WebElement el) {
        WebElement addToCompareIcon = el.findElement(By.cssSelector("button[ data-original-title='Compare this Product']"));
        addToCompareIcon.click();
    }


}

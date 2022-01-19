package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GenericHeaderPage {
    // top menu
    @FindBy(how = How.CSS, using = "ul[class='list-inline']>li:nth-of-type(2)")
    public WebElement genTopAccountDropDown;

    @FindBy(how = How.CSS, using = "ul[class='list-inline']>li:nth-of-type(3)")
    public WebElement genTopWishlist;

    @FindBy(how = How.CSS, using = "ul[class='list-inline']>li:nth-of-type(4)")
    public WebElement genTopCart;

    //My Account dropdown
    @FindBy(how = How.CSS, using = "ul[class = 'dropdown-menu dropdown-menu-right']>li:nth-of-type(1)")
    public WebElement genTopMyAccount;

    @FindBy(how = How.CSS, using = "ul[class ='dropdown-menu dropdown-menu-right']>li:nth-of-type(2)")
    public WebElement genTopLogin;

    @FindBy(how = How.CSS, using = "ul[class ='dropdown-menu dropdown-menu-right']>li:nth-of-type(5)")
    public WebElement genTopLogout;

    //Cart button
    @FindBy(how = How.CSS, using = "button[class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    public WebElement genCartButton;

    //categories
    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(1)")
    public WebElement genMenuDesktops;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(1)>div>div>ul>li:nth-of-type(1)")
    public WebElement genMenuDesktopsPC;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(1)>div>div>ul>li:nth-of-type(2)")
    public WebElement genMenuDesktopsMac;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(1)>div>a")
    public WebElement genMenuDesktopsShowAll;


    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(2)")
    public WebElement genMenuLaptops;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(2)>div>div>ul>li:nth-of-type(1)")
    public WebElement genMenuLaptopsMacs;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(2)>div>div>ul>li:nth-of-type(2)")
    public WebElement genMenuLaptopsWindows;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(2)>div>a")
    public WebElement genMenuLaptopsShowAll;


    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(3)")
    public WebElement genMenuComponents;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(3)>div>div>ul>li:nth-of-type(1)")
    public WebElement genMenuComponentsMice;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(3)>div>div>ul>li:nth-of-type(2)")
    public WebElement genMenuComponentsMonitors;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(3)>div>div>ul>li:nth-of-type(3)")
    public WebElement genMenuComponentsPrinters;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(3)>div>div>ul>li:nth-of-type(4)")
    public WebElement genMenuComponentsScanners;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(3)>div>div>ul>li:nth-of-type(5)")
    public WebElement genMenuComponentsWebCams;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(3)>div>a")
    public WebElement genMenuComponentsShowAll;


    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(4)")
    public WebElement genMenuTablets;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(5)")
    public WebElement genMenuSoftware;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(6)")
    public WebElement genMenuPhones;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(7)")
    public WebElement genMenuCameras;

    @FindBy(how = How.CSS, using = "ul[class='nav navbar-nav']>li:nth-of-type(8)")
    public WebElement genMenuMp3Players;


//  METHODS - TOP MENU


    public void genClickMyAccount() {
        genTopAccountDropDown.click();
    }

    public void genClickLogin() {
        genTopLogin.click();
    }

    public void genClickTopWishlist() {
        genTopWishlist.click();
    }

    public void genClickTopCart() {
        genTopCart.click();
    }

    // METHODS - CATEGORIES MENU TOP

    public void genClickMenuDesktop() {
        genMenuDesktops.click();
    }

    public void genClickMenuDesktopPC() {
        genMenuDesktopsPC.click();
    }

    public void genClickMenuDesktopMac() {
        genMenuDesktopsMac.click();
    }

    public void genClickMenuLaptops() {
        genMenuLaptops.click();
    }

    public void genClickMenuLaptopsMacs() {
        genMenuLaptopsMacs.click();
    }

    public void genClickMenuLaptopsWindows() {
        genMenuLaptopsWindows.click();
    }

    public void genClickMenuComponents() {
        genMenuComponents.click();
    }

    public void genClickMenuComponentsMice() {
        genMenuComponentsMice.click();
    }

    public void genClickMenuComponentsMonitors() {
        genMenuComponentsMonitors.click();
    }

    public void genClickMenuComponentsPrinters() {
        genMenuComponentsPrinters.click();
    }

    public void genClickMenuComponentsScanners() {
        genMenuComponentsScanners.click();
    }

    public void genClickMenuComponentsWebCams() {
        genMenuComponentsWebCams.click();
    }

    public void genClickMenuTablets() {
        genMenuTablets.click();
    }

    public void genClickMenuSoftware() {
        genMenuSoftware.click();
    }

    public void genClickMenuPhones() {
        genMenuPhones.click();
    }

    public void genClickMenuCameras() {
        genMenuCameras.click();
    }

    public void genClickMenuMp3Players() {
        genMenuMp3Players.click();
    }

    public int genWishListCount() {
        String string = genTopWishlist.getText();
        String newStr = string.substring(11, string.length() - 1);
        int count = Integer.valueOf(newStr);
        return count;
    }

    public int genCompMonitorsCount() {
        String string = genMenuComponentsMonitors.getText();
        String newStr = string.substring(10, string.length() - 1);
        int count = Integer.valueOf(newStr);
        return count;
    }


}
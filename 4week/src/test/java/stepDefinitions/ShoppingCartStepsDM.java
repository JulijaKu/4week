package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.CategoriesPage;
import pages_sample.GenericHeaderPage;
import pages_sample.LoginPage;
import pages_sample.ShoppingCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ShoppingCartStepsDM {
    private WebDriver driver;
    static ShoppingCartStepsDM shoppingCartStepsDM;
    static GenericHeaderPage genericHeaderPage;
    static ShoppingCartPage shoppingCartPage;
    static LoginPage loginPage;
    static CategoriesPage categoriesPage;

    public ShoppingCartStepsDM() {
        this.driver = Hooks.driver;
        shoppingCartPage = PageFactory.initElements(Hooks.driver, ShoppingCartPage.class);
        genericHeaderPage = PageFactory.initElements(Hooks.driver, GenericHeaderPage.class);
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        categoriesPage = PageFactory.initElements(Hooks.driver, CategoriesPage.class);
    }

    @When("^I navigate to Components and I click on Monitors$")
    public void iNavigateToComponentsAndIClickOnMonitors() {
        genericHeaderPage.genClickMenuComponents();
    }

    @Then("^I check amount of monitors$")
    public void iCheckAmountOfMonitors() {
        System.out.println(genericHeaderPage.genCompMonitorsCount());
        assertEquals(genericHeaderPage.genCompMonitorsCount(), 2);
    }

    @When("^I press Desktops$")
    public void iPressDesktops() {
        genericHeaderPage.genClickMenuDesktop();
    }

    @And("^Check if top menu is displayed$")
    public void checkIfTopMenuIsDisplayed() {
        assertTrue(shoppingCartPage.ifTopMenuIsShown());
    }

    @And("^I click Cameras$")
    public void iClickCameras() {
        genericHeaderPage.genClickMenuCameras();
    }


    @And("^I navigate to Components$")
    public void iNavigateToComponents() {
        genericHeaderPage.genClickMenuComponents();
    }

    @And("^I click on show all Components$")
    public void iClickOnShowAllComponents() {
        shoppingCartPage.genClickCompShowAll();
    }

    @And("^I click Monitors$")
    public void iClickMonitors() {
        genericHeaderPage.genClickMenuComponentsMonitors();
    }
}




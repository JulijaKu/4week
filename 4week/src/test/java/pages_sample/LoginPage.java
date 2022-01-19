package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class LoginPage {
    @FindBy(how = How.NAME, using = "email")
    private WebElement loginEmailInput;
    @FindBy(how = How.NAME, using = "password")
    private WebElement loginPassInput;
    @FindBy(how = How.CSS, using = "input[value = Login]")
    private WebElement loginBtn;
    @FindBy(how = How.CLASS_NAME, using = "alert")
    private WebElement loginErrorText;

    public String getPageUrl() {
        return "http://www.demoshop24.com/index.php?route=account/login";
    }


    public void loginEnterEmail(String email) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);
    }

    public void loginEnterPass(String password) {
        loginPassInput.clear();
        loginPassInput.sendKeys(password);
    }
    public void clickLogin() {
        loginBtn.click();
    }

    public void enterLoginPassAndClickLogin(String email, String password) {
        loginEnterEmail(email);
        loginEnterPass(password);
        loginBtn.click();
    }
    public void checkErrorMessage(String errorMessage) {
        assertEquals(loginErrorText.getText(), " Warning: No match for E-Mail Address and/or Password.");
        assertTrue(loginErrorText.isDisplayed());
    }
}

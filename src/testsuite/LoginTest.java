package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on the sign-in link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text 'Welcome Back!'
        String textToVerify = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Welcome Back!", "Welcome Back!", textToVerify);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Click on the sign-in link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("prime678@gmail.com");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@name='user[password]']")).sendKeys("Prime678");
        //Click on login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        //Verify the error message 'Invalid email or password.'
        String textToVerify = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Error message displayed", "Invalid email or password.", textToVerify);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

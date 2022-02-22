import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void zipCode1(){
        /*
        1. Открыть браузер
        2. Перейти по ссылке https://www.sharelane.com/cgi-bin/register.py
        3. Вводим 5 цифр, например 12345
        4. Нажать Continue
        5. Проверить, что кнопка Register видна
         */
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test
    public void zipCode2(){
        /*
        1. Открыть браузер
        2. Перейти по ссылке https://www.sharelane.com/cgi-bin/register.py
        3. Вводим 6 цифр, например 123456
        4. Нажать Continue
        5. Проверить, что появляется сообщение об ошибке (error_message)
         */
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        int size = driver.findElements(By.cssSelector("[class=error_message]")).size();
        assertNotEquals(size, 0, "Error message is not displayed");
    }
    @Test
    public void zipCode3(){
        /*
        1. Открыть браузер
        2. Перейти по ссылке https://www.sharelane.com/cgi-bin/register.py
        3. Вводим 4 цифры, например 1234
        4. Нажать Continue
        5. Проверить, что появляется сообщение об ошибке (error_message)
         */
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        int size = driver.findElements(By.cssSelector("[class=error_message]")).size();
        assertNotEquals(size, 0, "Error message is not displayed");
    }
    @Test
    public void userData(){
        /*
        1. Открыть браузер
        2. Перейти по ссылке https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12325
        3. В поле First Name вводим имя, например Aliaksei
        4. В поле Last Name вводим фамилию, например Fursa
        5. В поле Email вводим адрес электронной почты, например af89@gmail.com
        6. В поле Password вводим пароль, например pswrd1208
        7. В поле Confirm Password вводим пароль, например pswrd1208
        8. Нажать кнопку Register
        9. Проверить, что появляется сообщение Account is created!
         */
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12325");
        driver.findElement(By.name("first_name")).sendKeys("Aliaksei");
        driver.findElement(By.name("last_name")).sendKeys("Fursa");
        driver.findElement(By.name("email")).sendKeys("af89@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("pswrd1208");
        driver.findElement(By.name("password2")).sendKeys("pswrd1208");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        int size = driver.findElements(By.cssSelector("[class=confirmation_message]")).size();
        assertNotEquals(size, 0, "Confirmation message is not displayed");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

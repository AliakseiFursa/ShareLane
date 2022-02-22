import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpUserDataTest {

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
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12325");
        driver.findElement(By.name("first_name")).sendKeys("Aliaksei");
        driver.findElement(By.name("last_name")).sendKeys("Fursa");
        driver.findElement(By.name("email")).sendKeys("af89@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("pswrd1208");
        driver.findElement(By.name("password2")).sendKeys("pswrd1208");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        int size = driver.findElements(By.cssSelector("[class=confirmation_message]")).size();
        Assert.assertNotEquals(size, 0);
        driver.quit();
    }
}
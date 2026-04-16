import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class AddRemoveElementTest {
    /*
    Задание 1. Add/Remove Elements,
    добавить 2 элемента,
    удалить элемент,
    проверить количество элементов DELETE.
    Локаторы xpath:
    a. By.xpath("//button[text()='Add Element']")
    b. By.xpath("//button[text()='Delete']")
     */
    @Test
    public  void checkAddRemoveElement() {
        //создаём опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");

        // определяем браузер, с которым хотим работать
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // открывает страницу по указанному url
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // кликаем по кнопке "Add Element" х2
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        // проверяем, что две кнопки "Delete"
        int size = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(size, 2);

        // кликаем на кнопку "Delete"
        driver.findElement(By.xpath("//button[text()='Delete']")).click();

        // проверяем, что после удаления осталась одна кнопка "Delete"
        int size1 = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(size1, 1);

        // закрываем браузер
        driver.quit();
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.*;

public class FileUploadTest {
    /*
    File Upload
    - загрузить файл
    - проверить, что имя файла на странице совпадает с именем загруженного файла
     */
    @Test
    public void checkUploadFile() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //переходим на сайт, загружаем файл и нажимаем на кнопку upload
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/FileForTestFileUpload.txt");
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        //проверяем корректность наименования загруженного файла
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'File Uploaded!')]")));
        String fileName = driver.findElement(By.id("uploaded-files")).getText();
        assertEquals(fileName, "FileForTestFileUpload.txt");
        driver.quit();
    }
}
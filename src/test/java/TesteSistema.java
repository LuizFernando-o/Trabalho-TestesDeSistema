import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(Lifecycle.PER_CLASS)
public class TesteSistema {

    WebDriver webdriver;

    @BeforeAll
    public void setupAll(){
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver_win32/chromedriver.exe");
    }

    @BeforeEach
    public void setup(){
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver(){
        webdriver.close();
    }

    @Test
    public void openSongsterr(){
        webdriver.get("https://www.songsterr.com/");
        Assertions.assertEquals("https://www.songsterr.com/",
                webdriver.getCurrentUrl());
    }

    @Test
    public void chooseSong() throws InterruptedException { // 6- Nothing Else Matters - Metallica
        webdriver.get("https://www.songsterr.com/");
        WebElement botao = webdriver.findElement(
                By.xpath("/html/body/div/div/div/main/div/div/div[2]/a[6]"));
        botao.click();
        Thread.sleep(2000);
    }

    @Test
    public void playSong() throws InterruptedException { //executa o tutorial da musica
        webdriver.get("https://www.songsterr.com/a/wsa/metallica-nothing-else-matters-tab-s439171");
        WebElement botao = webdriver.findElement(
                By.xpath("/html/body/div/div/section/aside/div[2]/div[1]/button"));
        botao.click();
        Thread.sleep(5000);
    }

    @Test
    public void searchSong () throws InterruptedException {
        webdriver.get("https://www.songsterr.com/");
        WebElement search = webdriver.findElement(By.xpath("/html/body/div/div/div/main/div/div/div[1]/div[1]/div/input"));
        search.sendKeys("smells like teen spirit");
        Thread.sleep(5000); //input do site não tem submit, o resultado aparece na lista abaixo em tempo real
    }

    @Test
    public void changeInstrument() throws InterruptedException {
        webdriver.get("https://www.songsterr.com/a/wsa/metallica-nothing-else-matters-tab-s439171");
        WebElement botao = webdriver.findElement(By.id("control-mixer"));
        botao.click();
        Thread.sleep(3000);
        botao = webdriver.findElement(By.className("Cix268"));
        botao.click();
        Thread.sleep(5000);
    }

    @Test
    public void playGuitarThemPlayDrums() throws InterruptedException {
        webdriver.get("https://www.songsterr.com/a/wsa/dire-straits-sultans-of-swing-tab-s30084t2");
        WebElement botao = webdriver.findElement(
                By.xpath("/html/body/div/div/section/aside/div[2]/div[1]/button"));
        botao.click();
        Thread.sleep(5000);
        botao = webdriver.findElement(By.id("control-mixer"));
        botao.click();
        Thread.sleep(3000);
        botao = webdriver.findElement( By.xpath("/html/body/div/div/section/aside/div[2]/div[2]/div/div[1]/div[5]/a"));
        botao.click();
        Thread.sleep(5000);
    }
}

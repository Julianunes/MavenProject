/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import static java.lang.Thread.sleep;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author Microsoft
 */
public class JUnitTest {
    
    public JUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private WebDriver driver;
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Microsoft/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }
 
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void abrirPaginaInicial() {
        driver.get("https://yum-info.contradodigital.com/");
        driver.manage().window().setSize(new Dimension(1382, 744));
    
        assertEquals("https://yum-info.contradodigital.com/",
        driver.getCurrentUrl());
    }
  
    @Test
    public void redirecionarParaDonation() throws InterruptedException {
        driver.get("https://yum-info.contradodigital.com/");
        driver.manage().window().setSize(new Dimension(1382, 744));
        WebElement botaoDN = driver.findElement(By.name("submit"));
        botaoDN.click();
    
        sleep(4000);
    
        assertEquals("https://yum-info.contradodigital.com/",
        driver.getCurrentUrl());
    }
  
    @Test
    public void BuscarEmYum() throws InterruptedException { 
        driver.get("https://yum-info.contradodigital.com/");
        driver.manage().window().setSize(new Dimension(1382, 744));
        
        driver.findElement(By.id("YumSearch")).click();
        driver.findElement(By.id("YumSearch")).sendKeys("sftp");
        
        sleep(200);
        
        driver.findElement(By.id("YumSearch")).sendKeys(Keys.ENTER); 
        driver.findElement(By.linkText("filezilla")).click();
                
        sleep(200);
        
        assertEquals("https://yum-info.contradodigital.com/view-package/epel/filezilla/",
                driver.getCurrentUrl());
    }
}

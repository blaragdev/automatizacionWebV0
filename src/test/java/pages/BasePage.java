package pages;

// Importaciones necesarias
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();

        //Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    //le pasamos un xpath y crea un webelement hasta que este presente los segundos seteados en el wait
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    //metodo para cerrar la instancia(browser)
    public static void closeBrowser(){
        driver.quit();
    }

    //Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void writeElement(String locator, String text) {
        Find(locator).clear();
        Find(locator).sendKeys(text);
    }

    public void selectFromDropDownByValue(String locator, String value){
        Select dropDown = new Select(Find(locator));

        dropDown.selectByValue(value);
    }

    public void selectFromDropDownByIndex(String locator, Integer index){
        Select dropDown = new Select(Find(locator));

        dropDown.selectByIndex(index);
    }

    public int dropDownSize(String locator) {
        Select dropDown = new Select(Find(locator));
        List<WebElement> dropDownOptions = dropDown.getOptions();

        return dropDownOptions.size();
    }

    //devuelve todos los valores que hay en un dropDown
    public List<String> getDropDownAllValues(String locator) {
        Select dropDown = new Select(Find(locator));

        List<WebElement> dropDownOptions = dropDown.getOptions();
        List<String> values = new ArrayList<>();

        for (WebElement option: dropDownOptions) {
            values.add(option.getText());
        }

        return values;
    }

    public Boolean esperoElemento(String locator) {
        return Find(locator).isDisplayed();
    }
}
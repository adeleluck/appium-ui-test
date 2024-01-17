import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ShoppingBasketTest extends BaseConfig {

    @Test
    public void TestAddToBasket() throws InterruptedException
    {
        org.openqa.selenium.WebElement element;

        // ждём 10 секунд (параметр задан в миллисекундах)
        Thread.sleep(10000);

        // тут подтверждаем желание получать уведомления от программы
        final String idAllowNotificationsButton = "com.android.permissioncontroller:id/permission_allow_button";
        element = driver.findElement(By.id(idAllowNotificationsButton));
        element.click();

        final String xpathFirstListElement = "//android.widget.TextView[@text=\"Россия\"]";
        element = driver.findElement(new By.ByXPath(xpathFirstListElement));
        element.click();

        // ждём 10 секунд (параметр задан в миллисекундах)
        Thread.sleep(10000);

        // пропускаем страницу с информацией о Wildberries
        final String xpathSkipPageElement = "//android.widget.TextView[@text=\"Пропустить ›\"]";
        element = driver.findElement(new By.ByXPath(xpathSkipPageElement));
        element.click();

        // Встаём в строку поиска
        final String xPathToInitialSearchField = "//android.widget.TextView[@text=\"Найти на Wildberries\"]";
        element = driver.findElement(new By.ByXPath(xPathToInitialSearchField));
        element.click();

        // ждём 3 секунды (параметр задан в миллисекундах)
        Thread.sleep(3000);

        final String xPathToSearchField = "//android.widget.EditText";
        element = driver.findElement(new By.ByXPath(xPathToSearchField));
        element.click();

        // набираем в строке поиска слово apple и нажимаем Enter
        element.sendKeys("apple");

        // ждём 2 секунды (параметр задан в миллисекундах)
        Thread.sleep(2000);

        // выбираем "apple watch" в результатах поиска
        final String xPathToAppleWatchItem = "//android.widget.TextView[@text=\"apple watch\"]";
        element = driver.findElement(new By.ByXPath(xPathToAppleWatchItem));
        element.click();

        // ждём 7 секунд (параметр задан в миллисекундах)
        Thread.sleep(7000);

        final String xPathToAddToBasketButtonForTheFirstItem = "(//android.widget.Button[@content-desc=\"Добавить в корзину\"])[1]";
        element = driver.findElement(new By.ByXPath(xPathToAddToBasketButtonForTheFirstItem));

        // нажимаем на кнопку добавить 3 раза, чтобы добавились 3 единицы товара
        element.click();
        element.click();
        element.click();

        final String idForProductCountTextElement = "com.wildberries.ru:id/textProductCount";
        element = driver.findElement(By.id(idForProductCountTextElement));

        Assert.assertNotNull(element);
        Assert.assertEquals("3", element.getText());
    }

}

package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Common extends Base {

    public WebElement findelementbyxpath(String xpath) {

        return driver.findElement(By.xpath(xpath));
    }

    public void searchbyLocation(String location) {
        findelementbyxpath("//input[@type='text']").sendKeys(location);
        findelementbyxpath("//button[2]").click();
    }

    public void searchForProducts(String ProductName) {
        findelementbyxpath("//*[text()='Search']").click();
        findelementbyxpath("//input[@type='text']").sendKeys(ProductName);
        findelementbyxpath("//button[@data-testid='autosuggest-item']").click();
    }

    public void addProductToCart() {
        findelementbyxpath("//*[text()='ADD']").click();
        try {
            Thread.sleep(2000);
            WebElement modelDialogue = findelementbyxpath("//*[@id='modal-placeholder']");
            modelDialogue.findElement(By.xpath("//span[text()='Add Item']")).click();
            Thread.sleep(2000);
            //findelementbyxpath("//div[@class='_26cJ9']//child::div//child::i//following-sibling::div//child::div//following-sibling::button").click();
        } catch (Exception e) {
            logger.info("No PopUp Found");
        }

        WebElement cartvalue = findelementbyxpath("//span[text()='Cart']//preceding-sibling::span//span");
        verifytext(cartvalue, "1");
        WebElement cart = findelementbyxpath("//span[text()='Cart']");
        movetoElement(cart);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        WebElement subtotalElement = findelementbyxpath("//div[text()='Sub total']//following-sibling::div//span");
        String subTotal = subtotalElement.getText();
        logger.info(subTotal);
        double actualSubTotal = Double.parseDouble(subTotal);
        findelementbyxpath("//div[text()='Checkout']").click();
        double expectedTotal = Double.parseDouble(findelementbyxpath("//div[text()='TO PAY']//following-sibling::div").getText());
        if (expectedTotal > actualSubTotal) {
            logger.info("Verified the Sub Total with To Pay");
        } else {
            logger.error("subTotal Amount Do not Match");
            Assert.assertTrue(false);
        }
    }

    public void verifytext(WebElement element, String Text) {
        String actual = element.getText();
        String expected = Text;
        Assert.assertEquals(actual, expected);

    }

    public void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        logger.info("Validated the Title -" + actualTitle);

    }

    public void movetoElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}

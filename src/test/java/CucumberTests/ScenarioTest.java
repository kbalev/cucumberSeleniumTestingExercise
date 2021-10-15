package CucumberTests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScenarioTest {

    WebDriver driver;

    @Given("I add four different products to my wishlist")
    public void i_add_four_different_products_to_my_wishlist() {
        System.setProperty("webdriver.gecko.driver","D:\\CodeStuffs\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://testscriptdemo.com/?post_type=product");
        driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/article/ul/li[4]/div/div[2]/div/div/a/span")).click();
        driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/article/ul/li[7]/div/div[2]/div/div/a/span")).click();
        driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/article/ul/li[10]/div/div[2]/div/div/a/span")).click();
        driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/article/ul/li[9]/div/div[2]/div/div/a/span")).click();
    }
    @When("I view my Wishlist table")
    public void i_view_my_wishlist_table() {
        driver.get("https://testscriptdemo.com/?page_id=233&wishlist-action");

    }
    @Then("I find a total of {string} selected items in my Wishlist")
    public void i_find_a_total_of_selected_items_in_my_wishlist(String string) {
        List<WebElement> wishlistItems = driver.findElements(By.className("product-name"));
        assertEquals(5, wishlistItems.size());
        //5 because the column name box shares the class-name tag
    }
    @When("I search for lowest price product in the Wishlist")
    public void i_search_for_lowest_price_product_in_the_wishlist() {
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/form/table/tbody/tr[4]/td[4]/ins/span/bdi"));

    }
    @When("I am able to add the lowest price item to my cart from the Wishlist")
    public void i_am_able_to_add_the_lowest_price_item_to_my_cart_from_the_wishlist() {
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/form/table/tbody/tr[4]/td[6]/a")).click();

    }
    @Then("I am able to verify the item in my cart")
    public void i_am_able_to_verify_the_item_in_my_cart() {
        driver.get("https://testscriptdemo.com/?page_id=299");
        boolean exists;
        if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/div/form/table/tbody/tr[1]/td[3]/a")) != null){
            exists=true;
        } else { exists = false;}
        assertTrue("Item does not exist", exists);
    }


}

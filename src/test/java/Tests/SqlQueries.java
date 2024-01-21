package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SqlQueries{
    WebDriver driver;
    WebDriverWait wait;

    private static final int TIMEOUT = 10;
    public SqlQueries(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);

    }
    public String getFirstName() {
        return "SELECT first_name FROM actor ORDER BY RANDOM() FETCH FIRST ROWS ONLY;";
    }
    public String getLastName(){
        return "SELECT last_name FROM actor ORDER BY RANDOM() FETCH FIRST ROWS ONLY;";
    }
}


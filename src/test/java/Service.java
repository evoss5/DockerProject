import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class Service {

    WebDriver driver;
    Service service;
    WebDriverWait webDriverWait;
    Random random = new Random();

    public Service(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDriver() {
        return "C:/driver/chromedriver.exe";
    }

    public String getURL() {
        return "http://localhost:3000/";
    }

    public String getURL2() {
        return "http://localhost:3000/";
    }

    public String chromeDriverURL() {
        return "webdriver.chrome.driver";
    }

    @BeforeMethod
    public void beforeTest() {

        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.getDriver(), service.chromeDriverURL());
        driver.get(service.getURL());
        driver.manage().window().maximize();


    }

    public int randomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public int randomNumber() {
        return random.nextInt(9999 - 1000 + 1) + 1000;
    }

    public ArrayList<String> namesList() {
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("Pavel");
        nameList.add("Yanping");
        nameList.add("Anita");
        nameList.add("Thomas");
        nameList.add("Jianming");
        nameList.add("Carlos");
        nameList.add("YuPham");
        nameList.add("Alex");
        nameList.add("Anne");
        nameList.add("Moses");
        nameList.add("XiangTang");
        return nameList;
    }

    public ArrayList<String> surnamesList() {
        ArrayList<String> surnameList = new ArrayList<>();
        surnameList.add("Vasquez");
        surnameList.add("Akhtar");
        surnameList.add("Jiao");
        surnameList.add("Yao");
        surnameList.add("He");
        surnameList.add("Hussein");
        surnameList.add("Suzuki");
        surnameList.add("Campos");
        surnameList.add("Akter");
        surnameList.add("GulMartin");
        surnameList.add("RachelCabrera");
        surnameList.add("FrancisYılmaz");
        surnameList.add("AdrianaBah");
        surnameList.add("AmalMiranda");
        return surnameList;
    }

    public ArrayList<String> eMailsDomenList() {
        ArrayList<String> eMailDomensList = new ArrayList<>();
        eMailDomensList.add("@gmail.com");
        eMailDomensList.add("@interia.com");
        eMailDomensList.add("@interia.eu");
        eMailDomensList.add("@interia.pl");
        eMailDomensList.add("@wp.pl");
        eMailDomensList.add("@vp.pl");
        eMailDomensList.add("@wp.eu");
        eMailDomensList.add("@me.com");
        eMailDomensList.add("@onet.pl");
        eMailDomensList.add("@onet.eu");
        eMailDomensList.add("@tlen.pl");
        return eMailDomensList;


    }

    public ArrayList<String> randomPasswordList() {
        ArrayList<String> randomPasswordsList = new ArrayList<>();
        randomPasswordsList.add("WslfbZS");
        randomPasswordsList.add("kTOx3k5eu");
        randomPasswordsList.add("qEBuX7cB");
        randomPasswordsList.add("z6nmbgJdyY");
        randomPasswordsList.add("kO6tiAoNBu");
        randomPasswordsList.add("tPTdczc");
        randomPasswordsList.add("tshhiRPvnow");
        randomPasswordsList.add("U35EbLxpbuG");
        randomPasswordsList.add("lH8LKv5");
        randomPasswordsList.add("kj6os3Prk");
        randomPasswordsList.add("1byW9mFq1PT");
        return  randomPasswordsList;
    }


    public String getRandomValue(ArrayList<String> list) {
        int randomIndex = random.nextInt(list.size());
        String randomValue = list.get(randomIndex);
        return randomValue;
    }


    public String createEmailAddress(String name, String sureName, int number, String mailDomen) {
        String email = name + sureName + number + mailDomen;
        return email;


    }

    public String createEmailAdress(String name, String sureName) {
        String email = name + sureName;
        return email;
    }

    public String createRandomPassword(String password, int number) {
        String pass = password + number;
        return pass;
    }
}




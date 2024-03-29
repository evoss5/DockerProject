package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Service {

    protected WebDriver driver;
    protected Service service;
    protected WebDriverWait webDriverWait;
    protected Random random = new Random();
    protected Faker faker = new Faker();

    public Service(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String getDriver() {
        return "C:/driver/chromedriver.exe";
    }

    public final String getURL() {
        return "http://localhost:3000/";
    }

    public final String chromeDriverURL() {
        return "webdriver.chrome.driver";
    }

    public final String dockerPath() {
        return "C:/PROGRA~1/Docker/Docker/DockerApp.exe/";
    }

    public final String containerName() {
        return "stupefied_knuth";
    }


    public String getCredentialValue(String credentialName) {
        String credentialValue = null;
        try (FileReader reader = new FileReader("credentials")) {
            Properties properties = new Properties();
            properties.load(reader);
            credentialValue = properties.getProperty(credentialName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return credentialValue;
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

    public ArrayList<String> countriesList() {
        ArrayList<String> countryList = new ArrayList<>();
        countryList.add("Poland");
        countryList.add("Germany");
        countryList.add("Greece");
        countryList.add("Spain");
        return countryList;
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
        return randomPasswordsList;
    }

    public ArrayList<String> randomzipCodes() {
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("00-001");
        zipCode.add("00-064");
        zipCode.add("00-124");
        zipCode.add("00-191");
        zipCode.add("00-227");
        zipCode.add("00-664");
        zipCode.add("52-231");
        return zipCode;
    }

    public ArrayList<String> randomCities() {
        ArrayList<String> randomCity = new ArrayList<>();
        randomCity.add("Poznan");
        randomCity.add("Warsaw");
        randomCity.add("Glogow");
        randomCity.add("Madrid");
        randomCity.add("Barcelona");
        randomCity.add("Glasgow");
        return randomCity;
    }

    public String getRandomValue(ArrayList<String> list) {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public String createEmailAddress(String name, String sureName, int number, String mailDomen) {
        return name + sureName + number + mailDomen;
    }

    public String createEmailAddress(String name, String sureName, int number) {
        return name + sureName + number;
    }

    public String createEmailAdress(String name, String sureName) {
        return name + sureName;
    }

    public String createRandomPassword(String password, int number) {
        String pass = password + number;
        return pass;
    }

    private static String getRandomLineFromFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        return lines.get(random.nextInt(lines.size()));
    }

    public String randomValueFromDomain() {
        getRandomLineFromFile("domainList.txt");
        return getRandomLineFromFile("domainList.txt");
    }

    public String cellPhoneNumber() {
        String contactNumber = String.valueOf(randomNumber(508, 895)) + String.valueOf(randomNumber(100, 999)) + String.valueOf(randomNumber(100, 999));
        System.out.println("Contact number " + contactNumber);
        return contactNumber;
    }

    public String cardNumber() {
        String cardNumber = String.valueOf(randomNumber(1000, 9999)) + String.valueOf(randomNumber(1000, 9999)) + String.valueOf(randomNumber(1000, 9999)) + String.valueOf(randomNumber(1000, 9999));
        return cardNumber;
    }

    public String cardNumber2() {
        String cardNumber = String.valueOf(randomNumber(1000, 9999)) + String.valueOf(randomNumber(1000, 9999)) + String.valueOf(randomNumber(1000, 9999));
        return cardNumber;
    }

    public String dockerProjectDatabase(String sqlQuery) {
        String url = getCredentialValue("sqlURL");
        String username = getCredentialValue("sqlLogin");
        String password = getCredentialValue("sqlPassword");
        String queryResult = null;

        try {
            Connection dbConnection = DriverManager.getConnection(url, username, password);
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            System.out.println("Executing query: " + sqlQuery);
            while (rs.next()) {
                queryResult = rs.getString(1);
                System.out.println("Result: " + queryResult);
            }
            rs.close();
            st.close();
            dbConnection.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return queryResult;
    }
}





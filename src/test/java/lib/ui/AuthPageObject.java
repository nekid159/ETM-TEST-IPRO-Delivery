package lib.ui;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lib.BaseSeleniumPage;
import lib.ui.MainPageObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthPageObject extends BaseSeleniumPage {
    //private static final
    String LOGIN_MARKET="9160058830";
    String PASSWORD_MARKET="Dd17549bb";
    String LOGIN_IPRO="60004392tes";
    String PASSWORD_IPRO="alyd8965";
    MainPageObject MainPageObject = new MainPageObject();
    String SITE_URL = "https://itest.etm.ru:3004/";



    public void marketAuthorization() throws InterruptedException
    {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//button[@data-testid='okay-button']","not found and click element of cookies",5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='understand-button']","not found and click element of cookies",5);
        driver.findElement(By.xpath("//button[@data-testid='authorization-button']")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(LOGIN_MARKET);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PASSWORD_MARKET);
        driver.findElement(By.xpath("//button[@data-testid='go-to-system']")).click();
    }
    public void iPROAuthorization() throws InterruptedException
    {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//button[@data-testid='okay-button']","not found and click element of cookies",5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='understand-button']","not found and click element of cookies",5);
        driver.findElement(By.xpath("//button[@data-testid='authorization-button']")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(LOGIN_IPRO);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PASSWORD_IPRO);
        driver.findElement(By.xpath("//button[@data-testid='go-to-system']")).click();
    }
    public void cookiesAndCity() throws InterruptedException
    {
        Thread.sleep(500);
        MainPageObject.waitForElementAndClick("//button[@data-testid='okay-button']","not found and click element of cookies",5);
        MainPageObject.waitForElementAndClick("//button[@data-testid='understand-button']","not found and click element of cookies",5);
    }
    public void AddCoockie(String sessionId) {
        driver.navigate().to(SITE_URL);
        Cookie cookie = new Cookie("session-id", sessionId);
        System.out.println(sessionId);
        driver.manage().addCookie(cookie);
        Cookie driverCookie = driver.manage().getCookieNamed("session-id");

        assertThat(driverCookie.getValue(), equalTo(sessionId));
    }
    public static String getCurrentSession() {
        String sessionId = null;
        try {
            String postUrl = "https://idev.etm.ru/api/ipro/user/login";
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(postUrl);

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("log", "51951tes"));
            params.add(new BasicNameValuePair("pwd", "gvuq3266"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuilder responseText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseText.append(line);
            }

            JsonParser parser = new JsonParser();
            JsonObject jsonResponse = parser.parse(responseText.toString()).getAsJsonObject();

            sessionId = jsonResponse.getAsJsonObject("data").get("session").getAsString();
            System.out.println(sessionId);
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sessionId;
    }
}
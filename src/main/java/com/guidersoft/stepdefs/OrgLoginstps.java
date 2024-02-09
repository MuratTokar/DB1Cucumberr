package com.guidersoft.stepdefs;

import com.guidersoft.webdriver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrgLoginstps {
    WebDriver driver;
    WebDriverWait wait;
    public OrgLoginstps(){
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    By lusername=By.xpath("//input[@name='username']");
    By lpassword=By.xpath("//input[@name='password']");

    By llogin=By.xpath("//button[@type='submit']");

    By invalid=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    By valid=By.xpath("//h6[text()='Dashboard']");


    @Given("user navigate to {string}")
    public void userNavigateTo(String url) {
        driver.get(url);

    }

    @When("user try to login with the exel file {string}")
    public void userTryToLoginWithTheExelFile(String file) throws IOException {
        List<List<String>> newdata=data(file);
        for (List<String> row : newdata) {
            String username=row.get(0);
            String password=row.get(1);
            String loginStatus=row.get(2);
            sendKeys(lusername,username);
            sendKeys(lpassword,password);
            click(llogin);
            if (loginStatus.equals("False")){
                shouldBeVisible(invalid);
            }else shouldBeVisible(valid);
            }

        }






    public List<List<String>>  data(String file) throws IOException {

        List<List<String>> datas=new ArrayList<>();

        FileInputStream stream=new FileInputStream(file);

        Workbook work= WorkbookFactory.create(stream);

        Sheet sheet=work.getSheetAt(0);

        int rownum=sheet.getPhysicalNumberOfRows();

        for (int i = 1; i <rownum ; i++) {

            List<String> rowlist=new ArrayList<>();

            Row row=sheet.getRow(i);

            int cellnumn=row.getPhysicalNumberOfCells();

            for (int j = 1; j < cellnumn; j++) {

                rowlist.add(row.getCell(j).toString());

                
            }
            datas.add(rowlist);

            
        }
        return datas;

    }
    public void click(By locator){
       wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }
    public void sendKeys(By locator,String text){
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void shouldBeVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}

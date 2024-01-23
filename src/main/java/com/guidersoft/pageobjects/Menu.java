package com.guidersoft.pageobjects;

import org.openqa.selenium.By;

public enum Menu { // enum public static ve finaldir
    HOME(By.xpath ("//ul[@class='nav navbar-nav']//a[contains(.,'Home')]")),
    LOGIN(By.xpath("//ul[@class='nav navbar-nav']//a[contains(.,'Signup / Login')]")),
    SIGNUP(By.xpath("//ul[@class='nav navbar-nav']//a[contains(.,'Signup / Login')]")),
    CART(By.xpath("//ul[@class='nav navbar-nav']//a[contains(.,'Cart')]")),
    PRODUCTS(By.xpath("//ul[@class='nav navbar-nav']//a[contains(.,'Products')]")),
    CONTACTUS(By.xpath("//ul[@class='nav navbar-nav']//a[contains(.,'Contact us')]"));



    private By locator;
    Menu(By locator) {
        this.locator = locator;

    }
}

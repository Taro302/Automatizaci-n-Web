package com.nttdata.steps;

import com.nttdata.page.LoginPage1;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginSteps1 {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginSteps1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumenta el tiempo de espera
    }

    public void openLoginPage() {
        driver.get("https://qalab.bensg.com/store/");
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LoginPage1.SearchPageLogin));
        loginButton.click();
    }

    public void typeUser(String user) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage1.User));
        userField.clear();
        userField.sendKeys(user);
    }
    public void typePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage1.Password));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void submitLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LoginPage1.BtnLogin));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
        loginButton.click();
    }

    public void navigateToCategory(String category) {
        List<WebElement> categories = driver.findElements(LoginPage1.Category);

        boolean categoryFound = false;
        for (WebElement categoryElement : categories) {
            if (categoryElement.getText().equalsIgnoreCase(category)) {
                categoryElement.click();
                categoryFound = true;
                break;
            }
        }

        if (!categoryFound) {
            throw new NoSuchElementException("No se encontró la categoría: " + category);
        }
    }

    public void navigateToSubCategory(String subCategory) {
        WebElement subCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(LoginPage1.man));
        subCategoryElement.click();
    }

    public void addProductToCart(int quantity) {

        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(LoginPage1.Product1));
        product.click();

        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage1.Quantity));
        quantityField.sendKeys(Keys.CONTROL + "a");
        quantityField.sendKeys(Keys.BACK_SPACE);

        quantityField.sendKeys(String.valueOf(quantity));

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(LoginPage1.BtnCar));
        addToCartButton.click();
    }

    public void finalizePurchase() {

        WebElement finalizeButton = wait.until(ExpectedConditions.elementToBeClickable(LoginPage1.FinalityShop));
        finalizeButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validarTitulodelCarito() {

        WebElement titleElement = driver.findElement(LoginPage1.TitleCarShop);
        String actualTitle = titleElement.getText();

        String expectedTitle = "CARRITO";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("carrito validado correctamente");
    }

    public void calcularProducto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        double multiplicando = getValueFromElement(LoginPage1.Multiplicando, wait);
        double multiplicador = getValueFromElement(LoginPage1.Multiplicador, wait);
        double calculatedResult = multiplicando * multiplicador;
        double result = getValueFromElement(LoginPage1.Result, wait);

        Assert.assertEquals(calculatedResult, result, 0.01);
        System.out.println("El resultado de la multiplicación es: " + calculatedResult + " y el resultado de la pantalla es: " + result);
    }

    private double getValueFromElement(By elementLocator, WebDriverWait wait) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            String text = element.getText().replace("$", "").replace("S/", "").trim();
            return Double.parseDouble(text);
        } catch (Exception e) {
            System.err.println("Error al obtener o convertir el valor del elemento: " + elementLocator + " | Excepción: " + e.getMessage());
            return 0.0;
        }
    }


    public void validarProductoCarrito() {

    }



}

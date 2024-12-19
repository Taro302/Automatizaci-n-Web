package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps1;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class StepDefinition {
    private WebDriver driver;
    private LoginSteps1 loginSteps;


    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        loginSteps = new LoginSteps1(driver);
        loginSteps.openLoginPage();
        screenShot();
    }

    @And("ingreso a iniciar sesion")
    public void ingresoAIniciarSesion() {
        loginSteps.clickLoginButton();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.submitLogin();
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria Men")
    public void navegoALaCategoriaClothesYSubcategoriaMen(String category) {
        loginSteps.navigateToCategory(category);  // Llamada solo al método de categoría
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int quantity) {
        loginSteps.addProductToCart(quantity);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        // Implementa la validación del popup aquí
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        loginSteps.calcularProducto();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        loginSteps.finalizePurchase();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        loginSteps.validarTitulodelCarito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        loginSteps.validarProductoCarrito();
        screenShot();
    }

    @Then("espero que no llegue a la página principal y falle el inicio de sesión")
    public void esperoQueNoLlegueALaPaginaPrincipalYFalleElInicioDeSesion() {
        System.out.println("error en ingresar a cuenta o contraseña incorrecta.");
        screenShot();

    }

    @When("navego a la categoría {string}")
    public void navegoALaCategoria(String category) {

        loginSteps.navigateToCategory(category);
        screenShot();
    }

    @Then("espero que la automatización falle, ya que la categoría no existe")
    public void esperoQueLaAutomatizacionFalleYaQueLaCategoriaNoExiste() {

        System.out.println("la categoria no existe");
    }
}

package steps;

import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.*;
import pages.WidgetsPage;
import pages.LoginPage;

public class Steps {
    //con softAssert se puede validar un assertion pero sin detener la ejecucion del escenario su falla.
    //ideal para verificar muchas cosas pequeñas a la vez y no tener que definir un escenario por cada una
    SoftAssert softAssert = new SoftAssert();

    LoginPage loginPage = new LoginPage();
    WidgetsPage widgetsPage = new WidgetsPage();


    @Given("navego a dev.padok.cl")
    public void navegoAUrl() {
        loginPage.navegoADevPadokCl();
    }

//    @When("voy a la seccion {word} usando la barra de navegacion")
//    public void usaBarraNavegacion(String seccion) {
//        loginPage.clickEnSeccionDeBarraNavegacion(seccion);
//    }

    @When("hago click en el elemento Select Menu")
    public void clickEnElementoSelectMenu() {
        widgetsPage.clickSelectMenuLink();
    }

    @When("hago click en menu lateral superior")
    public void hagoClickEnMenuLateralSuperior() {
        loginPage.clickMenuLateralSuperior();
    }

    @When("hago click en Sign in with Email")
    public void hagoClickEnSignInWithEmail() {
        loginPage.clickEnSignInWithEmail();
    }

    @When("escribo usuario y clave")
    public void escriboUsuarioYClave() {
        loginPage.escriboUsuarioYClave();
    }

    @When("hago click en boton iniciar sesion")
    public void hagoClickEnBotonIniciarSesion() {
        loginPage.clickEnBotonIniciarSesion();
    }



//    @Then("valido las opciones del dropdown Old Style")
//    public void validaValoresDropDownOldStyle() {
//        List<String> lista = widgetsPage.getColorsDropdownValues();
//        List<String> listaEsperada = Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet", "Indigo", "Magenta", "Aqua");
//
//        Assert.assertEquals(listaEsperada, lista);
//    }

    @Then("verifico que exista mensaje de Dashboard")
    public void verificoQueExistaMensajeDeDashboard() {
        softAssert.assertTrue(loginPage.mensajeDashboardSeaVisible());
        softAssert.assertAll();
    }

    @Then("verifico que exista texto Monto a liquidar")
    public void verificoQueExistaTextoMontoALiquidar() {
        softAssert.assertTrue(loginPage.montoLiquidarSeaVisible());
        softAssert.assertAll();
    }

    @Then("verifico que exista texto Total recaudado")
    public void verificoQueExistaTextoTotalRecaudado() {
        softAssert.assertTrue(loginPage.totalRecaudadoSeaVisible());
        softAssert.assertAll();
    }

    @Then("verifico que exista texto Monto a Descuentos")
    public void verificoQueExistaTextoMontoADescuentos() {
        softAssert.assertTrue(loginPage.montoDescuentosSeaVisible());
        softAssert.assertAll();
    }

}
package com.co.certificacion.pruebas.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.VuelosStep;

public class StepDefinitionsVuelos {


    @Steps
    VuelosStep vuelosStep;
    private String precioTalla;

    @Given("^que ingreso a la pagina Avianca$")
    public void queIngresoALaPaginaAvianca() {
vuelosStep.abrirAvianca();
    }


    @When("^consulto un vuelo a origen \"([^\"]*)\" destino \"([^\"]*)\"$")
    public void consultoUnVueloAOrigenDestino(String vueloOrigen, String vueloDestino) {
vuelosStep.ingresarVuelos(vueloOrigen,vueloDestino);
vuelosStep.ingresarSoloIda();
vuelosStep.ingresarFecha();
vuelosStep.seleccionarSegundoVuelo();
precioTalla=vuelosStep.seleccionarTallaXS();
    }

    @Then("^valido los precios$")
    public void validoLosPrecios() {
    vuelosStep.validarPreciosTallas(precioTalla);
    }
}

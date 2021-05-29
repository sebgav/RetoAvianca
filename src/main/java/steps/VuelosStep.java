package steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import userinterface.PageAvianga;
import userinterface.PageAviangaSeleccionarVuelos;
import userinterface.PageInicialVuelos;

public class VuelosStep {

    PageInicialVuelos pageInicialVuelos;
    PageAvianga pageAvianga;
    PageAviangaSeleccionarVuelos pageAviangaSeleccionarVuelos;

    @Step
    public void abrirAvianca() {
        pageInicialVuelos.open();
    }

    @Step
    public void ingresarVuelos(String vueloOrigen, String vueloDestino)
    {
        pageAvianga.registrarOrigen(vueloOrigen);
        pageAvianga.registrarDestino(vueloDestino);
    }

    public void ingresarSoloIda() {
        pageAvianga.presionarSoloIda();
        pageAvianga.presionarSoloIda();

    }

    public void ingresarFecha()
    {
        pageAvianga.registrarFecha();
        pageAvianga.buscarVuelos();
    }

    public void seleccionarSegundoVuelo()
    {
        pageAviangaSeleccionarVuelos.seleccionSegundo();
    }

    public String seleccionarTallaXS() {
        String precioTalla = pageAviangaSeleccionarVuelos.getPrecioTallasXS();
        pageAviangaSeleccionarVuelos.seleccionarTallaXs();
        return precioTalla;
    }

    public void validarPreciosTallas(String precioTalla) {
        Assert.assertTrue("Se valida los precios de la talla antes y despues de ser selecionada",precioTalla.trim().equals(pageAviangaSeleccionarVuelos.getPrecioTallaLuegoSerSelccionada()));
    }
}


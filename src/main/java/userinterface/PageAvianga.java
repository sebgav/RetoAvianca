package userinterface;


import com.ibm.icu.text.CaseMap;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.joda.time.Days;
import org.jruby.javasupport.Java;
import org.openqa.selenium.Keys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static jxl.biff.BaseCellFeatures.logger;

public class PageAvianga extends PageObject
{
    @FindBy(xpath = "//*[@class='form-control airport pbOrigen airport_ida airport_mvvn valid']")
    WebElementFacade txtVueloOrigen;

    @FindBy(xpath = "(//*[@data-msg='Selecciona un origen'])[5]")
    WebElementFacade txtVueloOrigen1;

    @FindBy(xpath = "(//*[@data-msg='Selecciona un destino'])[5]")
    WebElementFacade txtVueloDestino;

    @FindBy(xpath = "//*[@role='presentation' and contains(@href,'#ida') and contains(text(),'Solo ida')]")
    WebElementFacade btnSoloida;

    @FindBy(xpath = "//*[@class='form-control solo-ida x-mvvm']")
    WebElementFacade btnFechas;

    @FindBy(xpath = "(//*[@data-day=\"2021.6.11\"])[3]")
    WebElementFacade btnDiaIda;

    @FindBy(xpath = "(//*[@title='Buscar vuelos' and @class='btn primary btn-codepromo pull-btn rojo'])[2]")
    WebElementFacade btnBuscarVuelos;


    public void registrarOrigen(String vueloOrigen) {
        withAction().moveToElement(txtVueloOrigen).build().perform();
        txtVueloOrigen.clear();
        txtVueloOrigen1.sendKeys(vueloOrigen);
        waitFor(3).second();
        txtVueloOrigen1.sendKeys(Keys.DOWN);
        txtVueloOrigen1.sendKeys(Keys.ENTER);
        logger.info(String.format("Se ingres el ciudad Orgien %s", vueloOrigen));
        waitFor(3).second();


    }



    public void registrarDestino(String vueloDestino) {

txtVueloDestino.clear();
txtVueloDestino.sendKeys(vueloDestino);
        waitFor(3).second();
        txtVueloDestino.sendKeys(Keys.DOWN);
        txtVueloDestino.sendKeys(Keys.ENTER);
        logger.info(String.format("Se ingres el ciudad Destino %s", vueloDestino));

    }

    public void presionarSoloIda()
    {
        btnSoloida.click();
        logger.info(String.format("Se presiona Solo vuelo %s", "Solo Ida"));
    }

    public void registrarFecha() {
        btnFechas.click();
        waitFor(3).second();

        btnDiaIda.click();
        waitFor(3).second();
        logger.info(String.format("Se registran la fecha del vuelo", "2021.6.11"));
    }

    public void buscarVuelos() {
        btnBuscarVuelos.click();
    }
}

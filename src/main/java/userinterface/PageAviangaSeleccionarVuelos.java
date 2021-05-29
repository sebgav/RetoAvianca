package userinterface;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static jxl.biff.BaseCellFeatures.logger;

public class PageAviangaSeleccionarVuelos extends PageObject {

    public Object seleccionarTallaXs;
    @FindBy(xpath = "(//*[@class='recap-price-details cabin-economy ng-star-inserted'])[2]")
    WebElementFacade btnSegundoVuelo1;

    @FindBy(xpath = "(//*[@class='amount amount-branded-fare'])[1]")
    WebElementFacade btnTallasXS;

    @FindBy(xpath = "(//*[@class='ff-price-section ng-star-inserted']//*[@class='amount amount-branded-fare'])[1]")
    WebElementFacade lblPrecioLuegoDeSeleccionarTalla;



    public void  seleccionSegundo()
    {
        waitFor(35).second();
        btnSegundoVuelo1.click();
        waitFor(3).second();
        logger.info(String.format("Se registra selecciona el segundo vuelo"));
    }

    public String getPrecioTallasXS() {
        logger.info(String.format("Se obtiene el valor del vuelo XS %s", btnTallasXS.getText().trim()));
        withAction().moveToElement(btnTallasXS).build().perform();

        return  btnTallasXS.getText().trim();

    }

    public void seleccionarTallaXs() {

        btnTallasXS.click();
        logger.info("Se presion la talla XS ");

    }


    public String getPrecioTallaLuegoSerSelccionada() {
        withAction().moveToElement(lblPrecioLuegoDeSeleccionarTalla).build().perform();
       return lblPrecioLuegoDeSeleccionarTalla.getText().trim();
    }
}

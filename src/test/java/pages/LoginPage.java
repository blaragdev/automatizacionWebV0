package pages;

//CLASE PARA METODOS Y XPATH ASOCIADOS A LA PAGINA
public class LoginPage extends BasePage {
    //XPATH de la pagina

    private String menuLateralSuperior = "//img[@alt='Logo Padok']";
    private String signInWithEmail = "//p[normalize-space()='Sign in with Email']";
    private String inputEmail = "//input[@name='email']";
    private String inputPass = "//input[@name='password']";
    private String botonIniciarSesion = "//button[normalize-space()='Iniciar sesión']";

    public String mensajeDashboard = "//p[contains(text(),'Este es tu Dashboard de tu cuenta Padok como administrador')]";
    public String mensajeMontoLiquidar = "//p[normalize-space()='Monto a liquidar']";
    public String mensajeTotalRecaudado = "//p[normalize-space()='Total recaudado']";
    public String mensajeDescuentos = "//p[normalize-space()='Descuentos']";

    //MARK: - METODOS

    //constructor que necesita BasePage
    public LoginPage(){
        super(driver); //ocupamos el driver de la clase padre BasePage
    }

    //metodo para navegar
    public void navegoADevPadokCl(){
        navigateTo("https://dev.padok.cl");
    }

    public void clickMenuLateralSuperior() {
        clickElement(menuLateralSuperior);
    }

    public void clickEnSignInWithEmail() {
        clickElement(signInWithEmail);
    }

    public void escriboUsuarioYClave() {
        writeElement(inputEmail, "qa@mobdev.cl");
        writeElement(inputPass, "Mobdev1234");
    }

    public void clickEnBotonIniciarSesion() {
        clickElement(botonIniciarSesion);
    }

    public Boolean mensajeDashboardSeaVisible() {
        return esperoElemento(mensajeDashboard);
    }

    public Boolean montoLiquidarSeaVisible() {
        return esperoElemento(mensajeMontoLiquidar);
    }

    public Boolean totalRecaudadoSeaVisible() {
        return esperoElemento(mensajeTotalRecaudado);
    }

    public Boolean montoDescuentosSeaVisible() {
        return esperoElemento(mensajeDescuentos);
    }
}
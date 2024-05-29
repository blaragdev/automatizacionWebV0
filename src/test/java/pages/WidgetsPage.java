package pages;

import java.util.List;

public class WidgetsPage extends BasePage {

    //MARK: - XPATH de la pagina
    
    private String selectMenuLink = "document.querySelector(\"div[class='element-list collapse show'] li[id='item-8'] span[class='text']\")"; // "//span[normalize-space()='Select Menu']"; 
    private String dropDownColors = "//select[@id='oldSelectMenu']";


    //MARK: - METODOS 

    //constructor que necesita BasePage
    public WidgetsPage(){
        super(driver); //ocupamos el driver de la clase padre BasePage
    }

    public void clickSelectMenuLink() {
        clickElement(selectMenuLink);
    }


}

package opgave4_countup;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;

/**
 * Tager og udbygger på klassen Application heraf kommer extends
 */
public class CountUpGui extends Application {
    // For at kunne overskrive skal vi bruge override
    @Override
    /**
     * Vores start metoden til at starte det yderste lag Stage
     */
    public void start(Stage stage) throws Exception {
        // Sætter titlen på Stage
        stage.setTitle("Tæl op");
        // Opretter et nyt Gridpane
        GridPane pane = new GridPane();
        // Starter pane ved at initContent metoden
        this.initContent(pane);

        // Opretter en ny scene
        Scene scene = new Scene(pane);
        // Sætter scene i vores stage objekt
        stage.setScene(scene);
        // Viser Stage
        stage.show();
    }
    // Her laves vores Label som udskriver "Number:"
    private final Label lbl = new Label("Number:");
    // En eventuel tælle variable (*VIL GERNE VIDE OM DER ER EN BEDRE MÅDE*)
    private int companionVariableNumber = 50;
    // Her laves vores tekstfelter der tager vores start-værdi på 50
    private final TextField number = new TextField(String.valueOf(companionVariableNumber));
    // En eventuel tælle variable (*VIL GERNE VIDE OM DER ER EN BEDRE MÅDE*)


    //Her laver vi vores knap/knapper
    private final Button addition = new Button("+");
    private final Button substtraktion = new Button("-");

    /**
     * Her er vores initContent som gør at vi kan redigere i vores pane
     * @param pane
     */
    private void initContent(GridPane pane) {
        //Dette er så man kan se de gridlines der vises i vores GUI
        pane.setGridLinesVisible(false);

        //Sætter padding (Margin)
        pane.setPadding(new Insets(20));
        //Sætter det horisontale gap
        pane.setVgap(5);
        //Sætter det vertikale gap
        pane.setHgap(5);

        //Vi tilføjer Label lbl til pane
        pane.add(lbl,0,2,1,2);
        //Vi tilføjer tekstfeltet number
        pane.add(number,1,2,5,2);

        // Vi tilføjer vores knappe
        pane.add(addition,6,0);
        pane.add(substtraktion,6,5);

        // Vores event Action der gør at når man trykker på knapperne vil der pluses og minus
        addition.setOnAction(event -> setAddition());
        substtraktion.setOnAction(event -> setSubsttraktion());
    }

    /**
     * Metode til at pluse den op med 1
     */
    public void setAddition(){
        companionVariableNumber++;
        number.setText(String.valueOf(companionVariableNumber));
    }

    /**
     * Metode til at minus
     */
    public void setSubsttraktion(){
        companionVariableNumber--;
        number.setText(String.valueOf(companionVariableNumber));
    }
}

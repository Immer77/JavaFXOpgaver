package Opgave2_frameswap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Tager og udbygger på klassen Application heraf kommer extends
 */
public class FrameSwap extends Application {
    // For at kunne overskrive skal vi bruge override
    @Override
    /**
     * Vores start metoden til at starte det yderste lag Stage
     */
    public void start(Stage stage) throws Exception {
        // Sætter titlen på Stage
        stage.setTitle("Swap Frame");
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

    // Her laves vores tekstfelter
    private final TextField txtFieldOne = new TextField();
    private final TextField txtFieldTwo = new TextField();

    //Her laver vi vores knap/knapper
    private final Button switchTextFields = new Button("Ombyt");

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
        pane.setHgap(10);

        //Sætter det vertikale gap
        pane.setVgap(10);

        // Vi tilføjer de 2 tekstfelter
        pane.add(txtFieldOne,1,1,5,1);
        pane.add(txtFieldTwo,1,3,5,3);

        // Vi tilføjer vores knappe
        pane.add(switchTextFields,1,5,3,5);

        // Vores event Action der gør at når man trykker på knappen så kalder den metoden
        switchTextFields.setOnAction(event -> setSwitchTextFields());
    }

    /**
     * Ændrer de 2 tekstfelter
     */
    private void setSwitchTextFields(){
        String firstFieldText = txtFieldOne.getText();
        txtFieldOne.setText(txtFieldTwo.getText());
        txtFieldTwo.setText(firstFieldText);
    }
}

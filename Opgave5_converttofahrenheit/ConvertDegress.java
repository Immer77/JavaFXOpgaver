package Opgave5_converttofahrenheit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * Tager og udbygger på klassen Application heraf kommer extends
 */
public class ConvertDegress extends Application {
    @Override
    /**
     * Vores start metoden til at starte det yderste lag Stage
     */
    public void start(Stage stage) throws Exception {
        // Sætter titlen på Stage
        stage.setTitle("Temperatur Converter");
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
    // Her laves vores Label som udskriver "Temperature"
    private final Label lbl = new Label("Temperature");

    //laver et tekstfel objekt og ligger det i grader.
    private final TextField grader = new TextField();

    //Her laves vores knapper
    private final Button fahrenheit = new Button("Fahrenheit");
    private final Button celcious = new Button("celcious");

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

        //Vi tilføjer tekstfeltet grader
        pane.add(grader,1,2,3,2);

        //Vi tilføjer Label lbl til pane
        pane.add(lbl,1,1,1,1);

        // Vi tilføjer vores knapper
        pane.add(fahrenheit,4,1,5,1);
        pane.add(celcious,4,3,5,3);

        //// Vores event Action der gør at når man trykker på ændrer det fra grader til celcius
        fahrenheit.setOnAction(event -> setFahrenheit());
        celcious.setOnAction(event -> setCelcious());
    }

    /**
     * Metode til at tjek fahrenheit
     */
    public void setFahrenheit(){
        double nummer = Double.parseDouble(grader.getText());
        nummer = nummer * 9 / 5 + 32;
        grader.setText(String.valueOf(nummer));
    }

    /**
     * Metode til at se celcious
     */
    public void setCelcious(){
        double nummer = Double.parseDouble(grader.getText());
        nummer = (5.0/9) * (nummer - 32);
        grader.setText(String.valueOf(nummer));
    }
}

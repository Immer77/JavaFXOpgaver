package Opgave3_splitswap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Tager og udbygger på klassen Application heraf kommer extends
 */
public class SplitTextGui extends Application {
    // For at kunne overskrive skal vi bruge override
    @Override
    /**
     * Vores start metoden til at starte det yderste lag Stage
     */
    public void start(Stage stage) throws Exception {
        // Sætter titlen på Stage
        stage.setTitle("Split Tekst");
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
    private final TextField fullName = new TextField();
    private final TextField firstName = new TextField();
    private final TextField lastName = new TextField();

    //Her laver vi vores knap/knapper
    private final Button splitText = new Button("Split");

    /**
     * Her er vores initContent som gør at vi kan redigere i vores pane
     * @param pane
     */
    private void initContent(GridPane pane) {
        //Dette er så man kan se de gridlines der vises i vores GUI
        pane.setGridLinesVisible(true);

        //Sætter padding (Margin)
        pane.setPadding(new Insets(20));
        //Sætter det horisontale gap
        pane.setHgap(10);
        //Sætter det vertikale gap
        pane.setVgap(10);

        // Vi tilføjer de 3 tekstfelter
        pane.add(fullName,1,1,8,1);
        pane.add(firstName,1,3,3,3);
        pane.add(lastName,4,3,8,3);

        // Vi tilføjer vores knappe
        pane.add(splitText,1,7);

        // Vores event Action der gør at når man trykker på knappen så kalder den metoden
        splitText.setOnAction(event -> setSplitText());
    }

    /**
     * Metoden til at splitte teksten
     */
    public void setSplitText(){
        //Laver et array af fullname string som splittes ved mellemrum
        String[] fullNameArr = fullName.getText().split(" ");
        //Sætter firstname til det først i array
        firstName.setText(fullNameArr[0]);
        // Sætter lastname til index 1 i array
        lastName.setText(fullNameArr[1]);
    }
}

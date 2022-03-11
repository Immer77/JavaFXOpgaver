package Opgave1_nameConnectorGui;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// Til start skal vi have extended Application klassen da vi vil udbygge på den gui class her i studentGui
public class NameConnectorGui extends Application {

    //For at kunne overskrive start metoden skal vi bruge Override:
    @Override
    public void start(Stage stage){
        //Starter med det yderste lag Stage og giver den en titel
        stage.setTitle("Kombiner navne");
        //Her opretter vi en reference til objektet pane som er i det tilfælde et gridpane
        GridPane pane = new GridPane();
        //Initcontent indeholder den information på gridpane som vi ændrer i nede i metoden
        this.initContent(pane);


        //Opretter her en scene hvor vi kan sætte en stage på.
        Scene scene = new Scene(pane);
        //Sætter scenen på Stagen
        stage.setScene(scene);
        //Show kommandoen viser stage, da vi nu har både stage, scene og panes
        stage.show();

    }

    //------------------------------------------------------------------------------------------------------------------
    //Her laver vi vores knapper
    //Først de 3 tekstfelter hvor man har firstname, lastname og navnene samlet
    private final TextField firstName = new TextField();
    private final TextField lastName = new TextField();
    private final TextField combinedNames = new TextField();

    //Knappen der kombinere navnene
    private final Button combineBtn = new Button("Kombiner");


    private void initContent(GridPane pane) {
        //Vi sætter her for at kunne se linjerne i gridlines for at skabe overblik
        pane.setGridLinesVisible(true);

        // Sætter padding
        pane.setPadding(new Insets(20));

        // Sætter det horisontale afstand
        pane.setHgap(10);

        // Sætter den vertikale afstand mellem komponenterne
        pane.setVgap(10);

        // i = Kolonne start, i1 = række start, i2 = kolonne slut, i3= række slut
        pane.add(firstName,1,1,4,1);
        pane.add(lastName,5,1,8,1 );
        pane.add(combinedNames,1,2,8,2);


        // i = Kolonne, i1 = række
        pane.add(combineBtn,1,4);

        // Så skal der oprettes en Event action til knappen
        combineBtn.setOnAction(event -> connectNames());
    }
    // Samler navnene i firstname og lastname
    private void connectNames(){
        combinedNames.setText(firstName.getText() + " " + lastName.getText());
    }
}

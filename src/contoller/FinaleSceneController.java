package contoller;
import java.lang.Math;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import model.Table;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import model.Table;


import java.net.URL;
import java.util.ResourceBundle;

public class FinaleSceneController implements Initializable {


    @FXML private TextField textFieldFirst;
    @FXML private TextField fCalculated;
    @FXML private TextField conclusionField;
    @FXML private ComboBox<Integer> fistSystemToChoose;
    @FXML private ComboBox<Integer> secondSystemToChoose;
    @FXML private TextArea test;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        double tmp= (Table.ssa/Table.sst)*100;
        textFieldFirst.setText(Double.toString(tmp));
        fCalculated.setText(Double.toString(Table.fValueCalculated));
        test.setText("nemam pojma sta je zakljucak jer ne znam izracunati f raspodjelu");
        for(int i=0;i<Table.getNumOfAlternatives();i++){
            fistSystemToChoose.getItems().add(i+1);
            secondSystemToChoose.getItems().add(i+1 );
        }
        fistSystemToChoose.getSelectionModel().selectFirst();
        secondSystemToChoose.getSelectionModel().selectFirst();
        test.setText("nemam pojma sta je zakljucak jer ne znam izracunati f raspodjelu");
    }

    public void uporediBtnClick(ActionEvent actionEvent) {
        int firstSystem=fistSystemToChoose.getValue()-1;
        int secondSystem=secondSystemToChoose.getValue()-1;
        float c=0;
        for(int i=0;i<Table.getNumOfAlternatives();i++){
            if(Table.alternatives[i].getNumOfMeasurements()==firstSystem)
                c=Table.effects[i];
            if(Table.alternatives[i].getNumOfMeasurements()==secondSystem)
                c-=Table.effects[i];
        }
        double se=Math.sqrt(Table.sse/(Table.getNumOfAlternatives()*(Table.alternatives[0].getNumOfMeasurements()-1)));
        double  sc=se*Math.sqrt(2.0/(Table.getNumOfAlternatives()*Table.alternatives[0].getNumOfMeasurements()));






    }
}


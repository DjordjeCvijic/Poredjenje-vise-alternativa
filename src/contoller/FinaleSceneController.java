package contoller;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;
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
    @FXML private TextField fFromTable;
    @FXML private ComboBox<Integer> fistSystemToChoose;
    @FXML private ComboBox<Integer> secondSystemToChoose;
    @FXML private TextArea test;
    @FXML private TextField finaleField;

    private TDistribution t=new TDistribution(Table.getNumOfAlternatives()*(Table.alternatives[0].getNumOfMeasurements()-1));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FDistribution f=new FDistribution(Table.getNumOfAlternatives()-1,Table.getNumOfAlternatives()*(Table.alternatives[0].getNumOfMeasurements()-1))   ;

        double tmp= (Table.ssa/Table.sst)*100;
        textFieldFirst.setText(Double.toString(tmp));
        fCalculated.setText(Double.toString(Table.fValueCalculated));
        fFromTable.setText(Double.toString(f.inverseCumulativeProbability(0.95)));
        if(Table.fValueCalculated>f.inverseCumulativeProbability(0.95))
            test.setText("Sa 95% mozemo tvrditi da je varijacija zbog pravih razlika u alternativama");
        else
            test.setText("Sa 95% mozemo tvrditi da je varijacija zbog gresaka u mjerenjima");
        for(int i=0;i<Table.getNumOfAlternatives();i++){
            fistSystemToChoose.getItems().add(i+1);
            secondSystemToChoose.getItems().add(i+1 );
        }
        fistSystemToChoose.getSelectionModel().selectFirst();
        secondSystemToChoose.getSelectionModel().selectFirst();

    }

    public void uporediBtnClick(ActionEvent actionEvent) {
        int firstSystem=fistSystemToChoose.getValue()-1;
        int secondSystem=secondSystemToChoose.getValue()-1;
        float c=0;
        for(int i=0;i<Table.getNumOfAlternatives();i++){
            System.out.println();
            if(Table.alternatives[i].getNumOfAlternative()==firstSystem)
                c=Table.effects[i];

            if(Table.alternatives[i].getNumOfAlternative()==secondSystem)
                c-=Table.effects[i];

        }
        double se=Math.sqrt(Table.sse/(Table.getNumOfAlternatives()*(Table.alternatives[0].getNumOfMeasurements()-1)));
        double  sc=se*Math.sqrt(2.0/(Table.getNumOfAlternatives()*Table.alternatives[0].getNumOfMeasurements()));
        double c1,c2;
        c1=c-t.inverseCumulativeProbability(0.95)*sc;
        c2=c+t.inverseCumulativeProbability(0.95)*sc;
        if(c1<0&&c2>0)
            finaleField.setText("Izabrani sistemi se ne razlikuju");
        else
            finaleField.setText("Izabrani sistemi se razlikuju");






    }
}


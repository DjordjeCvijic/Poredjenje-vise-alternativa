package contoller;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import model.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TableScenaController {


    @FXML private Button CommitButton;
    @FXML private TextField NumberOfAlterntives;
    @FXML private ComboBox<Integer> AlternativeToChoose;
    @FXML private TextField FieldForMeasurements;


    public void CommitButtonClick(ActionEvent actionEvent) {

        Table.setTable(Integer.parseInt(NumberOfAlterntives.getText()));
        int i=1;
        while(i<=Integer.parseInt(NumberOfAlterntives.getText()))
            AlternativeToChoose.getItems().add(i++);




    }

    public void SaveButtonClick(ActionEvent actionEvent) {


        Table.alternatives[AlternativeToChoose.getValue()-1].setScores(FieldForMeasurements.getText());
        //System.out.println( Table.alternatives[AlternativeToChoose.getValue()-1].print());
    }

    public void AlternativeToChooseClick(ActionEvent actionEvent) {

        if(!Table.alternatives[AlternativeToChoose.getValue()-1].isEmpty())
        FieldForMeasurements.setText(Table.alternatives[AlternativeToChoose.getValue()-1].print());
        else
            FieldForMeasurements.setText("");


        }


    public void calculationBtnClick(ActionEvent actionEvent) {






    }
}


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable{
    @FXML
    public Button Volume_test;
    @FXML
    public Text score_field;
    @FXML
    public ComboBox volume_comboBox;


    public void beginVolumeTest(){
        String comboValue;
        comboValue=(String) volume_comboBox.getValue();
        TestBox a=new TestBox();

        if(comboValue.equals("baby mode")) {
            a.start(25, score_field);
            return;
        }
        if(comboValue.equals("easy")) {
            a.start(100, score_field);
            return;
        }
        if(comboValue.equals("medium")) {
            a.start(250, score_field);
            return;
        }
        if(comboValue.equals("hard")) {
            a.start(500, score_field);
            return;
        }
        if(comboValue.equals("ultra")) {
            a.start(1000, score_field);
            return;
        }
        if(comboValue.equals("overkill")) {
            a.start(1500, score_field);
            return;
        }

        a=null;



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {    // aici pui valori initiale pentru combobox

        ObservableList<String> volume_list= FXCollections.observableArrayList("baby mode","easy","medium","hard","ultra","overkill");
        volume_comboBox.setItems(volume_list);
    }
}

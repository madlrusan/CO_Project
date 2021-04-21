import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IndexController {
    @FXML
    public Button Volume_test;
    @FXML
    public Text score_field;

    public void beginVolumeTest(){
        TestBox a=new TestBox();
       // Stage volumeStage=new Stage();
       a.start(800,score_field);
      //  volumeStage=null;
        a=null;



    }
}

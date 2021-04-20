import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IndexController {
    @FXML
    public Button Volume_test;

    public void beginVolumeTest(){
        TestBox a=new TestBox();
       // Stage volumeStage=new Stage();
        a.start(1);
      //  volumeStage=null;
        a=null;



    }
}

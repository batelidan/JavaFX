package view.week1_2;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    int [][] mazeData={
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//1==wall
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,1},
            {1,0,0,1,1,1,0,0,0,0,0,0,0,1,1,0,0,0,1},
            {1,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,1},
            {1,0,0,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
    };
    @FXML
    MazeDisplayer mazeDisplayer;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    /*public MainWindowController() {//פעם אחת שהאוביקט נוצר
        mazeDisplayer.setMazeData(null);
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mazeDisplayer.setMazeData(mazeData);

        mazeDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED,(e)->mazeDisplayer.requestFocus());

        mazeDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
       int r=mazeDisplayer.getcRow();
       int c=mazeDisplayer.getcCol();

            if(keyEvent.getCode()== KeyCode.UP)
               mazeDisplayer.setCharacterPostion(r-1,c);//עולה שורה
                if(keyEvent.getCode()== KeyCode.DOWN)
                    mazeDisplayer.setCharacterPostion(r+1,c);//יורדים שורה
                if(keyEvent.getCode()== KeyCode.RIGHT)
                    mazeDisplayer.setCharacterPostion(r,c+1);
                if(keyEvent.getCode()== KeyCode.LEFT)
                    mazeDisplayer.setCharacterPostion(r,c-1);

            }
        });
    }

    public void start(){
        System.out.println("start");
    }

    public void openFile(){
        FileChooser fc=new FileChooser();
        fc.setTitle("open maze file");
        fc.setInitialDirectory(new File("./Resources"));
        File chosen=fc.showOpenDialog(null);
        if(chosen!=null){
            System.out.println(chosen.getName());
        }

    }


}
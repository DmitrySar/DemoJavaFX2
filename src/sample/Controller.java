package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Controller {

    private String path = "";
    @FXML
    TextArea code;
    @FXML
    WebView viewer;
    @FXML
    public void toView() {
        viewer.getEngine().loadContent(code.getText());
    }
    @FXML
    public void openFile() throws IOException {
        path = new FileChooser().showOpenDialog(new Stage()).getAbsolutePath();
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(path));
        code.setText("");
        for (String s: lines) {
            code.appendText(s + "\n");
        }
    }
    @FXML
    public void saveFileAs() throws IOException {
        path = new FileChooser().showSaveDialog(new Stage()).getAbsolutePath();
        Files.write(Paths.get(path), code.getText().getBytes());
    }
}

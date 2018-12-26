package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
//
//    @FXML
//    private Button openButton;

    @FXML
    private Label labelText;

    @FXML
    private GridPane gridPane;

    @FXML
    private WebView webView;

    public void initialize() {

    }

    @FXML
    public void handleMouseEntered() {
        labelText.setScaleX(2.0);
        labelText.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExited() {
        labelText.setScaleX(1.0);
        labelText.setScaleY(1.0);
    }

    public void handleOpenButton() {
//        FileChooser chooser = new FileChooser();
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Open ... ");
//        chooser.showOpenDialog(gridPane.getScene().getWindow());
        File file = chooser.showDialog(gridPane.getScene().getWindow());
    }

    @FXML
    public void handleOpenAsButton() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open As");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("Pdf", "*.pdf"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        chooser.showOpenDialog(gridPane.getScene().getWindow());
//        chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
    }

    @FXML
    public void handleSaveAsButton() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save As");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("Pdf", "*.pdf")
        );

        File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
//        chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        System.out.println(file.getPath());
    }

    @FXML
    public void handleHelpLink() {
//        try {
//            Desktop.getDesktop().browse(new URI("http://www.github.com"));
//        } catch (Exception e) {
//            e.getStackTrace();
//        }

        WebEngine engine = webView.getEngine();
//        engine.load("http://www.github.com");
        engine.load("http://www.instragram.com");
    }

}

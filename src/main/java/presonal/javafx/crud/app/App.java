package presonal.javafx.crud.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Simple Crud App");
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
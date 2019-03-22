package application;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneLoader {
	private Stage stage;
	public static final int SCENE_TITLE = 0;
	public static final int SCENE_GAME = 1;
	public static final int SCENE_RULES = 2;

	public SceneLoader(Stage stage) {
		this.stage =stage;
	}

	public void switchTo(int scene) throws IOException {
		switch(scene) {
		case SCENE_TITLE : 
			stage.setScene(makeSceneTitle());
			break;
		case SCENE_GAME :
			stage.setScene(makeSceneGame());
			break;
		case SCENE_RULES :
			stage.setScene(makeSceneRules());
			break;
		}
	}

	private Scene makeSceneTitle() throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("Views/TestView.fxml"));
		Scene scene = new Scene(root,1280,720);
		scene.setFill(Color.WHITE);
		return scene;

	}
	private Scene makeSceneGame() throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("Views/stageGame.fxml"));
		Scene scene = new Scene(root,1280,720);
		scene.setFill(Color.WHITE);
		return scene;

	}
	private Scene makeSceneRules() throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("Views/TestView.fxml"));
		Scene scene = new Scene(root,1280,720);
		scene.setFill(Color.WHITE);
		return scene;
	}
}

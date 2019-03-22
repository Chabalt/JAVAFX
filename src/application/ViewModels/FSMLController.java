package application.ViewModels;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import application.Main;
import application.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FSMLController {

	@FXML
	private Button btnMusique;
	@FXML
	private ImageView samus;
	public int deplacement = 10;
	public boolean dDroite = false;



	private Button changeStage1;
	@FXML
	private void playMusique(ActionEvent event) {
		new javafx.embed.swing.JFXPanel();
		String uriString = new File("echec.mp3").toURI().toString();
		new MediaPlayer(new Media(uriString)).play();
	}
	@FXML
	void switchToGame(ActionEvent event) {
		try {
			Main.screneloader.switchTo(SceneLoader.SCENE_GAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void move(KeyEvent event) {
		System.out.println(event.getCode());
		if(event.getCode()==KeyCode.RIGHT) {
			dDroite = true;
		}
		else {
			dDroite =false;
		}

		if(event.getCode()==KeyCode.LEFT) {
			samus.setLayoutX(samus.getLayoutX() - deplacement);
		}
	}
	public void act() {
		if(dDroite==true) {
		    	samus.setLayoutX(samus.getLayoutX() + deplacement);
		}
	}
}
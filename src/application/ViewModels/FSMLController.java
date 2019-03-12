package application.ViewModels;
import javafx.event.ActionEvent;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FSMLController {

	    @FXML
	    private Button btnMusique;

	    @FXML
	    private void playMusique(ActionEvent event) {
	    	new javafx.embed.swing.JFXPanel();
	        String uriString = new File("echec.mp3").toURI().toString();
	        new MediaPlayer(new Media(uriString)).play();
	    }
	    	
	}


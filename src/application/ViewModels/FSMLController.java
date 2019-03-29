package application.ViewModels;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import application.Main;
import application.SceneLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FSMLController implements Initializable {
	public int chrono =0 ;
	private Timeline tm;

	@FXML
	private Button btnMusique;
	@FXML
	private ImageView samus;
	@FXML
	private Rectangle rectGauche;

	@FXML
	private Rectangle rectDroit;

	@FXML
	protected Rectangle rectBotLef;

	@FXML
	private Rectangle rectBotRight;

	@FXML
	protected Rectangle rectTopLeft;

	@FXML
	private Rectangle rectTopMid;

	@FXML
	private Rectangle rectTopRight;

	@FXML
	private Rectangle platTopLeft;

	@FXML
	private Rectangle platTopRight;

	@FXML
	private Rectangle platMidMid;

	@FXML
	private Rectangle platBotRight;

	@FXML
	private Rectangle platMidRigh;

	@FXML
	private Rectangle platMidLeft;

	@FXML
	private Rectangle platBotLeft;

	public int deplacement = 10;
	public int tmpsaut =0;
	public int topTableau = 100;
	boolean droite, gauche, jump;
	@FXML
	public String image ;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tm = new Timeline(new KeyFrame(Duration.millis(1000/60),e->timeAction()));
		tm.setCycleCount(Timeline.INDEFINITE);
		tm.play();
		image = "@../../../Images/Samus/SamusPlaceDroite.png";
	}

	private void timeAction() {
		chrono++;
		System.out.println(samus);
		System.out.println(rectBotLef);
		if(  (samus.getLayoutY() < rectBotLef.getLayoutY() ) &&  (samus.getLayoutX()<rectBotLef.getLayoutX()+rectBotLef.getWidth())){
	
		}
		else {
			samus.setLayoutY(samus.getLayoutY() + (4));
			if(samus.getLayoutY()>720)
			{
				switchToMenu();
			}
		}
		if(droite) {
			if((samus.getLayoutX()+25)>=rectDroit.getLayoutX()){
				droite = false ;
			}
			else{ 
				image = "@../../../Images/Samus/SamusPlaceDroite.png";
				samus.setLayoutX(samus.getLayoutX() + (deplacement/2));
			}
		}
		else if(gauche) {
			if(samus.getLayoutX()<=(rectGauche.getLayoutX()+rectGauche.getWidth()+3)){
				gauche = false ;
			}
			else {image = "@../../../Images/Samus/SamusPlaceGauche.png";
			samus.setLayoutX(samus.getLayoutX() - (deplacement/2));
			}
		}
		/*if(jump) {
			tmpsaut++;
			if(tmpsaut<35) {
				if(samus.getLayoutY()>topTableau) {
					samus.setLayoutY(samus.getLayoutY() - (4));
				}
				else {
					tmpsaut=36;
				}
			}
			else if(samus.getLayoutY()+53 <= 620) {
				samus.setLayoutY(samus.getLayoutY() + (4));
				System.out.println(samus.getLayoutY());
			}
			else {
				jump=false;
				tmpsaut = 0;
			}
		}*/


	}



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
	void switchToMenu() {
		try {
			Main.screneloader.switchTo(SceneLoader.SCENE_TITLE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void move(KeyEvent event) {
		if(event.getCode()==KeyCode.RIGHT) {
			droite = true;
		}
		if(event.getCode()==KeyCode.LEFT) {
			gauche = true;
		}
		if(event.getCode()==KeyCode.SPACE) {
			jump = true;
		}
	}

	@FXML
	public void stop(KeyEvent event) {
		if(event.getCode()==KeyCode.RIGHT) {
			if(tmpsaut!=0) {}
			else{
				droite = false;
			}
		}
		if(event.getCode()==KeyCode.LEFT) {
			gauche = false;
		}
	}
}
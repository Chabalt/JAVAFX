package application.ViewModels;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.SceneLoader;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FXMLModelGameStage implements Initializable {

	//pour les action et le chrono
	private int chrono =0 ;
	private Timeline tm;
	boolean droite, gauche, jump;
	public int deplacement = 6;
	public int tmpsaut =0;
	public int tmpEnLAire = 25;

	//le perso
	@FXML
	protected ImageView samus;


	//le tableau
	public int topTableau = 100;
	@FXML
	private Rectangle rectLeft;
	@FXML
	private Rectangle rectRight;
	@FXML
	protected Rectangle rectBotLeft;
	@FXML
	private Rectangle rectBotRight;
	@FXML
	private Rectangle rectTopLeft;
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
    private Rectangle platMidRight;
    @FXML
    private Rectangle platMidLeft;
    @FXML
    private Rectangle platBotLeft;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		tm = new Timeline(new KeyFrame(Duration.millis(1000/60),e->timeAction()));
		tm.setCycleCount(Timeline.INDEFINITE);
		tm.play();
	}

	private void timeAction() {
		chrono++;

		//faire la chute constante hors platforme
		if(   (samus.getBoundsInParent().intersects(rectBotLeft.getBoundsInParent())) || (samus.getBoundsInParent().intersects(rectBotRight.getBoundsInParent())) ||
				(samus.getBoundsInParent().intersects(platTopLeft.getBoundsInParent())) || (samus.getBoundsInParent().intersects(platTopRight.getBoundsInParent())) ||
				(samus.getBoundsInParent().intersects(platMidLeft.getBoundsInParent())) || (samus.getBoundsInParent().intersects(platMidMid.getBoundsInParent())) ||
				(samus.getBoundsInParent().intersects(platMidRight.getBoundsInParent())) || (samus.getBoundsInParent().intersects(platBotLeft.getBoundsInParent())) ||
				(samus.getBoundsInParent().intersects(platBotRight.getBoundsInParent())) || (jump == true) ){
			
		}
		else {
			samus.setLayoutY(samus.getLayoutY() + (deplacement));
			if(samus.getLayoutY()>720)
			{
				tm.stop();
				switchToMenu();
			}
			
		}
		
		if(droite) {
			if((samus.getLayoutX()+25)>=rectRight.getLayoutX()){
				droite = false ;
			}
			else{ 
				samus.setLayoutX(samus.getLayoutX() + (deplacement));
			}
		}
		
		if(gauche) {
			if(samus.getLayoutX()<=(rectLeft.getLayoutX()+rectLeft.getWidth()+3)){
				gauche = false ;
			}
			else{ 
				samus.setLayoutX(samus.getLayoutX() - (deplacement));
			}
		}
		
		if(jump) {
			tmpsaut++;
			if(tmpsaut<tmpEnLAire) {
				if(samus.getLayoutY()>topTableau) {
					samus.setLayoutY(samus.getLayoutY() - (deplacement));
				}
				else {
					tmpsaut=tmpEnLAire+1;
					jump = false;
				}
			}
	
			else if(   (samus.getBoundsInParent().intersects(rectBotLeft.getBoundsInParent())) || (samus.getBoundsInParent().intersects(rectBotRight.getBoundsInParent())) ||
					(samus.getBoundsInParent().intersects(platTopLeft.getBoundsInParent())) || (samus.getBoundsInParent().intersects(platTopRight.getBoundsInParent())) ||
					(samus.getBoundsInParent().intersects(platMidLeft.getBoundsInParent())) || (samus.getBoundsInParent().intersects(platMidMid.getBoundsInParent())) ||
					(samus.getBoundsInParent().intersects(platMidRight.getBoundsInParent())) || (samus.getBoundsInParent().intersects(platBotLeft.getBoundsInParent())) ||
					(samus.getBoundsInParent().intersects(platBotRight.getBoundsInParent())) ){
				jump=false;
				tmpsaut = 0;
			}
			else {
				jump=false;
				tmpsaut = 0;
				
			}
		}
	}




	//pour la defaite 
	@FXML
	void switchToMenu() {
		try {
			Main.screneloader.switchTo(SceneLoader.SCENE_TITLE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//detection clavier
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
			droite = false;
		}
		if(event.getCode()==KeyCode.LEFT) {
			gauche = false;
		}
	}


}

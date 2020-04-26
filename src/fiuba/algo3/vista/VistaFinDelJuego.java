package fiuba.algo3.vista;

import fiuba.algo3.controlador.eventos.ControladorFinDelJuego;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class VistaFinDelJuego extends GridPane{
	
	private Image wallpaper;
	
	public VistaFinDelJuego() {
		setPadding(new Insets(10,10,10,10));
		setVgap(8);
		setHgap(10);
		this.wallpaper = new Image("wallpaperInicio.jpg");
		
		setBackground(new Background(new BackgroundImage(wallpaper,BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));		

		Label mensaje = new Label("GANASTE!! Has conseguido el diamante!");
		mensaje.setStyle("-fx-text-fill: white;"+
				"-fx-font-family: Verdana;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 24;");
		GridPane.setConstraints(mensaje, 20,16);
		
		//Image diamante = new Image("diamante1.png");
		ImageView diamante = new ImageView();
		diamante.setImage(new Image("diamante1.png",60, 60, false, false));
		diamante.setTranslateY(250);
		diamante.setTranslateX(350);
		
	/*	Button botonEnd = new Button("END");
		botonEnd.setPrefSize(150,100);
		botonEnd.setStyle("-fx-text-fill: black;"+
				"fx-background: Grey;"+
				"-fx-font-family: Verdana;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 24;");
		
		botonEnd.setOnAction(ControladorFinDelJuego.getInstance().manejadorFinDelJuego());
		
		GridPane.setConstraints(botonEnd, 21, 30);
		GridPane.setHalignment(botonEnd, HPos.CENTER);
		getChildren().addAll(mensaje, diamante, botonEnd);
*/		
		
		
		
		getChildren().addAll(mensaje, diamante);
		
	}
}
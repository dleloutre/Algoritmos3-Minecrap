package fiuba.algo3.vista;

import fiuba.algo3.controlador.eventos.ControladorInicializacionDeJuego;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class VistaDeInicializacionDeJuego extends GridPane{
	
	private Image wallpaper;
	private TextField nombreJugadorText;
	
	public String getNombreJugador() {
		return nombreJugadorText.getText();
	}
	
	public VistaDeInicializacionDeJuego() {
		setPadding(new Insets(10,10,10,10));
		setVgap(8);
		setHgap(10);
		this.wallpaper = new Image("wallpaperInicio.jpg");
		
		setBackground(new Background(new BackgroundImage(wallpaper,BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
		
		nombreJugadorText = new TextField();
		nombreJugadorText.setStyle("-fx-text-fill: black;"+
				"-fx-font-family: Verdana;"+
			    "-fx-font-size: 18;");
		nombreJugadorText.setPrefSize(150, 50);
		GridPane.setConstraints(nombreJugadorText, 21, 16);
		
		
		Label nombreJugador = new Label("Nombre: ");
		nombreJugador.setStyle("-fx-text-fill: white;"+
				"-fx-font-family: Verdana;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 24;");
		GridPane.setConstraints(nombreJugador, 20,16);
		
		Button botonStart = new Button("START");
		botonStart.setPrefSize(150,100);
		botonStart.setStyle("-fx-text-fill: black;"+
				"fx-background: Grey;"+
				"-fx-font-family: Verdana;"+
			    "-fx-font-weight: bold;"+
			    "-fx-font-size: 24;");
		
		botonStart.setOnAction(ControladorInicializacionDeJuego.getInstance().manejadorIniciarJuego());
		
		GridPane.setConstraints(botonStart, 21, 30);
		GridPane.setHalignment(botonStart, HPos.CENTER);
		getChildren().addAll(nombreJugador,nombreJugadorText,botonStart);
	}
}

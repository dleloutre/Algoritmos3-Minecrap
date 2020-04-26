package fiuba.algo3.vista;

import fiuba.algo3.controlador.eventos.ControladorInicializacionDeJuego;
import fiuba.algo3.controlador.eventos.ControladorStage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		ControladorStage.getInstance().setStage(stage);
		
		Scene scene = ControladorInicializacionDeJuego.getInstance().crearSceneConVista();
		stage.setScene(scene);
		
		stage.show();
	}

}

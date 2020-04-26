package fiuba.algo3.controlador.eventos;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorStage {
	
	private static final String APPLICATION_NAME = "AlgoCraft";

	private Stage stage;
	private static ControladorStage instance;
	
	private ControladorStage() {
		
	}
	
	public static ControladorStage getInstance() {
		if(instance == null) {
			instance = new ControladorStage();
		}
		return instance;
	}
	
	
	public void setStage(Stage stage) {
		this.stage = stage;
		stage.setTitle(APPLICATION_NAME);
	}
	
	public void setScene(Scene scene) {
		this.stage.setScene(scene);
	}
	
}

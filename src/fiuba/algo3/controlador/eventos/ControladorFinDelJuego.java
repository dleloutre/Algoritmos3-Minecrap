package fiuba.algo3.controlador.eventos;

import fiuba.algo3.vista.VistaFinDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ControladorFinDelJuego {
	
	public static final double WIDTH = 800;
	public static final double HEIGHT = 500;
	private static ControladorFinDelJuego instance;
	private VistaFinDelJuego vista;
	
	private ControladorFinDelJuego() {
		
	}
	
	public static ControladorFinDelJuego getInstance() {
		if ( instance == null ) {
			instance = new ControladorFinDelJuego();
		}
		
		return instance;
	}


	public VistaFinDelJuego obtenerVista() {
		if(vista == null) {
			this.vista = new VistaFinDelJuego();
		}
		return this.vista;
	}
	
	public Scene cambiarSceneConVista() {
		Scene scene = new Scene(obtenerVista(), WIDTH, HEIGHT);
		ControladorStage.getInstance().setScene(scene);
		return scene;
	}

	public EventHandler<ActionEvent> manejadorFinDelJuego(){
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			}
		};
	}
}
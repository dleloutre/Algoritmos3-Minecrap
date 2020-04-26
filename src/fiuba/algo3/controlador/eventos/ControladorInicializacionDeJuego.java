package fiuba.algo3.controlador.eventos;

import fiuba.algo3.vista.VistaDeInicializacionDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ControladorInicializacionDeJuego {
	
	public static final double WIDTH = 800;
	public static final double HEIGHT = 500;
	private static ControladorInicializacionDeJuego instance;
	private VistaDeInicializacionDeJuego vista;
	
	private ControladorInicializacionDeJuego() {
		
	}
	
	public static ControladorInicializacionDeJuego getInstance() {
		if ( instance == null ) {
			instance = new ControladorInicializacionDeJuego();
		}
		
		return instance;
	}
	
	public VistaDeInicializacionDeJuego obtenerVista() {
		if(vista == null) {
			this.vista = new VistaDeInicializacionDeJuego();
		}
		return this.vista;
	}
	
	public Scene crearSceneConVista() {
		Scene scene = new Scene(obtenerVista(), WIDTH, HEIGHT);
		return scene;
	}
	
	public EventHandler<ActionEvent> manejadorIniciarJuego(){
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String nombreElegido = vista.getNombreJugador();
				ControladorJuego.getInstance().setNombreJugador(nombreElegido);
				
				Scene nuevaScene = ControladorJuego.getInstance().crearSceneConVista();
				
				ControladorStage.getInstance().setScene(nuevaScene);
			}
		};
	}
}

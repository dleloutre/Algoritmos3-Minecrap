package fiuba.algo3.vista.boton;

import javafx.scene.control.Button;

public class BotonTablero extends Button {
	
	private static BotonTablero instance;

	private BotonTablero(){
		super("Construir herramienta");		
	}
	
	public static BotonTablero getInstance(){
		if( instance == null ) {
			instance = new BotonTablero();
		}
		return instance;
	}
	
}

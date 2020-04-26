package fiuba.algo3.vista.boton;

import javafx.scene.control.Button;

public class BotonInventario extends Button {

	private static BotonInventario instance;

	private BotonInventario(){
		super("Abrir inventario");		
	}
	
	public static BotonInventario getInstance(){
		if( instance == null ) {
			instance = new BotonInventario();
		}
		return instance;
	}
	
	
	
}

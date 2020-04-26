package fiuba.algo3.vista.posicionable;

import fiuba.algo3.controlador.eventos.ControladorInventario;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;

public class VistaPosicionableHerramientaFabricada extends VistaPosicionable {
	
	public VistaPosicionableHerramientaFabricada(Posicionable posicionable, int dimension) {
		super(posicionable, new Posicion(1,1), dimension);
	}
	
	@Override
	public void removerDeVista() {
		ControladorInventario.getInstance().removerHerramientaFabricada();
		ControladorInventario.getInstance().vaciarBosquejo();
	}

	@Override
	public void insertarEnVista(Posicionable posicionable) {

	}


}

package fiuba.algo3.vista.posicionable;

import fiuba.algo3.controlador.eventos.ControladorInventario;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;

public class VistaPosicionableBosquejo extends VistaPosicionable {

	public VistaPosicionableBosquejo(Posicionable posicionable, Posicion posicion, int dimension) {
		super(posicionable, posicion, dimension);
	}

	public void removerDeVista() {
		ControladorInventario.getInstance().removerDeBosquejo(this.getPosicion());
	}
	
	public void insertarEnVista(Posicionable posicionable) {
		ControladorInventario.getInstance().posicionarEnBosquejo(posicionable, this.posicion);
	}



}

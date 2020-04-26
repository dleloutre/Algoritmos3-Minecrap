package fiuba.algo3.vista.posicionable;

import fiuba.algo3.controlador.eventos.ControladorInventario;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;

public class VistaPosicionableAlmacen extends VistaPosicionable {

	public VistaPosicionableAlmacen(Posicionable posicionable, Posicion posicion, int dimension) {
		super(posicionable, posicion, dimension);
	}
	
	public void removerDeVista() {
		ControladorInventario.getInstance().removerDeAlmacenamiento(this.getPosicion());
	}
	
	public void insertarEnVista(Posicionable posicionable) {
		ControladorInventario.getInstance().almacenarEn(posicionable, this.posicion);
	}



}

package fiuba.algo3.vista.posicionable;

import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import javafx.scene.image.ImageView;

public abstract class VistaPosicionable extends ImageView {
	
	protected Posicionable posicionable;
	protected Posicion posicion;
	
	public VistaPosicionable(Posicionable posicionable, Posicion posicion, int dimension) {
		this.posicionable = posicionable;
		this.posicion = posicion;
		setFitHeight(dimension);
		setFitWidth(dimension);
	}
	
	public VistaPosicionable(Posicionable posicionable, int dimension) {
		this.posicionable = posicionable;
		setFitHeight(dimension);
		setFitWidth(dimension);
	}

	public Posicionable getPosicionable() {
		return posicionable;
	}

	public Posicion getPosicion() {
		return posicion;
	}
	
	public void intercambiarPosicionesCon(VistaPosicionable otraVista) {
		removerDeVista();
		otraVista.removerDeVista();
		insertarEnVista(otraVista.getPosicionable());
		otraVista.insertarEnVista(this.posicionable);
	}
	
	public abstract void removerDeVista();
	public abstract void insertarEnVista(Posicionable posicionable);
}

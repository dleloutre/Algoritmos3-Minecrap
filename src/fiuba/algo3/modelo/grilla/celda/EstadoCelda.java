package fiuba.algo3.modelo.grilla.celda;

import fiuba.algo3.modelo.grilla.Posicionable;

public abstract class EstadoCelda {
	
	protected Celda celda;
	
	public EstadoCelda(Celda celda) {
		this.celda = celda;
	}
	
	public abstract boolean estaOcupada();
	public abstract Posicionable getPosicionable();
	public abstract void setPosicionable(Posicionable posicionable);
	public abstract boolean moverContenidoDe(Celda otraCelda);
}
